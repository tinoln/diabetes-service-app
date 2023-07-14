package com.tinoln.serviceapp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Consultation {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 protected LocalDateTime timeStamp;

	 @ManyToOne(fetch = FetchType.LAZY)
	 private Patient patient;
	 protected int statusCode;
	 @Column(name = "CONSULTATION_DATE")
	 @Temporal(TemporalType.TIMESTAMP)
	 @DateTimeFormat(style = "M-")
	 protected Calendar consultationDate;
	 @NumberFormat
	 protected BigDecimal bloodGlucose;
	 @NumberFormat
	 protected BigDecimal bloodPressure;
	 @NumberFormat
	 protected BigDecimal weight;
	 @NumberFormat
	 protected BigDecimal height;
	 @NumberFormat
	 protected BigDecimal bmiRange;
	 protected String bmiCoverage;
	 protected String message;
	 protected Map<?, ?> data;

}
