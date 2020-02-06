package br.com.lucasromagnoli.flatland.web.config;

import br.com.lucasromagnoli.flatland.domain.support.FlatlandPropertiesSupport;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningException;
import br.com.lucasromagnoli.javaee.underpinning.commons.support.RSALoaderSupport;
import br.com.lucasromagnoli.javaee.underpinning.rest.config.UnderpinningJwtRestSecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author github.com/lucasromagnoli
 * @since 01/02/2020
 */
@EnableWebSecurity
public class FlatlandWebSecurityConfig extends UnderpinningJwtRestSecurityConfiguration {

    @Autowired
    FlatlandPropertiesSupport flatlandPropertiesSupport;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/carros/**")
                .antMatchers("/error/**")
                .antMatchers("/v1/**");
    }

    @Override
    public PrivateKey privateKey() throws UnderpinningException {
        return RSALoaderSupport.loadPrivateKey(flatlandPropertiesSupport.getProperty("flatland.web.security.jwt.private.key.path"));
    }

    @Override
    public PublicKey publicKey() throws UnderpinningException {
        return RSALoaderSupport.loadPublicKey(flatlandPropertiesSupport.getProperty("flatland.web.security.jwt.public.key.path"));
    }
}