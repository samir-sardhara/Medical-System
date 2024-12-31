package com.example.Medical_System.controllers;

import com.example.Medical_System.Services.MedicalServices;
import com.example.Medical_System.models.MedicalBillItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MedicalController {
    @Autowired
    private MedicalServices medicalServices;

    @GetMapping("/item")
    public List<MedicalBillItem> getAllItems(){
        return medicalServices.getAllItems();
    }

    @PostMapping("/add-item")
    public MedicalBillItem addItem(@RequestBody MedicalBillItem item){
        return medicalServices.addItem(item);
    }

    @GetMapping("/item/total-amount")
    public ResponseEntity<Double> getTotalAmount(){
        double totalamount = medicalServices.getTotalAmount();
        return ResponseEntity.ok(totalamount);
    }

    @DeleteMapping("/item/delete/{id}")
    public void deleteItem(@PathVariable long id){
        medicalServices.deleteItem(id);
    }

    @DeleteMapping("/item/delete-all")
    public void  deleteAllItem(){
        medicalServices.deleteAllItem();
    }

    @PutMapping("/item/update/{id}")
    public ResponseEntity<MedicalBillItem> updateItem(@PathVariable long id, @RequestBody MedicalBillItem updatedItem){
        MedicalBillItem result = medicalServices.updateItem(id,updatedItem);
        return ResponseEntity.ok(result);
    }

    @GetMapping("item/total-tax")
    public ResponseEntity<Double> getTotalTax(){
        double totalTax = medicalServices.getTotalTax();
        return ResponseEntity.ok(totalTax);
    }
}
