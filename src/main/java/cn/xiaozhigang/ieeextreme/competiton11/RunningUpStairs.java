package cn.xiaozhigang.ieeextreme.competiton11;

import java.math.BigInteger;
import java.util.Scanner;

public class RunningUpStairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            for (int i = 0; i < t;i++){
                int n = in.nextInt();
                if(n == 1 || n == 2) {
                    System.out.print(n);
                    if(i != t - 1)
                        System.out.println();
                    continue;
                }
                BigInteger a = new BigInteger("1");
                BigInteger b = new BigInteger("2");
                BigInteger result = new BigInteger("0");
                for (int index = 0; index < n - 2;index++) {
                    result = a.add(b);
                    a = b;
                    b = result;
                }
                System.out.print(result);
                if(i != t - 1)
                    System.out.println();
        }
    }
}
