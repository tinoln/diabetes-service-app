package com.tinoln.serviceapp.controller;

import com.tinoln.serviceapp.model.Patient;
import com.tinoln.serviceapp.service.PatientServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/consults-list")
@RequiredArgsConstructor
public class PatientController {

    private final PatientServiceImpl patientService;

    @GetMapping("/list")
    public ResponseEntity<Patient> getPatients(){
        return ResponseEntity.ok(
                Patient.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("employees", patientService.list(10)))
                        .message("Employees retrieved")
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Patient> savePatient(@RequestBody @Valid Patient patient) {
        return ResponseEntity.ok(
                Patient.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("patients", patientService.createPatient(patient)))
                        .message("Patient created")
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Patient.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("patients", patientService.getPatient(id)))
                        .message("Patient retrieved")
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Patient.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("patients", patientService.deletePatient(id)))
                        .message("Patient deleted")
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

}
