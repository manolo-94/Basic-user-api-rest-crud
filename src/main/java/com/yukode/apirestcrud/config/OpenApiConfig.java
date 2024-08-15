package com.yukode.apirestcrud.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenApi(){
        
        return new OpenAPI()
                .info( new Info()
                .title("Api Rest CRUD")
                .version("1.0.0")
                .description("Basic User Api Rest.")
                );
    }
    

}
