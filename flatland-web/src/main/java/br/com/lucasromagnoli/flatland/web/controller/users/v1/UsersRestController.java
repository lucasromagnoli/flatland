package br.com.lucasromagnoli.flatland.web.controller.users.v1;

import br.com.lucasromagnoli.flatland.domain.model.User;
import br.com.lucasromagnoli.flatland.domain.validation.UserValidation;
import br.com.lucasromagnoli.flatland.web.controller.RestControllerMapping;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningException;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.MessageType;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.TemplateMessage;
import br.com.lucasromagnoli.javaee.underpinning.rest.support.TemplateMessageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author github.com/lucasromagnoli
 * @since 13/02/2020
 */
@RestController
@RequestMapping(RestControllerMapping.V1_USERS_PATH_ROOT)
public class UsersRestController {
    @Autowired
    UserValidation userValidation;

    @PostMapping
    public ResponseEntity<TemplateMessage> create(@RequestBody(required = false) User user) throws UnderpinningException {
        userValidation.validateSave(user);
        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.CREATED)
                .messageType(MessageType.SUCCESS)
                .message("Usuário cadastrado com sucesso!")
                .payload(user)
                .build()
                .toResponseEntity();
    }
}
