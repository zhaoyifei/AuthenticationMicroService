package com.zyifly.common.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by
 */
@SuppressWarnings("unchecked")
@EnableSwagger2
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"cn.heartonline.wapapi.controller"})
public class SwaggerConfig {

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("账户服务-api")
                .apiInfo(apiInfo())
                .select()
                .paths(userApiPaths())
                .build();
    }

    @Bean
    public Docket pushApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("提醒服务-api")
                .apiInfo(apiInfo())
                .select()
                .paths(pushApiPaths())
                .build();
    }

    @Bean
    public Docket dataApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("公共服务-api")
                .apiInfo(apiInfo())
                .select()
                .paths(dataApiPaths())
                .build();
    }

    @Bean
    public Docket doctorApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("医生服务-api")
                .apiInfo(apiInfo())
                .select()
                .paths(doctorApiPaths())
                .build();
    }

	private Predicate<String> userApiPaths() {
        return or(
                regex("/account.*")
        );
    }

    private Predicate<String> pushApiPaths() {
        return or(
                regex("/push.*")
        );
    }

    private Predicate<String> dataApiPaths() {
        return or(
                regex("/common.*")
        );
    }

    private Predicate<String> doctorApiPaths() {
        return or(
                regex("/doctor.*")
        );
    }

    @SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Cardio-Union Service API.")
                .description("字符型参数请在客户端做URLencoding处理.")
                .contact("IT-center")
                .version("1.0")
                .build();
    }
}

