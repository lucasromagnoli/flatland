package br.com.lucasromagnoli.flatland.domain.service;

import br.com.lucasromagnoli.flatland.domain.model.User;
import br.com.lucasromagnoli.flatland.domain.validation.UserValidation;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningException;
import br.com.lucasromagnoli.javaee.underpinning.domain.model.SystemUser;
import br.com.lucasromagnoli.javaee.underpinning.domain.repository.jpa.SystemUserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author github.com/lucasromagnoli
 * @since 14/02/2020
 */
@Service
public class UserService {
    @Autowired
    SystemUserJpaRepository systemUserJpaRepository;

    @Autowired
    UserValidation userValidation;

    @Autowired
    PasswordEncoder passwordEncoder;

    public SystemUser save(User user) throws UnderpinningException {
        SystemUser systemUser = new SystemUser();
        systemUser.setUsername(user.getUsername());
        systemUser.setPassword(passwordEncoder.encode(user.getPassword()));

        userValidation.validateSave(user);
        return systemUserJpaRepository.save(systemUser);
    }
}
