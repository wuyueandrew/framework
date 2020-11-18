package indi.wuyue.framework.singleton;

public class Hungry {

    private final static Hungry INSTANCE = new Hungry();

    public static Hungry getInstance() {
        return INSTANCE;
    }

}
