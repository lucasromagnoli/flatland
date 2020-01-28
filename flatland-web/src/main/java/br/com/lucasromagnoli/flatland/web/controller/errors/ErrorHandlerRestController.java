package br.com.lucasromagnoli.flatland.web.controller.errors;

import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningBadRequestException;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningInternalServerErrorException;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningValidationException;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.MessageType;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.TemplateMessage;
import br.com.lucasromagnoli.javaee.underpinning.rest.support.TemplateMessageSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author github.com/lucasromagnoli
 * @since 27/01/2020
 */
@RestControllerAdvice
public class ErrorHandlerRestController {

    @ExceptionHandler(UnderpinningBadRequestException.class)
    public ResponseEntity<TemplateMessage> handleBadRequestException(UnderpinningBadRequestException ex) {
        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .messageType(MessageType.ERROR)
                .message(ex.getMessage())
                .build()
                .toResponseEntity();
    }

    @ExceptionHandler(UnderpinningInternalServerErrorException.class)
    public ResponseEntity<TemplateMessage> handleInternalServerErrorException(UnderpinningInternalServerErrorException ex) {
        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .messageType(MessageType.ERROR)
                .message(ex.getMessage())
                .build()
                .toResponseEntity();
    }

    @ExceptionHandler(UnderpinningValidationException.class)
    public ResponseEntity<TemplateMessage> handleValidationException(UnderpinningValidationException ex){
        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .messageType(MessageType.WARNING)
                .payload(ex.getValidation())
                .build()
                .toResponseEntity();
    }
}
