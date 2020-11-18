package indi.wuyue.framework.singleton;

public class DoubleCheck {

    private static DoubleCheck INSTANCE;

    public static DoubleCheck getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheck.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheck();
                }
            }
        }
        return INSTANCE;
    }
}
