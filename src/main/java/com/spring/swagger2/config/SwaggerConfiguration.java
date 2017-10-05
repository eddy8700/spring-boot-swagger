package com.spring.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by aditya.gupta2 on 10/5/2017.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket tradeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors
                        .basePackage("com.spring.swagger2.controller"))
                .paths(regex("/trade.*")).build().apiInfo(metaData());

    }

    private ApiInfo metaData() {
        ApiInfo apiInfo1= ApiInfo.DEFAULT;
        return apiInfo1;
      /*  ApiInfo apiInfo = new ApiInfo("Spring Boot Rest Swagger Demo",
                "Spring boot trade setup using swagger", "1.0", "Terms of Service",
                new Contact("Aditya Gupta", "https://github.com/eddy8700/", "****8700@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
*/
    }

}
