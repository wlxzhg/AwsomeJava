package cn.xiaozhigang.leetcode.easy;

public class CountAndSay38 {
    public String nextTerm(String str) {
        char[] arr = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        char now = arr[0];
        int len = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == now) {
                len++;
            } else {
                stringBuilder.append(String.valueOf(len));
                stringBuilder.append(now);
                len = 1;
                now = arr[i];
            }
        }
        stringBuilder.append(String.valueOf(len));
        stringBuilder.append(arr[arr.length - 1]);
        return stringBuilder.toString();
    }

    public String countAndSay(int n) {
        String begin = "1";
        for (int i = 1; i < n; i++) {
            begin = nextTerm(begin);
        }
        return begin;
    }

    public static void main(String[] args) {
        CountAndSay38 countAndSay38 = new CountAndSay38();
        System.out.println(countAndSay38.countAndSay(5));
//        System.out.println(countAndSay38.nextTerm("1"));
//        System.out.println(countAndSay38.nextTerm("11"));
//        System.out.println(countAndSay38.nextTerm("21"));
//        System.out.println(countAndSay38.nextTerm("1211"));
//        System.out.println(countAndSay38.nextTerm("111221"));
//        System.out.println(countAndSay38.nextTerm("312211"));


    }
}
