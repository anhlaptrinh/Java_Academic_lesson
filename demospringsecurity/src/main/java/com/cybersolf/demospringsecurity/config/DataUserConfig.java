package com.cybersolf.demospringsecurity.config;

import com.cybersolf.demospringsecurity.model.UserModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataUserConfig {
    @Bean
    public UserModel getUserModel(){
        UserModel userModel = new UserModel();
        userModel.setUsername("admin");
        userModel.setPassword("123");
        return userModel;
    }
}
