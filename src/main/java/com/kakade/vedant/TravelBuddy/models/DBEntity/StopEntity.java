package com.kakade.vedant.TravelBuddy.models.DBEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class StopEntity {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    String id;

    @NotNull
    String name;

    String locationId;

    String url;
}
