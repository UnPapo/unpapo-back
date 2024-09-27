package com.comparsas.unpapo.utils.dtos;

import com.comparsas.unpapo.utils.enums.Gender;

import java.util.Date;

public record UserRegisterDTO(String name, String email, String password, Date birthDate, Gender gender, String biography, String profissao) {
}
