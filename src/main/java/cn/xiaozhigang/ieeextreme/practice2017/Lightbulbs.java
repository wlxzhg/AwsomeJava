package cn.xiaozhigang.ieeextreme.practice2017;
import java.util.*;
import java.lang.*;

public class Lightbulbs {
    static HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

    static int help(String input) {
        if(input.length() == 1) {
            if(input.equals("1")) return 1;
            else return 0;
        } else if(input.length() == 2) {
            if(input.equals("00")) return 0;
            if(input.equals("01")) return 1;
            if(input.equals("10")) return 3;
            if(input.equals("11")) return 2;
        } else if(input.charAt(0) == '1') { //100000……0的情况
            if(input.substring(1).indexOf('1') == -1)
                return (int)Math.pow(2,input.length()) - 1;
        }

        int ans = 0;
        int indexOfFirstOne = input.indexOf('1');
        if(input.charAt(indexOfFirstOne + 1) == '1') {
            int leftZero = input.length() - indexOfFirstOne - 2;
            Integer steps = map.get(leftZero);
            if(steps == null) {
                steps = (int)Math.pow(2,leftZero + 1) - 1;
                map.put(leftZero,steps);
            }
            ans = help(input.substring(indexOfFirstOne + 2,input.length() - 1)) +
                    1 +
                    steps;
        } else {
            int p = input.substring(1).indexOf(1);
            int steps;
            if(p == input.length() - 1)
                steps = 1;
            else
                steps = help(input.substring(p + 1));
            Integer step1 = map.get(input.length() - 1);
            if(step1 == null) {
                step1 = (int)Math.pow(2,input.length()) - 1;
                map.put(input.length(),step1);
            }
            ans = steps + step1;
        }
        return ans;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(input);
        System.out.println(help(input));
    }
}
