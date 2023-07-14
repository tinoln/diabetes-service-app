package com.tinoln.serviceapp.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String firstName;
    protected String lastName;
    protected LocalDateTime timeStamp;
    protected String message;
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "patient")
    protected Set<Consultation> consultations = new HashSet<>();
    protected Map<?, ?> data;

}
