package pers.dc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("pers.dc.controller"))
                .paths(PathSelectors.any()).build()
                .apiInfo(new ApiInfoBuilder().description("電商網站後台API")
                        .contact(new Contact("Darvis Ching",
                                "https://github.com/davisching",
                                "darvisching@gmail.com"))
                        .version("v1.0").title("API 文檔").build());
    }
}
