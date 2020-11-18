package indi.wuyue.framework;

import indi.wuyue.framework.bean.User;
import indi.wuyue.framework.bean.UserAnnotation;
import indi.wuyue.framework.bean.UserXML;
import indi.wuyue.framework.starter.Klass;
import indi.wuyue.framework.starter.School;
import indi.wuyue.framework.starter.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TestBeanRunner implements ApplicationRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestBeanRunner.class);

    @Resource
    private User user;

    @Resource
    private UserAnnotation annotation;

    @Resource
    private UserXML userXML;

    @Resource
    private Student student;

    @Resource
    private Klass klass;

    @Resource
    private School school;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("test bean 三种方法");
        LOGGER.info("@Configuration @Bean：{}", user.toString());
        LOGGER.info("@Component：{}", annotation.toString());
        LOGGER.info("XML配置：{}", userXML.toString());
        LOGGER.info(student.toString());
        LOGGER.info(klass.toString());
        LOGGER.info(school.toString());
    }
}
