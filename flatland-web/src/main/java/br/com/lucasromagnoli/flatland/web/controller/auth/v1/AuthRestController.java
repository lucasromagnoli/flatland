package br.com.lucasromagnoli.flatland.web.controller.auth.v1;

import br.com.lucasromagnoli.flatland.domain.support.FlatlandPropertiesSupport;
import br.com.lucasromagnoli.flatland.web.controller.RestControllerMapping;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningException;
import br.com.lucasromagnoli.javaee.underpinning.commons.support.ValidatorSupport;
import br.com.lucasromagnoli.javaee.underpinning.commons.validation.ValidationType;
import br.com.lucasromagnoli.javaee.underpinning.domain.model.SystemUser;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.MessageType;
import br.com.lucasromagnoli.javaee.underpinning.rest.model.TemplateMessage;
import br.com.lucasromagnoli.javaee.underpinning.rest.security.jwt.JwtAuthenticationService;
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
 * @since 01/02/2020
 */
@RestController
@RequestMapping(RestControllerMapping.AUTH_PATH_ROOT_V1)
public class AuthRestController {

    @Autowired
    JwtAuthenticationService jwtAuthenticationService;

    @Autowired
    FlatlandPropertiesSupport flatlandPropertiesSupport;

    @PostMapping(RestControllerMapping.AUTH_PATH_GENERATE_TOKEN)
    public ResponseEntity<TemplateMessage> genereteToken(@RequestBody(required = false) SystemUser systemUser) throws UnderpinningException {
        ValidatorSupport.target(systemUser)
                .field("username", ValidationType.OBJECT_NOT_NULL)
                .field("password", ValidationType.OBJECT_NOT_NULL)
                .validate();

        return TemplateMessageSupport.begin()
                .messageType(MessageType.SUCCESS)
                .message(flatlandPropertiesSupport.getProperty("flatland.web.security.jwt.user.authenticated"))
                .payload(jwtAuthenticationService.authenticateSystemUser(systemUser))
                .httpStatus(HttpStatus.CREATED)
                .build()
                .toResponseEntity();
    }
}
