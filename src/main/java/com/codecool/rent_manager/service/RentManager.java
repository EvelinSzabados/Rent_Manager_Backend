package com.codecool.rent_manager.service;


import com.codecool.rent_manager.model.Product;
import com.codecool.rent_manager.model.Rent;
import com.codecool.rent_manager.model.RentedProducts;
import com.codecool.rent_manager.model.Status;
import com.codecool.rent_manager.repository.ProductRepository;
import com.codecool.rent_manager.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RentManager {

    @Autowired
    RentRepository rentRepository;

    @Autowired
    ProductRepository productRepository;



    public List<Rent> listEveryRent() {
        List<Rent> allRent= rentRepository.findAll();


        for(Rent rent: allRent){
            List<RentedProducts> rentedProductsPerRent = new ArrayList<>();
            for(String prod: rent.getRentedProducts()){

                    Optional<Product> product = productRepository.findById(Long.valueOf(prod));
                    RentedProducts rentedProd = RentedProducts.builder().id(product.get().getId())
                            .cost(product.get().getPrice())
                            .name(product.get().getName()).build();
                    rentedProductsPerRent.add(rentedProd);

                rent.setRentedProductsDetails(rentedProductsPerRent);
            }

        }

        return allRent;
    }

    public List<String> listEveryRentedProduct(){
        List<String> allRentedProducts = new ArrayList<>();
        List<Rent> allRents = rentRepository.findAll();
        for(Rent rent: allRents){
            allRentedProducts.addAll(rent.getRentedProducts());
        }
        return allRentedProducts;
    }
    public  HashMap<String, Integer> createCategoryChart(){
        List<String> allRentedProducts = listEveryRentedProduct();
        HashMap<String, Integer> chartData = new HashMap<>();
        int value = 1;
        for(String id: allRentedProducts){
            Optional<Product> product = productRepository.findById(Long.valueOf(id));
            String categoryName = product.get().getCategory().getCategory_name();
            if(chartData.containsKey(categoryName)){
                chartData.replace(categoryName,chartData.get(categoryName)+1);
            }else{
                chartData.put(categoryName,value);
            }


        }
        return chartData;

    }

    public void updateRent(Rent rent){
        Rent rentToEdit = rentRepository.getOne(rent.getId());
        rentToEdit.setCost(rent.getCost());
        rentToEdit.setCustomer(rent.getCustomer());
        rentToEdit.setStart_date(rent.getStart_date());
        rentToEdit.setEnd_date(rent.getEnd_date());

        rentRepository.save(rentToEdit);

    }

    public void deleteRent(Rent rent){rentRepository.delete(rent);}

//    public void calculateRentCost(Rent rent, Optional<Product> productToEdit){
//        int daysOfRent = rent.getEnd_date().compareTo(rent.getStart_date());
//        int costPerProduct = productToEdit.get().getPrice() * daysOfRent;
//        rent.setCost(rent.getCost()+ costPerProduct);
//    }

    public void addRent(Rent rent) {

        List<String> rented_products = rent.getRentedProducts();
        for (String actualProduct : rented_products) {
            Optional<Product> productToEdit = productRepository.findById(Long.valueOf(actualProduct));
            Status status = new Status(2L, "Rented");
            productToEdit.get().setStatus(status);
//            calculateRentCost(rent,productToEdit);
            rentRepository.save(rent);
        }

    }

    public List<Rent> findByEndDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        formatter.format(date);
        return rentRepository.findAllEnd_dateBeforeAndEnd_dateIsLessThanEqual(date);

    }
}
