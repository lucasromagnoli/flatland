package br.com.lucasromagnoli.flatland.web.config.init;

import br.com.lucasromagnoli.flatland.domain.config.init.FlatlandDomainInitializer;
import br.com.lucasromagnoli.flatland.web.config.FlatlandWebConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FlatlandApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        Class<?>[] rootConfigClasses = FlatlandDomainInitializer.getRootConfigClasses();

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
