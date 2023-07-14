package com.tinoln.serviceapp.repository;

import com.tinoln.serviceapp.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    Consultation findByIdentity(String identity);
    Consultation findByFirstName(String firstName);
    Consultation findBylastName(String lastName);


}
