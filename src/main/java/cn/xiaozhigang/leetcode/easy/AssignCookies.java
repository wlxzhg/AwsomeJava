package cn.xiaozhigang.leetcode.easy;

import java.util.Arrays;

public class AssignCookies {
    /**
     * Accepted
     * */
    public static int findContentChildren(int[] g, int[] s) {
        if(g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int num = 0;
        int indexG = 0;
        int indexS = 0;
        while (indexG < g.length && indexS < s.length) {
            if(g[indexG] <= s[indexS]) {
                indexG++;
                indexS++;
                num++;
            } else {
                indexS++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2};
        System.out.println(findContentChildren(g,s));
    }
}
