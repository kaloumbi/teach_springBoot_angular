package com.training.mycompany.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDTO {

    private int statusCode;

    private String message;

    private String description;
}
