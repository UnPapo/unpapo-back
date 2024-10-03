package com.comparsas.unpapo.controller;

import com.comparsas.unpapo.entity.User;
import com.comparsas.unpapo.service.UserService;
import com.comparsas.unpapo.utils.models.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user) throws Exception {
        ApiResponse<User> userApiResponse = userService.createUser(user);
        return ResponseEntity.status(userApiResponse.getStatus()).body(userApiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @RequestBody User user) {
        ApiResponse<User> userApiResponse = userService.updateUser(id, user);
        return ResponseEntity.status(userApiResponse.getStatus()).body(userApiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long id) {
        ApiResponse<User> userApiResponse = userService.getUserById(id);
        return ResponseEntity.status(userApiResponse.getStatus()).body(userApiResponse);
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        ApiResponse<List<User>> userApiResponse = userService.getAllUsers();
        return ResponseEntity.status(userApiResponse.getStatus()).body(userApiResponse);
    }
}
