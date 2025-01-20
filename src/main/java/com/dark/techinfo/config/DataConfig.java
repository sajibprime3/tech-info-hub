package com.dark.techinfo.config;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {
    
    @Bean
    Faker faker() {
        return new Faker();
    }
    
    
}
