package br.com.lucasromagnoli.flatland.domain.config.init;

import br.com.lucasromagnoli.flatland.domain.config.FlatlandDomainJdbcConfiguration;
import br.com.lucasromagnoli.flatland.domain.config.FlatlandDomainJpaConfiguration;
import br.com.lucasromagnoli.flatland.domain.config.FlatlandDomainServiceConfiguration;
import br.com.lucasromagnoli.javaee.underpinning.domain.config.init.UnderpinningDomainInitializer;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author github.com/lucasromagnoli
 * @since 27/01/2020
 */
public class FlatlandDomainInitializer {
    private FlatlandDomainInitializer() {}

    public static Class<?>[] getRootConfigClasses() {
        Class<?>[] rootConfigClasses = UnderpinningDomainInitializer.getRootConfigClasses();
        rootConfigClasses = ArrayUtils.add(rootConfigClasses, FlatlandDomainServiceConfiguration.class);
        rootConfigClasses = ArrayUtils.add(rootConfigClasses, FlatlandDomainJpaConfiguration.class);
        rootConfigClasses = ArrayUtils.add(rootConfigClasses, FlatlandDomainJdbcConfiguration.class);

        return rootConfigClasses;
    }
}
