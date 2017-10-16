package cn.xiaozhigang.ieeextreme.competiton11;

import java.util.LinkedList;
import java.util.Scanner;

public class VangelisTheBatbear {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int times = 0; times < t; times++) {
            int numOfVertex = in.nextInt();
            int numOfEdge = in.nextInt();

            int [][] arr= new int[numOfVertex][numOfVertex];
            int [] linkedNum = new int[numOfVertex];
            for (int edge = 0; edge < numOfEdge; edge++) {
                int i = in.nextInt();
                int j = in.nextInt();
                arr[i][j] = 1;
                arr[j][i] = 1;
                linkedNum[i]++;
                linkedNum[j]++;
            }
//            for(int i = 0; i < linkedNum.length; i++) {
//                System.out.print(linkedNum[i] + " ");
//            }
//            System.out.println();
            if(numOfVertex < numOfEdge) {
                System.out.print(1);
                if(times < t - 1)
                    System.out.println();
                continue;
            }
            LinkedList<Integer> linkedNumIsOne = new LinkedList<Integer>();
            for (int i = 0; i < linkedNum.length; i++) {
                if(linkedNum[i] == 1)
                    linkedNumIsOne.add(i);
            }
            System.out.println("----------------------");
            printArr(arr);
            System.out.println("----------------------");
            while (linkedNumIsOne.size() > 0) {
                int ve = linkedNumIsOne.poll();
                for(int i = 0; i < arr[ve].length; i++) {
                    if(arr[ve][i] == 1) {
                        arr[ve][i] = 0;
                        arr[i][ve] = 0;
                        linkedNum[ve]--;
                        linkedNum[i]--;
                        if(linkedNum[i] == 1)
                            linkedNumIsOne.add(i);
                        break;
                    }
                }
                System.out.println("----------------------");
                printArr(arr);
                System.out.println("----------------------");
            }
            boolean flag = false;
            for(int i = 0; i < linkedNum.length; i++) {
                System.out.print(linkedNum[i] + " ");
                if(linkedNum[i] >= 1) {
                    flag = true;
                    break;
                }
            }
            System.out.println();
            System.out.print(flag?1:0);
            if(times < t - 1)
                System.out.println();
        }
    }

    static void printArr(int[][]arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
