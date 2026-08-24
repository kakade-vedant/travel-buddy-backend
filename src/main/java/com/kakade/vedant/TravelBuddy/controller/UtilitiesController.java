package com.kakade.vedant.TravelBuddy.controller;

import com.kakade.vedant.TravelBuddy.service.UtilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/utilities")
public class UtilitiesController {
    @Autowired
    UtilitiesService utilitiesService;

    @GetMapping("generate-uuid")
    public UUID generateUUID() {
        return utilitiesService.generateUUID();
    }
}
