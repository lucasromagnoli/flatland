package br.com.lucasromagnoli.flatland.domain.config;

/**
 * @author github.com/lucasromagnoli
 * @since 27/01/2020
 */
public class FlatlandDomainConfigurationParameters {
    private FlatlandDomainConfigurationParameters() {}

    public static final String PACKAGE_REPOSITORY_JPA                           = "br.com.lucasromagnoli.flatland.domain.repository.jpa";
    public static final String PACKAGE_REPOSITORY_JDBC                          = "br.com.lucasromagnoli.flatland.domain.repository.jdbc.impl";
    public static final String PACKAGE_VALIDATION                               = "br.com.lucasromagnoli.flatland.domain.validation";
    public static final String PACKAGE_MODEL                                    = "br.com.lucasromagnoli.flatland.domain.model";
}
