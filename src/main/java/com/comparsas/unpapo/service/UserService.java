package com.comparsas.unpapo.service;

import com.comparsas.unpapo.entity.Photo;
import com.comparsas.unpapo.entity.User;
import com.comparsas.unpapo.repository.LocationRepository;
import com.comparsas.unpapo.repository.UserRepository;
import com.comparsas.unpapo.utils.models.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    public ApiResponse<User> createUser(User user) throws Exception {
        ApiResponse<User> userApiResponse = new ApiResponse<>();

        if (user.getLocation() != null && user.getLocation().getId() == null) {
            // Persiste a Location antes de persistir o Usuario
            locationRepository.save(user.getLocation());
        }

        if(!user.getPhotos().isEmpty()) {
            List<Photo> photos = new ArrayList<>();
            for (Photo photoUSer : user.getPhotos()) {
                photoUSer.setUser(user);  // Associe cada foto ao usuário
                photos.add(photoUSer);
            }
        }

        if(Objects.isNull(user.getName())) {
            throw new Exception("Nome do usuário não pode ser vazios.");
        }

        userRepository.findByEmail(user.getEmail()).ifPresentOrElse(
                it -> {
                    userApiResponse.of(HttpStatus.BAD_REQUEST, "Usuário já existe! Email já cadastrado.");
                },
                () -> {
                    userRepository.save(user);
                    userApiResponse.of(HttpStatus.CREATED, "Usuário criado com sucesso!");
                }
        );

        return userApiResponse;
    }

    public ApiResponse<User> getUserById(Long id) {
        ApiResponse<User> userApiResponse = new ApiResponse<>();
        userRepository.findById(id).ifPresentOrElse(
            it ->   userApiResponse.of(HttpStatus.OK, "Usuário encontrado!", it),
            () -> userApiResponse.of(HttpStatus.BAD_REQUEST, "Usuário não existe!")
        );

        return userApiResponse;
    }

    public ApiResponse<User> updateUser(Long id, User user) {
        ApiResponse<User> userApiResponse = new ApiResponse<>();
        userRepository.findById(id).ifPresentOrElse(
            it -> {
                user.setId(id);
                userApiResponse.of(HttpStatus.OK, "Usuário atualizado com sucesso!", userRepository.save(user));
            },
            () -> userApiResponse.of(HttpStatus.BAD_REQUEST, "Occorreu um erro ao atualizar o usuário. Tente novamente.")
        );

        return userApiResponse;
    }

    public ApiResponse<List<User>> getAllUsers() {
        ApiResponse<List<User>> userApiResponse = new ApiResponse<>();

        return userApiResponse.of(HttpStatus.OK , userRepository.findAll());
    }
}
