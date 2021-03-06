package br.com.lucasromagnoli.flatland.domain.service;

import br.com.lucasromagnoli.flatland.domain.model.User;
import br.com.lucasromagnoli.flatland.domain.repository.jpa.UserJpaRepository;
import br.com.lucasromagnoli.flatland.domain.validation.UserValidation;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningAuthenticationFail;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author github.com/lucasromagnoli
 * @since 15/02/2020
 */
@Service
public class UserService {
    @Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    UserValidation userValidation;

    @Autowired
    PasswordEncoder passwordEncoder;

    // TODO: 15/02/2020 - Atualizar a mensagem da exception para .properties
    public User findByUsername(String username) throws UnderpinningException {
        User user = userJpaRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new UnderpinningAuthenticationFail("No users were found with this username"));

        userValidation.validateActiveUser(user);
        return user;
    }

    public User save(User user) throws UnderpinningException {
        userValidation.validateSave(user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userJpaRepository.save(user);
    }

    public User findById(Long id) throws UnderpinningException {
        return userJpaRepository.findById(id)
                .orElseThrow(() -> new UnderpinningException("No user were found with this id"));
    }

    public User update(User user) throws UnderpinningException {
        userValidation.validateUpdate(user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userJpaRepository.save(user);
    }

    public void delete(Long id) throws UnderpinningException {
        User user = findById(id);
        user.setActive(false);

        userJpaRepository.save(user);
    }

    public Boolean existsByUsername(String username) {
        return userJpaRepository.existsByUsernameIgnoreCase(username);
    }

}
