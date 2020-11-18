package indi.wuyue.framework.starter;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import indi.wuyue.framework.aop.ISchool;

import javax.annotation.Resource;

@Data
public class School implements ISchool {
    
    // Resource 
    @Autowired(required = true) //primary
    Klass class1;
    
    @Resource(name = "student100")
    Student student100;
    
    @Override
    public void ding(){
    
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
        
    }
    
}
