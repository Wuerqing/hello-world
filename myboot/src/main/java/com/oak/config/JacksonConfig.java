package com.oak.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;

/**
 * Spring Boot 中默认使用的 json 解析框架是 jackson
 * 以下是jackson对null的处理，前端接收数据，将null
 *{"年龄":null,"笔者":{"id":2,"name":"赵敏","age":null}}  变为
 * {"年龄":"","笔者":{"id":2,"name":"赵敏","age":""}}
 *
 * Configuration 和Bean两个注解 可以将Bean交给spring处理
 */
@Configuration
public class JacksonConfig {
    @Primary
    @Bean
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder){
        ObjectMapper build = builder.createXmlMapper(false).build();
        build.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString("");
            }
        });
        return  build;
    }
}
