package dev.ocode.inventory.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private Long categoryId;
}
