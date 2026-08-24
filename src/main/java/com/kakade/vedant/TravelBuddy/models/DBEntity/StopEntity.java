package com.kakade.vedant.TravelBuddy.models.DBEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Setter;

@Entity
public class StopEntity {

    @Setter(AccessLevel.NONE)
    @Id
    String id;

    @NotNull
    String name;

    String locationId;

    String url;
}
