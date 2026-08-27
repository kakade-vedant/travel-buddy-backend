package com.kakade.vedant.TravelBuddy.models.RequestEntity;

import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class StopRequest {
    @Nullable
    String id;

    String name;

    LocationRequest location;

    String url;
}
