package com.pb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pbourke on 11/11/14.
 */
@Configuration
public class AppConfig {
    @Bean
    public String message() {
        return "This is the message";
    }

    @Bean
    public MessageMaker messageMaker() {
        return new MessageMaker();
    }
}
