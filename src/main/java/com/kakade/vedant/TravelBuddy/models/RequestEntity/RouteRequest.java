package com.kakade.vedant.TravelBuddy.models.RequestEntity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RouteRequest {
    String id;

    String name;

    String description;

    List<StopRequest> stops = new ArrayList<>();

    boolean completed;

    String routeUrl;
}
