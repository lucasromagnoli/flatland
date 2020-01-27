package br.com.lucasromagnoli.flatland.web.controller.errors;

import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningValidationException;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.MessageType;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.TemplateMessage;
import br.com.lucasromagnoli.javaee.underpinning.rest.support.TemplateMessageSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerRestController {

    @ExceptionHandler(UnderpinningValidationException.class)
    public ResponseEntity<TemplateMessage> handleExcpetion(UnderpinningValidationException ex){
        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .messageType(MessageType.WARNING)
                .payload(ex.getValidation())
                .build()
                .toResponseEntity();
    }
}
