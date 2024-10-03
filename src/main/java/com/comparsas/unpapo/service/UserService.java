package com.comparsas.unpapo.service;

import com.comparsas.unpapo.entity.User;
import com.comparsas.unpapo.repository.UserRepository;
import com.comparsas.unpapo.utils.models.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;

    public ApiResponse<User> createUser(User user) throws Exception {
        ApiResponse<User> userApiResponse = new ApiResponse<>();

        if(Objects.isNull(user.getName()) || Objects.isNull(user.getPassword())) {
            throw new Exception("Nome ou senha do usuário não podem ser vazios.");
        }

        userRepository.findByEmail(user.getEmail()).ifPresentOrElse(
                it -> userApiResponse.of(HttpStatus.BAD_REQUEST, "Usuário já existe! Email já cadastrado."),
                () -> {
                    userApiResponse.of(HttpStatus.CREATED, "Usuário criado com sucesso!", userRepository.save(user));
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
