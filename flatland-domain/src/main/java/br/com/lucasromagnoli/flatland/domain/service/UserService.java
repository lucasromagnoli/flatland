package br.com.lucasromagnoli.flatland.domain.service;

import br.com.lucasromagnoli.flatland.domain.model.User;
import br.com.lucasromagnoli.flatland.domain.repository.jpa.UserJpaRepository;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningAuthenticationFail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author github.com/lucasromagnoli
 * @since 15/02/2020
 */
@Service
public class UserService {
    @Autowired
    UserJpaRepository userJpaRepository;

    // TODO: 15/02/2020 - Atualizar a mensagem da exception para .properties
    public User findByUsername(String username) throws UnderpinningAuthenticationFail {
        return userJpaRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new UnderpinningAuthenticationFail("No users were found with this username"));
    }
}
