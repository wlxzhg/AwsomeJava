package cn.xiaozhigang.learn.algorithm.classics;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        //输入数组
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        //插入排序
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[i]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = v;
        }
    }
}
