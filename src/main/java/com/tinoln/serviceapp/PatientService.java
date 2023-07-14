package com.tinoln.serviceapp;

import com.tinoln.serviceapp.model.Patient;

import java.util.Collection;

public interface PatientService {

    Patient createPatient(Patient patient);
    Collection<Patient> list(int limit);
    Patient getPatient(Long id);
    Patient updatePatient(Patient patient);
    Boolean deletePatient(Long id);

}
