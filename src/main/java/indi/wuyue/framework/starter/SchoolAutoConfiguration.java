package indi.wuyue.framework.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

public class SchoolAutoConfiguration {

    private final static Logger LOGGER = LoggerFactory.getLogger(SchoolAutoConfiguration.class);

    @Bean
    public Student student100() {
        LOGGER.info("auto configuration");
        return new Student(1, "no1");
    }

    @Bean
    public Klass klass(Student student) {
        LOGGER.info("auto configuration");
        Klass klass = new Klass();
        klass.students = new ArrayList<>();
        klass.getStudents().add(student);
        return klass;
    }

    @Bean
    public School school(Klass klass) {
        LOGGER.info("auto configuration");
        School school = new School();
        school.setClass1(klass);
        return school;
    }

}
