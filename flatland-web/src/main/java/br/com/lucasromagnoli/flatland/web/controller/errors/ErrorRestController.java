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

import java.util.Date;

@RestController
@RequestMapping(RestControllerMapping.ERROR_PATH_ROOT)
public class ErrorRestController {

    @GetMapping(RestControllerMapping.ERROR_PATH_NOT_FOUND)
    public ResponseEntity<TemplateMessage> notFound() {
        Carro carro = new Carro();
        carro.dataCompra = new Date();
        carro.marca = "Honda";
        carro.nome = "HB20";

        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message("Sorry, we couldn't find that page.")
                .messageType(MessageType.ERROR)
                .build()
                .toResponseEntity();
    }

    @GetMapping(RestControllerMapping.ERROR_PATH_METHOD_NOT_ALLOWED)
    public ResponseEntity<String> methodNotAllowed() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method Not Allowed");
    }

    @GetMapping(RestControllerMapping.ERROR_PATH_INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> internalServerError() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Internal Server Error");
    }
}
