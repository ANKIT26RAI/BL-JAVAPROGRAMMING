package com.fundoo.notes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LabelRequest {

    @NotBlank(message = "Label name is required")
    private String name;
}