package com.kakade.vedant.TravelBuddy.controller;

import com.kakade.vedant.TravelBuddy.models.RequestEntity.RouteRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController {
    public ResponseEntity createRoute(@RequestParam RouteRequest routeEntity) {
        return ResponseEntity.ok("Route Created Successfully!!!");
    }
}
