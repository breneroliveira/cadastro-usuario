package br.edu.atitus.pooavancado.cadusuario.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cadastro de Usuários - POO Avançado")
                        .description("Sistema criado em aula")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Brener Augusto de Oliveira")
                                .email("1131754@atitus.edu.br")));
    }
}