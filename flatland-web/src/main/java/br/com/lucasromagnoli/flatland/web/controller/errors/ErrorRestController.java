package br.com.lucasromagnoli.flatland.web.controller.errors;

import br.com.lucasromagnoli.flatland.web.controller.RestControllerMapping;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.MessageType;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.TemplateMessage;
import br.com.lucasromagnoli.javaee.underpinning.rest.support.TemplateMessageSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestControllerMapping.ERROR_PATH_ROOT)
public class ErrorRestController {

    /*
     * TODO: Após incluir as configurações e classe de support:
     *  Atualizar as mensagens de retorno para buscarem dinamicamente do .properties.
     */

    @GetMapping(RestControllerMapping.ERROR_PATH_NOT_FOUND)
    public ResponseEntity<TemplateMessage> notFound() {
        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message("Sorry, we couldn't find that page.")
                .messageType(MessageType.ERROR)
                .build()
                .toResponseEntity();
    }

    @GetMapping(RestControllerMapping.ERROR_PATH_METHOD_NOT_ALLOWED)
    public ResponseEntity<TemplateMessage> methodNotAllowed() {
        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.METHOD_NOT_ALLOWED)
                .message("Sorry, this method are not allowed.")
                .messageType(MessageType.ERROR)
                .build()
                .toResponseEntity();
    }

    @GetMapping(RestControllerMapping.ERROR_PATH_INTERNAL_SERVER_ERROR)
    public ResponseEntity<TemplateMessage> internalServerError() {
        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.METHOD_NOT_ALLOWED)
                .message("Sorry, the server has encountered an internal error and was unable to complete your request.")
                .messageType(MessageType.ERROR)
                .build()
                .toResponseEntity();
    }
}
