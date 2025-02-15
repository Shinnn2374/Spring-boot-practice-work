package com.example.skillboxsixapp.event;

import lombok.Data;

@Data
public class OrderEvent
{
    private String product;
    private Integer quantity;
}
