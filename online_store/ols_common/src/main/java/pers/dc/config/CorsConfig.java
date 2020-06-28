package pers.dc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {

        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:8080");
        config.addAllowedOrigin("http://35.193.194.133:8080");
        config.addAllowedOrigin("http://35.193.194.133:8080/ols-center");
        config.addAllowedOrigin("http://35.193.194.133:8080/ols-shop");
        config.addAllowedOrigin("http://35.193.194.133");
        config.addAllowedOrigin("http://10.128.0.2");
        config.addAllowedOrigin("*");

        config.setAllowCredentials(true);
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**", config);

        return new CorsFilter(corsSource);
    }
}
