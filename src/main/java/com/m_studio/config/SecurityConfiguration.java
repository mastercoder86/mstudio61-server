package com.m_studio.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfiguration {

//    @Value("${cors.allowedMethods}")
//    private String allowedMethods;
//
//    @Value("${cors.allowedHeaders}")
//    private String allowedHeaders;
//
//    @Value("${cors.corsConfiguration}")
//    private String corsConfiguration;

//	@Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        //config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");         //'*' allows all endpoints, Provide your URL/endpoint, if any.
//        config.addAllowedHeader("*");         
//        config.addAllowedMethod("POST");   //add the methods you want to allow like 'GET', 'PUT',etc. using similar statements.
//        config.addAllowedMethod("GET");
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
}