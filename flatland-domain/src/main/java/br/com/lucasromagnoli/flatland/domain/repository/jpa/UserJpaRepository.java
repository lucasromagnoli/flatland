package br.com.lucasromagnoli.flatland.domain.repository.jpa;

import br.com.lucasromagnoli.flatland.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author github.com/lucasromagnoli
 * @since 15/02/2020
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameIgnoreCase(String username);
}
