package com.kakade.vedant.TravelBuddy.models.RequestResponse;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Route {
    String id;

    String name;

    String description;

    List<Stop> stops = new ArrayList<>();

    boolean completed;

    String routeUrl;
}
