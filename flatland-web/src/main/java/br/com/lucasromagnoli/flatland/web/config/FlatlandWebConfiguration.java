package br.com.lucasromagnoli.flatland.web.config;

/**
 * @author github.com/lucasromagnoli
 * @since 27/01/2020
 */

import br.com.lucasromagnoli.javaee.underpinning.rest.factory.RestObjectMapperFactory;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@ComponentScan(basePackages = {
        FlatlandConfigurationParameters.PACKAGE_WEB_CONTROLLER
})
public class FlatlandWebConfiguration implements WebMvcConfigurer {

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper objectMapper = RestObjectMapperFactory.createObjectMapper();
        // TODO: 13/02/2020 - Atualizar o factory com a configuração abaixo.
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter());
    }
}
