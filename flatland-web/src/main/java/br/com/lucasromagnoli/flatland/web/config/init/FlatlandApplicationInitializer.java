package br.com.lucasromagnoli.flatland.web.config.init;

import br.com.lucasromagnoli.flatland.domain.config.init.FlatlandDomainInitializer;
import br.com.lucasromagnoli.flatland.web.config.FlatlandWebConfiguration;
import br.com.lucasromagnoli.flatland.web.config.FlatlandWebSecurityConfig;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author github.com/lucasromagnoli
 * @since 27/01/2020
 */
public class FlatlandApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        Class<?>[] rootConfigClasses = FlatlandDomainInitializer.getRootConfigClasses();
        rootConfigClasses = ArrayUtils.add(rootConfigClasses, FlatlandWebSecurityConfig.class);

        return rootConfigClasses;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {
                FlatlandWebConfiguration.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
