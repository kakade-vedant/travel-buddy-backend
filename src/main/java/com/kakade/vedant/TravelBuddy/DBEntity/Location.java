package com.kakade.vedant.TravelBuddy.DBEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Location {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    String id;

    @NotNull
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private double latitude;

    @NotNull
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private double longitude;
}
