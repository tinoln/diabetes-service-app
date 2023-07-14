package com.tinoln.serviceapp.service;

import com.tinoln.serviceapp.model.Consultation;

import java.util.Collection;

interface ConsultationService {

    Consultation createConsultation(Consultation consulation);
    Collection<Consultation> list(int limit);
    Consultation getConsultation(Long id);
    Consultation updateConsultation(Consultation consulation);
    Boolean deleteConsultation(Long id);

}
