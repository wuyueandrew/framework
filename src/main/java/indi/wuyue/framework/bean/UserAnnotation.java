package indi.wuyue.framework.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserAnnotation extends User{

    @PostConstruct
    public void init() {
        this.setId(2L);
        this.setUserName("use @Component");
    }

}
