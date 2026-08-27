package com.kakade.vedant.TravelBuddy.models.RequestEntity;

import lombok.Getter;

import java.util.List;

@Getter
public class RouteRequest {
    String id;

    String name;

    String description;

    String url;

    List<StopRequest> stops;

    boolean completed;

    String routeUrl;
}
