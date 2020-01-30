package br.com.lucasromagnoli.flatland.domain.config.init;

import br.com.lucasromagnoli.flatland.domain.config.FlatlandDomainJdbcConfiguration;
import br.com.lucasromagnoli.flatland.domain.config.FlatlandDomainJpaConfiguration;
import br.com.lucasromagnoli.flatland.domain.config.FlatlandDomainServiceConfiguration;

/**
 * @author github.com/lucasromagnoli
 * @since 27/01/2020
 */
public class FlatlandDomainInitializer {
    private FlatlandDomainInitializer() {}

    public static Class<?>[] getRootConfigClasses() {
        return new Class[] {
                FlatlandDomainServiceConfiguration.class,
                FlatlandDomainJpaConfiguration.class,
                FlatlandDomainJdbcConfiguration.class
        };
    }
}
