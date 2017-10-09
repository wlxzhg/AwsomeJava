package cn.xiaozhigang.learn.gramer;

abstract class Base {
    abstract void func1();

    abstract int func2();

    String func3() {
        return "func3";
    }
}

class Son extends Base{
    void func1() {
        System.out.println("func1");
    }

    int func2() {
        System.out.println("func2");
        return 0;
    }

    @Override
    String func3() {
        return "func3 from son";
    }
}
public class AbstractDemo {
    public static void main(String[] args) {
        Base son = new Son();
        son.func1();
        son.func2();
        System.out.println(son.func3());
    }
}
