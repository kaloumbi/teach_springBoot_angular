package com.training.mycompany.dto;

import lombok.Data;

@Data
public class SuccessResponseDTO {

    private int statusCode;

    private String message;

    private String description;
}
