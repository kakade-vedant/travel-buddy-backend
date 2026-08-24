package com.kakade.vedant.TravelBuddy.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtilitiesService {
    public UUID generateUUID() {
        return UUID.randomUUID();
    }
}
