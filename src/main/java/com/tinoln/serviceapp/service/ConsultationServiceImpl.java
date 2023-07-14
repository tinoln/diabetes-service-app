package com.tinoln.serviceapp.service;

import com.tinoln.serviceapp.model.Consultation;
import com.tinoln.serviceapp.repository.ConsultationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public
class ConsultationServiceImpl implements ConsultationService {

    private ConsultationRepository consultationRepository;

    private static BigDecimal bmivalue;
    static BigDecimal rangeBMI(BigDecimal bmi) {
        return bmi;
    }

    static String categoryBMI(BigDecimal weight, BigDecimal height) {

        BigDecimal bmi = weight.divide((height.multiply(height)));
        if (bmi.intValue() < 18.5) {
            bmivalue = rangeBMI(bmi);
            return "Underweight";
        }
        else if (bmi.intValue() < 25) {
            rangeBMI(bmi);
            return "Normal";
        }
        else if (bmi.intValue() < 30) {
            rangeBMI(bmi);
            return "Overweight";
        }
        else {
            rangeBMI(bmi);
            return "Obese";
        }
    }


    @Override
    public Consultation createConsultation(Consultation consultation) {

        log.info("Saving consultation record: {}", consultation.getId());
        consultation.setBloodPressure(consultation.getBloodPressure());
        consultation.setBloodGlucose(consultation.getBloodGlucose());
        consultation.setWeight(consultation.getWeight());
        consultation.setHeight(consultation.getHeight());

        consultation.setBmiRange(rangeBMI(bmivalue));
        consultation.setBmiCategory(categoryBMI(consultation.getWeight(), consultation.getHeight()));
        consultation.setMessage(consultation.getMessage());

        return consultationRepository.save(consultation);

    }

    @Override
    public Collection<Consultation> list(int limit) {
        log.info("Fetching all records");
        return consultationRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Consultation getConsultation(Long id) {
        log.info("Fetching consultation by Id");
        return consultationRepository.findById(id).get();
    }

    @Override
    public Consultation updateConsultation(Consultation consultation) {
        log.info("Updating consultation record; {}", consultation.getId());
        return consultationRepository.save(consultation);
    }

    @Override
    public Boolean deleteConsultation(Long id) {
        log.info("Updating employee record");
        consultationRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
