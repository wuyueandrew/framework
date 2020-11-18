package indi.wuyue.framework.singleton;

public class InnerClass {

    private static class InnerClassHolder {
        private final static InnerClass INSTANCE = new InnerClass();
    }

    public InnerClass getInstance() {
        return InnerClassHolder.INSTANCE;
    }

}
