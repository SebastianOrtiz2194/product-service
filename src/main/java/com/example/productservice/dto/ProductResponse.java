package com.example.productservice.dto;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
public record ProductResponse(
    UUID id,
    String name,
    String description,
    BigDecimal price,
    Integer stock,
    String sku,
    Instant createdAt,
    Instant updatedAt
) {}