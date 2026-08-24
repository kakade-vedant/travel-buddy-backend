package com.kakade.vedant.TravelBuddy.models.RequestEntity;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

public class LocationRequest {
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private double latitude;

    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private double longitude;
}
