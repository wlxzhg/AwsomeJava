package cn.xiaozhigang.learn.gramer.loadorder;

public class LoadOrderHelp {
    static {
        System.out.println("1:静态块");
        b = 1;
//        System.out.println(b); //Illegal forward reference
    }
    public static int b = 10;
    static {
        System.out.println("2: 静态块 static b = " + b);
        b = 5;
    }

    private int a = 1;
    {
        System.out.println("3:非静态块 a = " + a + " b = " + b);
    }

    {
        System.out.println("4:非静态块 a = " + a);
    }

    public LoadOrderHelp() {
        System.out.println("5:构造函数 a = " + a +" b = " + b);
    }

    public static void main(String[] args) {
        LoadOrderHelp loadOrderHelp = new LoadOrderHelp();
    }
}
