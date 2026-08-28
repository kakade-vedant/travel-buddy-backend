package com.kakade.vedant.TravelBuddy.models.RequestResponse;

import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class Stop {
    @Nullable
    String id;

    String name;

    Location location;

    String url;
}
