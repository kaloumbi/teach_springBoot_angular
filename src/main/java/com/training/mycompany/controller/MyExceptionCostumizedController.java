package com.training.mycompany.controller;

import com.training.mycompany.dto.ErrorResponseDTO;
import com.training.mycompany.dto.SuccessResponseDTO;
import com.training.mycompany.myexceptions.*;
import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.NotAcceptableStatusException;
import org.springframework.web.server.ServerErrorException;

@ControllerAdvice
public class MyExceptionCostumizedController {


    // Méthode utilitaire pour créer une réponse d'erreur
    private ResponseEntity<ErrorResponseDTO> createErrorResponse(Exception ex, HttpStatus status) {
        ErrorResponseDTO apiErrors = new ErrorResponseDTO();
        apiErrors.setStatusCode(status.value());
        apiErrors.setMessage("Une erreur est survenue !");
        apiErrors.setDescription(ex.getMessage());
        return new ResponseEntity<>(apiErrors, status);
    }

    // Méthode utilitaire pour créer une réponse de Success !
    private ResponseEntity<SuccessResponseDTO> createSuccessResponse(MySuccessException ex, HttpStatus status) {
        SuccessResponseDTO successResp = new SuccessResponseDTO();
        successResp.setStatusCode(status.value());
        successResp.setMessage("Operation completed successfully!");
        successResp.setDescription(ex.getMessage());
        return new ResponseEntity<>(successResp, status);
    }


    //APPEL DE LA MEHTODE DANS TOUTES LES FONCTIONS POUR EVITER LES REPITITIONS !

    @ExceptionHandler(MyNotFoundException.class)
    public final ResponseEntity<ErrorResponseDTO> notFoundError (MyNotFoundException ex, WebRequest request){

        return createErrorResponse (ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponseDTO> serverError (Exception ex, WebRequest request){

        return createErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(MyBadRequestException.class)
    public final ResponseEntity<ErrorResponseDTO> badRequestError (MyBadRequestException ex, WebRequest request){

        return createErrorResponse (ex, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(MyNotAllowedException.class)
    public final ResponseEntity<ErrorResponseDTO> notAllowedMethodError (MyNotAllowedException ex, WebRequest request){


        return createErrorResponse(ex, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MyNotAcceptableStatusException.class)
    public final ResponseEntity<ErrorResponseDTO> notAcceptedError (MyNotAcceptableStatusException ex, WebRequest request){

        return createErrorResponse(ex, HttpStatus.NOT_ACCEPTABLE);
    }



    // Crée une réponse de succès avec un message et un code d'état HTTP 200.
    @ExceptionHandler(MySuccessException.class)
    public ResponseEntity<SuccessResponseDTO> successResponse(MySuccessException ex, WebRequest request) {

        return createSuccessResponse(ex, HttpStatus.OK);
    }



}
