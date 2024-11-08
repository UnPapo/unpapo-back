package com.comparsas.unpapo.utils.dtos;

import com.comparsas.unpapo.entity.User;

public record TokenDTO(String token, User user) {
}
