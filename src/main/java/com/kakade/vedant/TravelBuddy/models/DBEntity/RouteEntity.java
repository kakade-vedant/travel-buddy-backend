package com.kakade.vedant.TravelBuddy.models.DBEntity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class RouteEntity {

    @Setter(AccessLevel.NONE)
    @Id
    String id;

    @NotNull
    String name;

    @Nullable
    String description;

    List<String> stopsId = new ArrayList<>();

    boolean completed = false;

    String routeUrl;
}
