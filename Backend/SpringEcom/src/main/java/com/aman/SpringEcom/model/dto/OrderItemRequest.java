package com.aman.SpringEcom.model.dto;

public record OrderItemRequest (
        int productId,
        int quantity
){}