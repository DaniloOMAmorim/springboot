package com.example.springboot.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProductDTO(
        String id,
        @NotBlank(message = "name must not be empty")
        String name,
        @NotNull(message = "price must not be empty")
        float price,
        @NotNull(message = "code must not be empty")
        int code) {
}