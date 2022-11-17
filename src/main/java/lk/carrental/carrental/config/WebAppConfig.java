package lk.carrental.carrental.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class WebAppConfig  {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
   
}
