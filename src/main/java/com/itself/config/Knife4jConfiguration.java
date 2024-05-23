package com.itself.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Knife4j接口文档配置
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("Springboot-Demo")
                        .description("Knife4j-Apis")
                        .termsOfServiceUrl("https://github.com/Alexei-xie")
                        .contact(new Contact("duJi","https://github.com/Alexei-xie","Alexei_Xie@163.com"))
                        .version("1.0")
                        .build())
                // 分组名称
                .groupName("knife4j")
                .select()
                // 这里指定Controller扫描包路径：只要带有API注解的接口都显示
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}