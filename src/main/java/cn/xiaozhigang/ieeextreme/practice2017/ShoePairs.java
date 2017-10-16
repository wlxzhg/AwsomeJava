package cn.xiaozhigang.ieeextreme.practice2017;

import java.util.HashMap;
import java.util.Scanner;

class Help {
    public Integer numOfRight;
    public Integer numOfLeft;
    public Help(Integer r,Integer l) {
        numOfRight = r;
        numOfLeft = l;
    }

    @Override
    public String toString() {
        return "Help{" +
                "numOfRight=" + numOfRight +
                ", numOfLeft=" + numOfLeft +
                '}';
    }
}

public class ShoePairs {
    public static void main(String[] args) {
        HashMap<Integer,Help> map = new HashMap<Integer, Help>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        while (n > 0) {
            int a = in.nextInt();
            String s = in.next();
            n--;
            Help help = map.get(a);
            if(help == null) {
                if(s.equals("R"))
                    map.put(a,new Help(1,0));
                else
                    map.put(a,new Help(0,1));
            } else if(s.equals("R")) {
                if(help.numOfLeft > 0){
                    help.numOfLeft--;
                    ans++;
                }
                else
                    help.numOfRight++;
            } else if(s.equals("L")) {
                if(help.numOfRight > 0){
                    help.numOfRight--;
                    ans++;
                }
                else
                    help.numOfLeft++;
            }
        }
        in.close();
//        System.out.println(map);
        System.out.println(ans);

    }
}
