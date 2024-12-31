package com.example.Medical_System.Services;

import com.example.Medical_System.models.MedicalBillItem;
import com.example.Medical_System.repositorys.MedicalItemRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServices {
    @Autowired
    private MedicalItemRepositorys medicalItemRepositorys;
    public List<MedicalBillItem> getAllItems(){
        return medicalItemRepositorys.findAll();
    }
    public MedicalBillItem addItem(MedicalBillItem item){
        return  medicalItemRepositorys.save(item);
    }
    public double getTotalAmount(){
        List<MedicalBillItem> items = medicalItemRepositorys.findAll();
        double value = items.stream()
                .mapToDouble(item -> item.getQuantity() * item.getRate())
                .sum();
        double roundValue = Math.round(value * 100.0) / 100.0;
        return roundValue;
    }
    public double getTotalTax(){
        List<MedicalBillItem> items = medicalItemRepositorys.findAll();
        double value = items.stream()
                .mapToDouble(item -> item.getTax())
                .sum();
        double roundValue = Math.round(value * 100.0) / 100.0;
        return roundValue;
    }
    public void deleteItem(long id){
        medicalItemRepositorys.deleteById(id);
    }
    public MedicalBillItem getItemById(long id){
        return medicalItemRepositorys.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }
    public MedicalBillItem updateItem(long id,MedicalBillItem updateItem){
        MedicalBillItem existingItem = getItemById(id);
        existingItem.setTitle(updateItem.getTitle());
        existingItem.setRate(updateItem.getRate());
        existingItem.setQuantity(updateItem.getQuantity());
        return medicalItemRepositorys.save(existingItem);
    }
    public void deleteAllItem(){
        medicalItemRepositorys.deleteAll();
    }
}
