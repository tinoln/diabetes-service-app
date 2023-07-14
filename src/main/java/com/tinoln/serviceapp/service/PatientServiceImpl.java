package com.tinoln.serviceapp.service;

import com.tinoln.serviceapp.PatientService;
import com.tinoln.serviceapp.model.Patient;
import com.tinoln.serviceapp.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Override
    public Patient createPatient(Patient patient) {

        log.info("Saving patient record: {}", patient.getId());
        patient.setFirstName(patient.getFirstName());
        patient.setLastName(patient.getLastName());
        patient.setTimeStamp(patient.getTimeStamp());
        patient.setMessage(patient.getMessage());
        patient.setConsultations(patient.getConsultations());
        patient.setConsultations(patient.getConsultations());

        return patientRepository.save(patient);
    }

    @Override
    public Collection<Patient> list(int limit) {
        log.info("Fetching all records");
        return patientRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Patient getPatient(Long id) {
        log.info("Fetching patient by Id");
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient updatePatient(Patient patient) {
        log.info("Updating patient record; {}", patient.getId());
        return patientRepository.save(patient);
    }

    @Override
    public Boolean deletePatient(Long id) {

        log.info("Updating employee record");
        patientRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
