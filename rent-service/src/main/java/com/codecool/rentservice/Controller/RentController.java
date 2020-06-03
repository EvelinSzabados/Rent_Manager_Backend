package com.codecool.rentservice.Controller;

import com.codecool.rentservice.Model.Rent;
import com.codecool.rentservice.Service.RentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "http://localhost:8888"})
@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    RentManager rentManager;


    @GetMapping("/all")
    public List<Rent> getAllProducts() {
        return rentManager.listEveryRent();
    }

    @GetMapping("/rentedProducts")
    public HashMap<String, Integer> getRentedProducts(){return rentManager.createCategoryChart();}

    @PutMapping("/modify")
    public void modifyRent(@RequestBody Rent rent) {
        rentManager.updateRent(rent);
    }

    @DeleteMapping("/delete")
    public void deleteRent(@RequestBody Rent rent) {
        rentManager.deleteRent(rent);
    }

    @PostMapping("/add")
    public void addRent(@RequestBody Rent rent) { rentManager.addRent(rent); }

    @GetMapping("/notification")
    public List<Rent> getNotification(){return rentManager.findByEndDate();}
}

