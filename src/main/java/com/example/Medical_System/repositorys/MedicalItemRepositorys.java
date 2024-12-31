package com.example.Medical_System.repositorys;

import com.example.Medical_System.models.MedicalBillItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalItemRepositorys extends JpaRepository<MedicalBillItem,Long> {

}
