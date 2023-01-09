package ua.com.foxminded.volodymyrtolpiekin.universitycms.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
