package com.example.ex1openfeign.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(
        basePackages = "com.example.ex1openfeign.proxy"
)
public class ProjectConfig {
}
