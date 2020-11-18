package indi.wuyue.framework.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setUserName("use @Bean");
        return user;
    }

}
