package com.oak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//spring springfox 版本不兼容
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 指定构建api文档的详细信息的方法：apiInfo()
                .select()
                // 指定要生成api接口的包路径，这里把controller作为包路径，生成controller中的所有接口
                .apis(RequestHandlerSelectors.basePackage("com.oak.controller"))
                .paths(PathSelectors.any())
                .build();
    }

/*
*
     * 构建api文档的详细信息
     * @return
*/


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置页面标题
                .title("spring boot 集成swagger2接口总览")
                // 设置接口描述
                .description("学习spring boot 第06课")
                // 设置联系方式
                .contact("吴董 1109")
                // 设置版本
                .version("1.0")
                // 构建
                .build();
    }

}
