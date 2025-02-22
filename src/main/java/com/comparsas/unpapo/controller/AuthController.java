package com.comparsas.unpapo.controller;

import com.comparsas.unpapo.entity.User;
import com.comparsas.unpapo.repository.UserRepository;
import com.comparsas.unpapo.service.UserService;
import com.comparsas.unpapo.utils.UserMapper;
import com.comparsas.unpapo.utils.dtos.TokenDTO;
import com.comparsas.unpapo.utils.dtos.UserLoginDTO;
import com.comparsas.unpapo.utils.dtos.UserRegisterDTO;
import com.comparsas.unpapo.utils.models.ApiResponse;
import com.comparsas.unpapo.utils.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenDTO>> login(@RequestBody UserLoginDTO userLoginDTO) {
        User user = userRepository.findByEmail(userLoginDTO.email()).orElseThrow(() -> new RuntimeException("Usuário nao encontrado."));
        ApiResponse<TokenDTO> apiResponse = new ApiResponse<>();
        if(passwordEncoder.matches(userLoginDTO.password(), user.getPassword())) {

            TokenDTO token = new TokenDTO(tokenService.generateToken(user), user);


            return ResponseEntity.ok(apiResponse.of(HttpStatus.OK, "Login efetuado com sucesso!", token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<User>> register(@RequestBody UserRegisterDTO userRegisterDTO) throws Exception {
        User user = UserMapper.toEntity(userRegisterDTO);

        if(userRegisterDTO.password() == null || userRegisterDTO.password().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        ApiResponse<User> userApiResponse = userService.createUser(user);

        return ResponseEntity.status(userApiResponse.getStatus()).body(userApiResponse);
    }

}
