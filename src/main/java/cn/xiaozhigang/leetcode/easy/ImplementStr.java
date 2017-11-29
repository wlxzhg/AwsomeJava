package cn.xiaozhigang.leetcode.easy;

/**
 * 实现String.indexOf(String subStr)函数
 * */
public class ImplementStr {
    public static int strStr(String haystack,String needle) {
        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();

        for (int i = 0; i < (arr1.length - needle.length() + 1); i++) {
            boolean flag = true;
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i + j] != arr2[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag == true) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("hello", "h"));
        System.out.println(strStr("hello", "o"));
        System.out.println(strStr("hello", ""));
        System.out.println(strStr("h", ""));
        System.out.println(strStr("","hello"));
    }
}
