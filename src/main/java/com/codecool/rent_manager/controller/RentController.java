package com.codecool.rent_manager.controller;

import com.codecool.rent_manager.model.Rent;
import com.codecool.rent_manager.service.RentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
