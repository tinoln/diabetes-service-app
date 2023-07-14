package com.tinoln.serviceapp.controller;

import com.tinoln.serviceapp.model.Consultation;
import com.tinoln.serviceapp.model.Patient;
import com.tinoln.serviceapp.service.ConsultationServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/consults-list")
@RequiredArgsConstructor
public class ConsultationController {

    private final Logger LOGGER = LoggerFactory.getLogger(ConsultationController.class);
    private final ConsultationServiceImpl consultationService;

    @GetMapping("/list")
    public ResponseEntity<Response> getEmployees(){
        return ResponseEntity.ok(
                Patient.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("Consultations", consultationService.list(10)))
                    .message("Consultations retrieved")
                    .statusCode(HttpStatus.OK.value())
                    .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Patient> saveConsultation(@RequestBody @Valid Consultation consultation) {
        return ResponseEntity.ok(
                Patient.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("consultation", consultationService.createConsultation(consultation)))
                    .message("Consultation created")
                    .statusCode(HttpStatus.CREATED.value())
                    .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Patient> getConsultation(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Patient.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("consultations", consultationService.getConsultation(id)))
                    .message("Consultation retrieved")
                    .statusCode(HttpStatus.OK.value())
                    .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Patient> deleteConsultation(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Patient.builder()
                    .timeStamp(LocalDateTime.now())
                    .data(Map.of("deleted", consultationService.deleteConsultation(id)))
                    .message("Employee deleted")
                    .statusCode(HttpStatus.OK.value())
                    .build()
        );
    }

}
