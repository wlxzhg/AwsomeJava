package cn.xiaozhigang.ieeextreme.competiton11;

import java.util.Scanner;

public class QuipuFunction {
    public static int quipu(long n,long d) {
        boolean f = (n < d);
        if(n == d) {
            return 1;
        }
        int ans = 0;
        int a = (int)Math.sqrt(n);
        if(a * a == n) {
            ans++;
            a--;
        }
        for(int i = 1; i <= a; i++) {
            if(n % i == 0) {
                if(f) {
                    ans+=2;
                } else {
                    long j = n / i;
                    if(i % d != 0) ans++;
                    if(j % d != 0) ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        long a = in.nextLong();
        long b = in.nextLong();
        for(int i = 0; i < t; i++) {
            int d = in.nextInt();
            int total = 0;
            for(long j = a; j <= b; j++) {
                total += quipu(j,d);
            }
            System.out.print(total);
            if(i != t-1)
                System.out.println();
        }
    }
}
