package com.company.handler;

import com.company.dto.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //Handle rest exception
    @ExceptionHandler(value
            = {Exception.class})
    public ResponseEntity<ErrorDTO> handleValidationException(Exception ex, WebRequest request) {
        ErrorDTO errorDTO = handleException((ServletWebRequest) request, ex.getMessage());
        return ResponseEntity.ok(errorDTO);
    }

    private ErrorDTO handleException(ServletWebRequest request, String message) {
        return new ErrorDTO(message,
                request.getRequest().getRequestURI()
                , new Date());
    }

}