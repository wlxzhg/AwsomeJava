package cn.xiaozhigang.ieeextreme.competiton11;
import java.util.*;
import java.lang.*;

public class SubArraySumProblem {
    public static void main(String[] args) {
        int d;
        int [] dim = new int[5];
        for (int i = 0; i < dim.length; i++) dim[i] = 0;
        Scanner in = new Scanner(System.in);
        d = in.nextInt(); //获取维数
        int length = 1;
        for (int i = 0; i < d; i++) { //获取各位长度
            dim[i] = in.nextInt();
            length *= dim[i];      //计算总元素个数
        }
        int[] arr = new int[length];
        for (int i = 0; i < length; i++)  //获取所有元素
            arr[i] = in.nextInt();
        int [] start = new int[5];
        int [] end = new int[5];
        int t = in.nextInt();   //获取测试个数
        for (int index = 0; index < t; index++) {
            for (int i = 0; i < d; i++)  //获取起点
                start[i] = in.nextInt();
            for (int i = 0; i < d; i++)  //获取终点
                end[i] = in.nextInt();
            int [] newStart = new int[5];
            int [] newEnd = new int[5];
            for(int i = 0; i < d; i++) {
                newStart[i] = start[i] < end[i]?start[i]:end[i];
                newEnd[i] = start[i] > end[i]?start[i]:end[i];
            }
            int ans = 0;
             for (int d1 = newStart[0]; d1 <= newEnd[0]; d1++)
                for (int d2 = newStart[1]; d2 <= newEnd[1]; d2++)
                    for (int d3 = newStart[2]; d3 <= newEnd[2]; d3++)
                        for (int d4 = newStart[3]; d4 <= newEnd[3]; d4++)
                            for (int d5 = newStart[4]; d5 <= newEnd[4]; d5++) {
                                int temp = ((((d5 - 1) * dim[4] + (d4 - 1))*dim[3] + (d3 - 1))*dim[2] + (d2 - 1))*dim[1] + d1;
                                ans += arr[temp - 1];
                            }
            System.out.print(ans);
            if(index != t - 1)
                System.out.println();
        }
    }
}
