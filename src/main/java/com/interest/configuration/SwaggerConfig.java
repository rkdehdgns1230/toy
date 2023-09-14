package com.interest.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "커뮤니티 서비스 API 명세서",
        description = "커뮤니티 서비스 API 명세서",
        version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi postApiGroup(){
        String[] paths = { "/api/v1/**" };

        return GroupedOpenApi.builder()
                .group("커뮤니티 서비스 API")
                .pathsToMatch(paths)
                .build();
    }
}
