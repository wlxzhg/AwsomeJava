package cn.xiaozhigang.ieeextreme.competiton11;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        long [] arr = new long[60];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 10;
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long m = in.nextLong();
            System.out.print(arr[(int)(m % 60 - 1)]);
            if(i != t - 1)
                System.out.println();
        }
    }
}
