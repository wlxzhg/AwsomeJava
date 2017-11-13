package cn.xiaozhigang.util;

public class TwoTupleTest {
    public static TwoTuple<Integer,Integer> bigestTwoNum(int[] arr) {
        if (arr.length <= 1) return new TwoTuple<Integer,Integer>(null,null);
        int first = 0,second = 0;
        first = (arr[0] > arr[1])?arr[0]:arr[1];
        second = (arr[0] < arr[1])?arr[0]:arr[1];
        for (int i = 2; i < arr.length; i++) {
            if(arr[i] > first) {
                second = first;
                first = arr[i];
            } else if(arr[i] > second) {
                second = arr[i];
            }
        }
        return new TwoTuple<Integer,Integer>(first,second);
    }

    public static void main(String[] args) {
        int [] arr = {1,2,100,3,37,-10,4,34};
        TwoTuple<Integer,Integer> t = bigestTwoNum(arr);
        System.out.println(t.toString());
        System.out.println(maxValue(arr));
        double [] arr2 = {1.2,100.99,-89.8,8888.233,250,-17};
        System.out.println(maxValue(arr2));
    }

    public static int maxValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if(i > max)
                max = i;
        }
        return max;
    }

    public static double maxValue(double[] arr) {
        double max = arr[0];
        for (double d : arr) {
            if(d > max) max = d;
        }
        return max;
    }
}
