package com.comparsas.unpapo.controller;

import com.comparsas.unpapo.entity.Location;
import com.comparsas.unpapo.service.LocationService;
import com.comparsas.unpapo.utils.models.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    @PostMapping("")
    private ResponseEntity<ApiResponse<Location>> createLocation(@RequestBody Location location) {
        ApiResponse<Location> apiResponse = locationService.createLocation(location);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ApiResponse<Location>> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        ApiResponse<Location> apiResponse = locationService.updateLocation(id, location);
        return  ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ApiResponse<Location>> getLocationById(@PathVariable Long id){
        ApiResponse<Location> apiResponse = locationService.getLocationById(id);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @GetMapping("")
    private ResponseEntity<ApiResponse<List<Location>>> getAllLocations(){
        ApiResponse<List<Location>> apiResponse = locationService.getAllLocations();
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

}
