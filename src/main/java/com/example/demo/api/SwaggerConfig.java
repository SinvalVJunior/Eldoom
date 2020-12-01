package com.example.demo.api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        Info info = new Info().title("Eldoom").description("API REST para envio de trabalhos acadêmicos")
                .version("v1.0.0")
                .license(new License().name("Apache 2.0").url("https://www.apache.org/licesen.html"));
        ExternalDocumentation extDoc = new ExternalDocumentation()
                .description("Eldoom")
                .url("https://chat.google.com/room/AAAA7dStE7Y");
        return new OpenAPI().info(info).externalDocs(extDoc);
    }
}
