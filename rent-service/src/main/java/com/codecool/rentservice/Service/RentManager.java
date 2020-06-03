package com.codecool.rentservice.Service;

import com.codecool.rentservice.Model.Customer;
import com.codecool.rentservice.Model.Rent;
import com.codecool.rentservice.Model.Status;
import com.codecool.rentservice.Repository.CustomerCaller;
import com.codecool.rentservice.Repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class RentManager {

    @Autowired
    RentRepository rentRepository;

    @Autowired
    CustomerCaller customerCaller;


    public List<Rent> listEveryRent() {
        List<Rent> allRent = rentRepository.findAll();
//        addProductDetailsToRent(allRent,false);
        for(Rent rent : allRent){
            Customer customer = customerCaller.getCustomerById("/" + rent.getCustomer_id());
            rent.setCustomer(customer);
        }

        return allRent;
    }


    public List<String> listEveryRentedProduct() {
        List<String> allRentedProducts = new ArrayList<>();
        List<Rent> allRents = rentRepository.findAll();
        for (Rent rent : allRents) {
            allRentedProducts.addAll(rent.getRentedProducts());
        }

        //TODO: refactor to stream
        return allRentedProducts;
    }
//
//    public HashMap<String, Integer> createCategoryChart() {
//        List<String> allRentedProducts = listEveryRentedProduct();
//        HashMap<String, Integer> chartData = new HashMap<>();
//        int value = 1;
//        for (String id : allRentedProducts) {
//            Optional<Product> product = productRepository.findById(Long.valueOf(id));
//            String categoryName = product.get().getCategory().getCategory_name();
//            if (chartData.containsKey(categoryName)) {
//                chartData.replace(categoryName, chartData.get(categoryName) + 1);
//            } else {
//                chartData.put(categoryName, value);
//            }
//
//
//        }
//        return chartData;
//
//    }

    public void updateRent(Rent rent) {
        Rent rentToEdit = rentRepository.getOne(rent.getId());
        rentToEdit.setCost(rent.getCost());
        rentToEdit.setCustomer(rent.getCustomer());
        rentToEdit.setStart_date(rent.getStart_date());
        rentToEdit.setEndDate(rent.getEndDate());
        customerCaller.updateCustomer(rent.getCustomer());
        rentRepository.save(rentToEdit);

    }

    public void deleteRent(Rent rent) {
        rentRepository.delete(rent);
    }


//    public void addRent(Rent rent) {
//
//        List<String> rented_products = rent.getRentedProducts();
//        for (String actualProduct : rented_products) {
//            Optional<Product> productToEdit = productRepository.findById(Long.valueOf(actualProduct));
//            Status status = new Status(2L, "Rented");
//            productToEdit.get().setStatus(status);
////            calculateRentCost(rent,productToEdit);
//            rentRepository.save(rent);
//        }
//
//    }

    public List<Rent> findByEndDate() {
        LocalDate date = LocalDate.now();
        List<Rent> allRent = rentRepository.findByEndDateIsLessThanEqual(date);

//        addProductDetailsToRent(allRent,true);
        List<Rent> filteredRents = new ArrayList<>();
        for(Rent rent: allRent){
            if(rent.getRentedProductsDetails() != null && !rent.isBack()){
                filteredRents.add(rent);

            }
        }

        return filteredRents;

    }

//    private void addProductDetailsToRent(List<Rent> allRent,boolean statusAvailable) {
//        for (Rent rent : allRent) {
//            List<RentedProducts> rentedProductsPerRent = new ArrayList<>();
//            for (String prod : rent.getRentedProducts()) {
//
//                Optional<Product> product = productRepository.findById(Long.valueOf(prod));
//                if(statusAvailable){
//                    if(product.get().getStatus().getId() != 1){
//                        RentedProducts rentedProd = RentedProducts.builder().id(product.get().getId())
//                                .cost(product.get().getPrice())
//                                .name(product.get().getName())
//                                .status(product.get().getStatus())
//                                .build();
//                        rentedProductsPerRent.add(rentedProd);
//                        if(rentedProductsPerRent.size() !=0){
//
//                        }
//                        rent.setRentedProductsDetails(rentedProductsPerRent);
//                    }
//                }else{
//                    RentedProducts rentedProd = RentedProducts.builder().id(product.get().getId())
//                            .cost(product.get().getPrice())
//                            .name(product.get().getName()).status(product.get().getStatus()).build();
//                    rentedProductsPerRent.add(rentedProd);
//
//                    rent.setRentedProductsDetails(rentedProductsPerRent);
//                }
//
//            }
//
//        }
//    }

}
