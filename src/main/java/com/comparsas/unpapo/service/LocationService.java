package com.comparsas.unpapo.service;

import com.comparsas.unpapo.entity.Location;
import com.comparsas.unpapo.repository.LocationRepository;
import com.comparsas.unpapo.utils.models.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.NativeQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public ApiResponse<Location> createLocation(Location location) {
        ApiResponse<Location> response = new ApiResponse<>();

        if(location.isValid()){
            return response.of(HttpStatus.CREATED, "Localização criada com sucesso", locationRepository.save(location));
        }

        return response.of(HttpStatus.BAD_REQUEST, "Preencha todos os campos!");
    }

    public ApiResponse<Location> updateLocation(Long id, Location location) {
        ApiResponse<Location> response = new ApiResponse<>();

        locationRepository.findById(id).ifPresentOrElse(
            it-> {
                location.setId(id);
                response.of(HttpStatus.OK,  "Atualizado com sucesso", locationRepository.save(location));
            },
            ()-> response.of(HttpStatus.BAD_REQUEST,  "Occorreu um erro ao atualizar a localização.")
        );

        return response;
    }

    public ApiResponse<Location> getLocationById(Long id) {
        ApiResponse<Location> response = new ApiResponse<>();

        locationRepository.findById(id).ifPresentOrElse(
                it -> response.of(HttpStatus.OK, "Localização encontrada", it),
                () -> response.of(HttpStatus.NOT_FOUND, "Localização não existente")
        );

        return response;
    }

    public ApiResponse<List<Location>> getAllLocations() {
        ApiResponse<List<Location>> response = new ApiResponse<>();

        response.of(HttpStatus.OK, locationRepository.findAll());

        return response;
    }
}
