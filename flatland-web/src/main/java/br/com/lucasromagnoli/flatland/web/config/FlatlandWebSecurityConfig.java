package br.com.lucasromagnoli.flatland.web.config;

import br.com.lucasromagnoli.flatland.domain.support.FlatlandPropertiesSupport;
import br.com.lucasromagnoli.javaee.underpinning.commons.exception.UnderpinningException;
import br.com.lucasromagnoli.javaee.underpinning.commons.support.RSALoaderSupport;
import br.com.lucasromagnoli.javaee.underpinning.rest.security.jwt.JwtSecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author github.com/lucasromagnoli
 * @since 01/02/2020
 */
@EnableWebSecurity
public class FlatlandWebSecurityConfig extends JwtSecurityConfiguration {

    @Autowired
    FlatlandPropertiesSupport flatlandPropertiesSupport;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/error/**")
                .antMatchers("/v1/**");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                    .anyRequest()
                        .authenticated()
                .and()
                    .addFilterBefore(jwtGrantAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .exceptionHandling()
                        .authenticationEntryPoint(jwtAuthenticationExceptionHandler())
                        .accessDeniedHandler(jwtAuthenticationExceptionHandler());
    }

    @Override
    public PrivateKey privateKey() throws UnderpinningException {
        return RSALoaderSupport.loadPrivateKey(flatlandPropertiesSupport.getProperty("flatland.web.security.jwt.private.key.path"));
    }

    @Override
    public PublicKey publicKey() throws UnderpinningException {
        return RSALoaderSupport.loadPublicKey(flatlandPropertiesSupport.getProperty("flatland.web.security.jwt.public.key.path"));
    }

    @Override
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}