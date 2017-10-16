package cn.xiaozhigang.ieeextreme.competiton11;

import java.util.Arrays;
import java.util.Scanner;

class Help implements Comparable<Help>{
    public String name;
    public int height;
    public Help(String name,int height) {
        this.name = name;
        this.height = height;
    }

    public int compareTo(Help other) {
        if(height == other.height) {
            return name.compareTo(other.name);
        }
        else
            return height > other.height?1:-1;
    }
}
public class BlackgatePenitentiary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Help [] helps = new Help[n];
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int h = in.nextInt();
            helps[i] = new Help(name,h);
        }
        Arrays.sort(helps);
        int lastLine = 0;
        for (int i = 0; i < helps.length; i++) {
            if (helps[i].height == helps[lastLine].height) {
                System.out.print(helps[i].name + " ");
            } else {
                System.out.println((lastLine+1) + " " + i);
                System.out.print(helps[i].name + " ");
                lastLine = i;
            }
            if(i == helps.length - 1) {
                System.out.print((lastLine+1) + " " + (i + 1));
            }
        }

//        for (int i = 0; i < helps.length; i++) {
//            System.out.println(helps[i].name + " " + helps[i].height);
//
//        }
    }
}
