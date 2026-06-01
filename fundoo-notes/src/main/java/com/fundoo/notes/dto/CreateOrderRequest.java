package com.fundoo.notes.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderRequest {

    @Min(value = 1, message = "Amount must be greater than 0")
    private Integer amount;

    @NotBlank(message = "Plan name is required")
    private String planName;
}