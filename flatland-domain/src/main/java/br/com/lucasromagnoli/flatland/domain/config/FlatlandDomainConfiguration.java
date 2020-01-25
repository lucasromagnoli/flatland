package br.com.lucasromagnoli.flatland.domain.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        FlatlandDomainConfigurationParameters.PACKAGE_REPOSITORY_JDBC,
        FlatlandDomainConfigurationParameters.PACKAGE_REPOSITORY_JPA,
        FlatlandDomainConfigurationParameters.PACKAGE_VALIDATION
})
public class FlatlandDomainConfiguration {
}
