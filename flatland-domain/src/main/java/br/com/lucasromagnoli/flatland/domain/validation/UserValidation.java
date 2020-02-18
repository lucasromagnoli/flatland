package br.com.lucasromagnoli.flatland.domain.validation;

import br.com.lucasromagnoli.flatland.domain.model.User;
import br.com.lucasromagnoli.flatland.domain.service.UserService;
import br.com.lucasromagnoli.flatland.domain.support.FlatlandPropertiesSupport;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningException;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningValidationException;
import br.com.lucasromagnoli.javaee.underpinning.commons.support.RegexSupport;
import br.com.lucasromagnoli.javaee.underpinning.commons.support.ValidationSupport;
import br.com.lucasromagnoli.javaee.underpinning.commons.support.ValidatorSupport;
import br.com.lucasromagnoli.javaee.underpinning.commons.validation.Validation;
import br.com.lucasromagnoli.javaee.underpinning.commons.validation.ValidationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * @author github.com/lucasromagnoli
 * @since 13/02/2020
 */
@Component
public class UserValidation {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    FlatlandPropertiesSupport flatlandPropertiesSupport;

    private Validation validatePassword(User user) throws UnderpinningException {
        return ValidatorSupport.target(user)
                .field("password", ValidationType.OBJECT_EQUALS, user.getConfirmPassword(), "confirmPassword")
                .field("password", ValidationType.STRING_REGEX_MATCH, RegexSupport.STRONG_PASSWORD, Pattern.MULTILINE)
                .validate();
    }

    public void validateSave(User user) throws UnderpinningException {
        Validation validation = validatePassword(user);

        if (userService.existsByUsername(user.getUsername())) {
            validation.rejectField("username", flatlandPropertiesSupport.getProperty("flatland.domain.messages.validation.user.username.alreadyUsed"));
        }

        validation.throwValidationException();
    }

    // TODO: 17/02/2020 - Atualizar a mensagem da exception para .properties
    public void validateUpdate(User user) throws UnderpinningException {
        Validation validation = validatePassword(user);

        if (!passwordEncoder.matches(user.getOldPassword(), userService.findById(user.getId()).getPassword())) {
            validation.rejectField("oldPassword", "Senha antiga não confere");
        }

        validation.throwValidationException();
    }

    // TODO: 17/02/2020 - Atualizar a mensagem da exception para .properties 
    public void validateActiveUser(User user) throws UnderpinningException {
        if (!user.isActive()) {
            ValidationSupport.begin()
                    .details("active", "Este usuário não está ativo")
                    .build()
                    .throwValidationException();
        }
    }

}
