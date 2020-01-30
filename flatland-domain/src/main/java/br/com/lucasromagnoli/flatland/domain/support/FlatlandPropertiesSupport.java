package br.com.lucasromagnoli.flatland.domain.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author github.com/lucasromagnoli
 * @since 29/01/2020
 */
@Configuration
@PropertySource(value = "classpath:br/com/lucasromagnoli/flatland/flatland-domain-messages.properties", encoding = "UTF-8")
@PropertySource(value = "classpath:br/com/lucasromagnoli/flatland/flatland-web-messages.properties", encoding = "UTF-8")
public class FlatlandPropertiesSupport {

    @Autowired
    private Environment env;

    public String getProperty(String key) {
        return env.getProperty(key);
    }
}