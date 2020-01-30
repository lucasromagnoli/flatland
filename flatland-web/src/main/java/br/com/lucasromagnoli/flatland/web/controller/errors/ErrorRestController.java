package br.com.lucasromagnoli.flatland.web.controller.errors;

import br.com.lucasromagnoli.flatland.domain.support.FlatlandPropertiesSupport;
import br.com.lucasromagnoli.flatland.web.controller.RestControllerMapping;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.MessageType;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.TemplateMessage;
import br.com.lucasromagnoli.javaee.underpinning.rest.support.TemplateMessageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author github.com/lucasromagnoli
 * @since 27/01/2020
 */
@RestController
@RequestMapping(RestControllerMapping.ERROR_PATH_ROOT)
public class ErrorRestController {

    @Autowired
    FlatlandPropertiesSupport flatlandPropertiesSupport;

    @GetMapping(RestControllerMapping.ERROR_PATH_NOT_FOUND)
    public ResponseEntity<TemplateMessage> notFound() {
        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(flatlandPropertiesSupport.getProperty("flatland.web.messages.http.path.not.found"))
                .messageType(MessageType.ERROR)
                .build()
                .toResponseEntity();
    }

    @GetMapping(RestControllerMapping.ERROR_PATH_METHOD_NOT_ALLOWED)
    public ResponseEntity<TemplateMessage> methodNotAllowed() {
        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.METHOD_NOT_ALLOWED)
                .message(flatlandPropertiesSupport.getProperty("flatland.web.messages.http.method.not.allowed"))
                .messageType(MessageType.ERROR)
                .build()
                .toResponseEntity();
    }

    @GetMapping(RestControllerMapping.ERROR_PATH_INTERNAL_SERVER_ERROR)
    public ResponseEntity<TemplateMessage> internalServerError() {
        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.METHOD_NOT_ALLOWED)
                .message(flatlandPropertiesSupport.getProperty("flatland.web.messages.http.internal.server.error"))
                .messageType(MessageType.ERROR)
                .build()
                .toResponseEntity();
    }
}
