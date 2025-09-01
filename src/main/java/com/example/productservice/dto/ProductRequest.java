package com.example.productservice.dto;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
public record ProductRequest(
    @NotBlank String name,
    String description,
    @NotNull @DecimalMin("0.0") BigDecimal price,
    @NotNull @Min(0) Integer stock,
    @NotBlank String sku
) {}