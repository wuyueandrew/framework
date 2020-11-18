package indi.wuyue.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyMain {

    private final static Logger LOGGER = LoggerFactory.getLogger(ProxyMain.class);

    public static void main(String[] args) {
        IA a = new AImpl();
        InvocationHandler handler = (proxy, method, args1) -> {
            LOGGER.info("before");
            Object obj = method.invoke(a, args1);
            LOGGER.info("after");
            return obj;
        };
        ClassLoader classLoader = a.getClass().getClassLoader();
        Class[] interfaces = a.getClass().getInterfaces();
        IA aProxy = (IA) Proxy.newProxyInstance(classLoader, interfaces, handler);
        aProxy.hello();
    }

}
