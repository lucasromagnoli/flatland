package br.com.lucasromagnoli.flatland.domain.model;

import br.com.lucasromagnoli.javaee.underpinning.domain.model.SystemUser;

/**
 * @author github.com/lucasromagnoli
 * @since 13/02/2020
 */
public class User extends SystemUser{

    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
