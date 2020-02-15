package br.com.lucasromagnoli.flatland.domain.validation;

import br.com.lucasromagnoli.flatland.domain.model.User;
import br.com.lucasromagnoli.flatland.domain.support.FlatlandPropertiesSupport;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningException;
import br.com.lucasromagnoli.javaee.underpinning.commons.support.RegexSupport;
import br.com.lucasromagnoli.javaee.underpinning.commons.support.ValidatorSupport;
import br.com.lucasromagnoli.javaee.underpinning.commons.validation.Validation;
import br.com.lucasromagnoli.javaee.underpinning.commons.validation.ValidationType;
import br.com.lucasromagnoli.javaee.underpinning.domain.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * @author github.com/lucasromagnoli
 * @since 13/02/2020
 */
@Component
public class UserValidation {

    @Autowired
    SystemUserService systemUserService;

    @Autowired
    FlatlandPropertiesSupport flatlandPropertiesSupport;

    public void validateSave(User user) throws UnderpinningException {
        Validation validation = ValidatorSupport.target(user)
                .field("password", ValidationType.OBJECT_EQUALS, user.getConfirmPassword(), "confirmPassword")
                .field("password", ValidationType.STRING_REGEX_MATCH, RegexSupport.STRONG_PASSWORD, Pattern.MULTILINE)
                .validate();

        if (systemUserService.existsByUsername(user.getUsername())) {
            validation.rejectField("username", flatlandPropertiesSupport.getProperty("flatland.domain.messages.validation.user.username.alreadyUsed"));
        }

        validation.throwValidationException();
    }
}
