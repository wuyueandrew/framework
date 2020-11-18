package indi.wuyue.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AImpl implements IA {

    private final static Logger LOGGER = LoggerFactory.getLogger(AImpl.class);

    @Override
    public void hello() {
        LOGGER.info("hello!");
    }

}
