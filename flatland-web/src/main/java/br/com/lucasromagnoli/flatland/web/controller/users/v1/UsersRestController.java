package br.com.lucasromagnoli.flatland.web.controller.users.v1;

import br.com.lucasromagnoli.flatland.domain.model.User;
import br.com.lucasromagnoli.flatland.domain.service.UserService;
import br.com.lucasromagnoli.flatland.domain.support.FlatlandPropertiesSupport;
import br.com.lucasromagnoli.flatland.web.controller.RestControllerMapping;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningException;
import br.com.lucasromagnoli.javaee.underpinning.commons.support.ValidatorSupport;
import br.com.lucasromagnoli.javaee.underpinning.commons.validation.ValidationType;
import br.com.lucasromagnoli.javaee.underpinning.domain.model.SystemUser;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.MessageType;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.TemplateMessage;
import br.com.lucasromagnoli.javaee.underpinning.rest.security.jwt.JwtAuthenticatedUser;
import br.com.lucasromagnoli.javaee.underpinning.rest.support.TemplateMessageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * @author github.com/lucasromagnoli
 * @since 13/02/2020
 */
@RestController
@RequestMapping(RestControllerMapping.V1_USERS_PATH_ROOT)
public class UsersRestController {
    @Autowired
    UserService userService;

    @Autowired
    FlatlandPropertiesSupport flatlandPropertiesSupport;

    @GetMapping
    public ResponseEntity<TemplateMessage> index(@AuthenticationPrincipal JwtAuthenticatedUser authenticatedUser) throws UnderpinningException {

        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.OK)
                .messageType(MessageType.SUCCESS)
                .message(flatlandPropertiesSupport.getProperty("flatland.web.messages.user.details"))
                .payload(userService.findById(authenticatedUser.getId()))
                .build()
                .toResponseEntity();
    }

    @PostMapping
    public ResponseEntity<TemplateMessage> create(@RequestBody(required = false) User user) throws UnderpinningException {
        ValidatorSupport.target(user)
                .field("username", ValidationType.OBJECT_NOT_NULL)
                .field("username", ValidationType.STRING_BETWEEN_LENGTH, 5, 30)
                .field("password", ValidationType.OBJECT_NOT_NULL)
                .field("confirmPassword", ValidationType.OBJECT_NOT_NULL)
                .validate()
                .throwValidationException();

        SystemUser systemUser = userService.save(user);
        return TemplateMessageSupport.begin()
                .httpStatus(HttpStatus.CREATED)
                .messageType(MessageType.SUCCESS)
                .message(flatlandPropertiesSupport.getProperty("flatland.web.messages.user.created"))
                .payload(systemUser)
                .build()
                .toResponseEntity();
    }

    @PutMapping
    public ResponseEntity<TemplateMessage> update(@RequestBody(required = false) User user, @AuthenticationPrincipal JwtAuthenticatedUser authenticatedUser) throws UnderpinningException {
        ValidatorSupport.target(user)
                .field("password", ValidationType.OBJECT_NOT_NULL)
                .field("confirmPassword", ValidationType.OBJECT_NOT_NULL)
                .field("oldPassword", ValidationType.OBJECT_NOT_NULL)
                .validate()
                .throwValidationException();

        user.setId(authenticatedUser.getId());
        return TemplateMessageSupport.begin()
                        .httpStatus(HttpStatus.OK)
                        .messageType(MessageType.SUCCESS)
                        .message("Usuário atualizado com sucesso!")
                        .payload(userService.update(user))
                        .build()
                        .toResponseEntity();
    }

    @DeleteMapping
    public ResponseEntity<TemplateMessage> delete(@AuthenticationPrincipal JwtAuthenticatedUser authenticatedUser) throws UnderpinningException {
        userService.delete(authenticatedUser.getId());
        return TemplateMessageSupport.begin()
                        .httpStatus(HttpStatus.OK)
                        .messageType(MessageType.SUCCESS)
                        .message("Usuário excluido com sucesso")
                        .build()
                        .toResponseEntity();
    }
}
