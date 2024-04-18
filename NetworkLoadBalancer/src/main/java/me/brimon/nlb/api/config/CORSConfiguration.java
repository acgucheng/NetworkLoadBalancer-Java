package me.brimon.nlb.api.config;

/* This class is used to configure CORS for the application Rest API. */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfiguration {

        /* This method is used to configure CORS for the application. */
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    /* This method is used to configure CORS for the application. */
                    registry.addMapping("/**")
                            .allowedOrigins("http://localhost", "http://localhost:3000")
                            .allowedMethods("GET", "POST", "PUT", "DELETE");
                }
            };
        }
}
