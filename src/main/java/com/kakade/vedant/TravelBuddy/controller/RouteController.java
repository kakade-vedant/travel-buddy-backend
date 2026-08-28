package com.kakade.vedant.TravelBuddy.controller;

import com.kakade.vedant.TravelBuddy.exception.IdModificationException;
import com.kakade.vedant.TravelBuddy.exception.ItemNotFoundException;
import com.kakade.vedant.TravelBuddy.models.DBEntity.RouteEntity;
import com.kakade.vedant.TravelBuddy.models.MetaData.RouteMetaData;
import com.kakade.vedant.TravelBuddy.models.RequestResponse.Route;
import com.kakade.vedant.TravelBuddy.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    RouteService routeService;

    @PostMapping("create")
    public ResponseEntity createRoute(@RequestBody Route route) {
        try {
            RouteEntity routeEntity = routeService.createRoute(route);

            URI location = routeService.getURI(routeEntity);

            return ResponseEntity.created(location).body(routeEntity);
        } catch (IdModificationException idModificationException) {
            return ResponseEntity.badRequest().build();
        } catch (ItemNotFoundException itemNotFoundException) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getRoute(@PathVariable String id) {
        try {
            RouteEntity routeEntity = routeService.getRoute(id);

            return ResponseEntity.ok(routeEntity);
        } catch (ItemNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("all")
    public ResponseEntity getAllRoutes() {
        List<RouteEntity> routeEntity = routeService.getAllRoutes();
        return ResponseEntity.ok(routeEntity);
    }

    @GetMapping("all/meta-data")
    public ResponseEntity getRouteMetaData() {
        List<RouteMetaData> metaData = routeService.getAllRoutesMetaData();
        return ResponseEntity.ok(metaData);
    }

}
