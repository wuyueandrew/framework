package indi.wuyue.framework.singleton;

public class Lazy {

    private static Lazy INSTANCE = null;

    public synchronized static Lazy getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Lazy();
        }
        return INSTANCE;
    }

}
