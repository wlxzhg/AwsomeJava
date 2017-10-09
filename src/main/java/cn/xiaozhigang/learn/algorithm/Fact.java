package cn.xiaozhigang.learn.algorithm;

public class Fact {
    /**
     * 递归方式实现求阶乘
     * @param n 求的阶乘
     * @return 求得的阶乘
     * */
    public static int fact(int n) {
        if(n <= 1) return 1;
        return n * fact(n - 1);
    }

    private static final int[] FIB = new int[100];
    /**
     * 求斐波那契数列的第n项
     * @param n 要求的项
     * */
    public static int fib(int n) {
        if(n <= 1) return n;
        if(FIB[n] != 0) return FIB[n];
        FIB[n] = fib(n - 1) + fib(n - 2);
        return FIB[n];
    }

    public static void main(String[] args) {
        System.out.println(Fact.fact(10));
        for (int i = 0; i < 10; i++)
            System.out.print(Fact.fib(i) + " ");
        System.out.println();
    }
}
