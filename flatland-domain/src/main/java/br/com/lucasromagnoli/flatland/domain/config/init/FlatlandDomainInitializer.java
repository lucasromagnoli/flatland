package br.com.lucasromagnoli.flatland.domain.config.init;

import br.com.lucasromagnoli.flatland.domain.config.FlatlandDomainConfiguration;

public class FlatlandDomainInitializer {
    private FlatlandDomainInitializer() {}

    public static Class<?>[] getRootConfigClasses() {
        return new Class[] {
                FlatlandDomainConfiguration.class
        };
    }
}
