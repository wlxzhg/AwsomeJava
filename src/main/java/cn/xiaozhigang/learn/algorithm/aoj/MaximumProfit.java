package cn.xiaozhigang.learn.algorithm.aoj;

import java.util.Scanner;

public class MaximumProfit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int minRate;
        int maxProfit = Integer.MIN_VALUE;
        int r = in.nextInt();
        minRate = r;

        for (int i = 1; i < n; i++) {
            r = in.nextInt();
            maxProfit = (maxProfit > r - minRate)? maxProfit : r - minRate;
            if(r < minRate) minRate = r;
        }
        System.out.print(maxProfit);
    }
}
