package com.kakade.vedant.TravelBuddy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/utilities")
public class UtilitiesController {

    @GetMapping("generate-uuid")
    public UUID generateUUID() {
        return UUID.randomUUID();
    }
}
