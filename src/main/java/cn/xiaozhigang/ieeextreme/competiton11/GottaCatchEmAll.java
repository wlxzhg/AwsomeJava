package cn.xiaozhigang.ieeextreme.competiton11;
import java.util.*;
import java.lang.*;

public class GottaCatchEmAll {
    //广度优先搜索
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int [][] arr = new int[r][c];
        int [][] maxLength = new int[r][c]; //保存到各个点的距离
        for(int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                arr[i][j] = in.nextInt();
                maxLength[i][j] = Integer.MIN_VALUE;
            }
        maxLength[0][0] = 0;
        maxLength[r - 1][c - 1] = 0;
        //待处理的队列，保存已到达的位置，初始为0（代表(0/c,0%c)）
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        while (queue.size() > 0) {
            int n = queue.poll();
            int i = n / c;
            int j = n % c;
            if(j + 1 < c && maxLength[i][j] + arr[i][j + 1] > maxLength[i][j + 1]) {
                if(maxLength[i][j + 1] == Integer.MIN_VALUE)
                    maxLength[i][j + 1] = 0;
                maxLength[i][j + 1] = maxLength[i][j] + arr[i][j + 1];
                queue.add(i * c + j + 1);
            }
            if(i + 1 < r && maxLength[i][j] + arr[i + 1][j] > maxLength[i + 1][j]){
                if(maxLength[i + 1][j] == Integer.MIN_VALUE)
                    maxLength[i + 1][j] = 0;
                maxLength[i + 1][j] = maxLength[i][j] + arr[i + 1][j];
                queue.add((i + 1) * c + j);
            }
        }
        int ans = 0;
        if(maxLength[r - 2][c - 1] > maxLength[r - 1][c - 2])
            ans = maxLength[r - 2][c - 1];
        else ans = maxLength[r][c - 2];
        if(ans >= 0)
            System.out.print(1);
        else
            System.out.print(ans * (-1) + 1);
    }

    //深度优先搜索，AC了一部分，出了若干超时和运行错误
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int r = in.nextInt();
//        int c = in.nextInt();
//        int [][] arr = new int[r][c];
//        for(int i = 0; i < r; i++)
//            for (int j = 0; j < c; j++) {
//                arr[i][j] = in.nextInt();
//            }
//        int ans = dfs(arr,0,0,0);
//        if(ans >= 0)
//            System.out.print(1);
//        else
//            System.out.print(ans * (-1) + 1);
//    }
//    static int max = Integer.MAX_VALUE;
//    static int dfs(int[][] arr,int i,int j,int num) {
//        if(i == arr.length - 1 && j == arr.length - 1)
//            return num;
//        if(j == arr[0].length - 1)
//            return dfs(arr,i + 1,j,num + arr[i][j]);
//        if(i == arr.length - 1)
//            return dfs(arr,i,j + 1,num + arr[i][j]);
//        int right = dfs(arr,i,j+1,num+arr[i][j]);
//        int down = dfs(arr,i+1,j,num+arr[i][j]);
//        return right>down?right:down;
//    }
}
