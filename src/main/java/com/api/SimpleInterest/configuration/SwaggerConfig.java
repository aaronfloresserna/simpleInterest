/*
 * Aaron Flores
 * Aplazo project
 * 26, Agosto 2021
 */

package com.api.SimpleInterest.configuration;

import com.google.common.base.Predicates;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    /**
     *
     * @return Docket
     */
    @Bean
    public Docket docket(){
        ApiSelectorBuilder builder = new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(metaData())
        .select()
        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")));

        return builder.build();
    }

    /**
     *
     * @return ApiInfo
     */
    private ApiInfo metaData() {

        return new ApiInfoBuilder()
        .title("Simple interest API")
        .contact(new Contact("Aaron Flores", "https://github.com/aaronfloresserna/simpleInterest", "aaron.flores.serna@gmail.com"))
        .description("Simple interest calculator in weekly payments with terms and rate monthly")
        .version("V1.0")
        .build();
    }
}
