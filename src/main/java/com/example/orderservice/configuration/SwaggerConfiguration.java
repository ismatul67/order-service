package com.example.orderservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    private static final String SWAGGER_INFO_TITLE = "Order Service";
    private static final String SWAGGER_INFO_DESCRIPTION = "API sandbox";
    private static final String SWAGGER_INFO_VERSION = "v1.11";
    private static final String SWAGGER_INFO_TERMS = "http://swagger.io/terms/";
    private static final String SWAGGER_CONTACT_NAME = "Ismatul Maula";
    private static final String SWAGGER_CONTACT_EMAIL = "ismatulmaula67@gmail.com";
    private static final String SWAGGER_CONTACT_LICENSE = "Apache 2.0";
    private static final String SWAGGER_CONTACT_LICENSE_URI = "http://www.apache.org/licenses/LICENSE-2.0";
    public static final Tag TAG_ORDER = new Tag("Order APIs", "Provide Order APIs Operations.");
    public static final Tag TAG_PRODUCT = new Tag("Product APIs", "Provide Product APIs Operations.");
    public static final Tag TAG_USER = new Tag("User APIs", "Provide User APIs Operations.");
    @Value("${swagger.host}")
    private String swaggerHost;

    @Bean
    public Docket docket() {
        return getBaseDocket()
                .select()
                .build().groupName("All APIs")
                .tags(TAG_ORDER,TAG_PRODUCT,TAG_USER);
    }

    private ApiInfo getApiInfo() {
        
        return new ApiInfo(SWAGGER_INFO_TITLE, SWAGGER_INFO_DESCRIPTION, SWAGGER_INFO_VERSION, SWAGGER_INFO_TERMS,
                new Contact(SWAGGER_CONTACT_NAME, "", SWAGGER_CONTACT_EMAIL),
                SWAGGER_CONTACT_LICENSE, SWAGGER_CONTACT_LICENSE_URI, Collections.emptyList());
    }


    private Docket getBaseDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerHost)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.orderservice.controller"))
                .build()
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(false);
    }
}
