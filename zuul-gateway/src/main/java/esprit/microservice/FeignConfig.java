package esprit.microservice;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public BasicAuthRequestInterceptor mBasicAuthRequestInterceptor(){
        return  new BasicAuthRequestInterceptor("test", "test");
    }

}

