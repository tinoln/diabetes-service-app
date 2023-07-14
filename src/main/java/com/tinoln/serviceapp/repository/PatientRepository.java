package com.tinoln.serviceapp.repository;

import com.tinoln.serviceapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByIdentity(BigDecimal id);
    Patient findByFirstName(String firstName);
    Patient findBylastName(String lastName);

}
