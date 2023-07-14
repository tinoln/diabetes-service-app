package com.tinoln.serviceapp.service;

import com.tinoln.serviceapp.model.Patient;

import java.util.Collection;

interface PatientService {

    Patient createPatient(Patient patient);
    Collection<Patient> list(int limit);
    Patient getPatient(Long id);
    Patient updatePatient(Patient Patient);
    Boolean deletePatient(Long id);

}
