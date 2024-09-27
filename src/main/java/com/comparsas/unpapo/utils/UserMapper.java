package com.comparsas.unpapo.utils;

import com.comparsas.unpapo.entity.User;
import com.comparsas.unpapo.utils.dtos.UserRegisterDTO;

public class UserMapper {
    public static User toEntity(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setName(userRegisterDTO.name());
        user.setPassword(userRegisterDTO.password());
        user.setBirthDate(userRegisterDTO.birthDate());
        user.setEmail(userRegisterDTO.email());
        user.setGender(userRegisterDTO.gender());
        user.setBiography(userRegisterDTO.biography());
        user.setProfissao(userRegisterDTO.profissao());
        user.setStatus(true);
        return user;
    }
}
