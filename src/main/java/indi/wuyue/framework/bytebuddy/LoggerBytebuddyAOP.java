package indi.wuyue.framework.bytebuddy;

import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.slf4j.Logger;

import java.lang.reflect.Field;

public class LoggerBytebuddyAOP {

    @Advice.OnMethodEnter
    public static void log(@Advice.Origin Class clazz) throws Exception {
        Class superClazz = clazz.getSuperclass();
        Field[] fields = clazz.getDeclaredFields();
        Field field = null;
        System.out.println(fields.length);
        for (Field f : fields) {
            System.out.println(f.toGenericString());
            if (f.getDeclaringClass().equals(Logger.class)) {
                field = f;
                field.setAccessible(true);
            }
        }
        if (field != null) {
            Logger log = (Logger) field.get(clazz);
            log.info("invoke");
        }
        System.out.println(clazz.toString());

        System.out.println("======");
    }


    public static void main(String[] args) throws Exception {
        ByteBuddyAgent.install();
        new ByteBuddy()
                .subclass(XXService.class)
                .method(ElementMatchers.named("doService"))
                .intercept(Advice.to(LoggerBytebuddyAOP.class))
                .make()
                .load(XXService.class.getClassLoader())
                .getLoaded()
                .newInstance()
                .doService();

    }
}
