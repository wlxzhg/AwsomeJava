package cn.xiaozhigang.ieeextreme.competiton11;
import javafx.scene.shape.Arc;

import java.util.*;
import java.lang.*;

class Vertex {
    public int val;
    public LinkedList<Integer> linkedNode = new LinkedList<Integer>();
    public Vertex(int val,int...args) {
        this.val = val;
        for (int i : args) {
            linkedNode.add(i);
        }
    }

    @Override
    public String toString() {
        String str = val + " ";
        for (Integer i : linkedNode) {
            str += i + " ";
        }
        return str;
    }
}


public class TheFastAndTheCurious {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfVertex = in.nextInt();
        int numOfEdge = in.nextInt();
        HashMap<Integer,Vertex> map = new HashMap<Integer, Vertex>();
        for (int i = 0; i < numOfEdge; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            Vertex vertex = map.get(s);
            if(vertex == null) {
                vertex = new Vertex(s,e);
                map.put(s,vertex);
            } else {
                vertex.linkedNode.add(e);
            }

            Vertex another = map.get(e);
            if(another == null) {
                another = new Vertex(e,s);
                map.put(e,another);
            } else {
                another.linkedNode.add(s);
            }
        }
        LinkedList<Vertex> linkedNumIsOne = new LinkedList<Vertex>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 1; i <= numOfVertex; i++) {
            Vertex vertex = map.get(i);
            if(vertex != null) {
                if(vertex.linkedNode.size() == 1) {
                    linkedNumIsOne.add(vertex);
                    ans.add(i);
                }
            }
//            System.out.println(vertex.toString());
        }
        while (linkedNumIsOne.size() > 0) {
            Vertex v = linkedNumIsOne.poll();

//            System.out.println("v:"+v.toString());

            int linkedNode = v.linkedNode.poll();

            Vertex linkedVertex = map.get(linkedNode);

//            System.out.println("linkedVertex:"+linkedVertex);

            linkedVertex.linkedNode.remove((Integer) v.val);
            if(linkedVertex.linkedNode.size() == 0) {
                linkedNumIsOne.remove(linkedVertex);
            } else if(linkedVertex.linkedNode.size() == 1) {
                linkedNumIsOne.add(linkedVertex);
//                System.out.println("linkedVertex.val:"+linkedVertex.val);
                ans.add(linkedVertex.val);
            }
        }

        int []ansArr = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++){
            ansArr[i] = ans.get(i);
        }
        Arrays.sort(ansArr);
        for (int i = 0; i < ansArr.length ; i++) {
            System.out.print(ansArr[i]);
            if(i != ansArr.length - 1)
                System.out.println();
        }


//        使用邻接矩阵存储图，耗费空间太多
//        Scanner in = new Scanner(System.in);
//        int numOfVertex = in.nextInt();
//        int numOfEdge = in.nextInt();
//
//        int [][] arr= new int[numOfVertex+1][numOfVertex+1];
//        int [] linkedNum = new int[numOfVertex + 1];
//        for (int edge = 1; edge <= numOfEdge; edge++) {
//            int i = in.nextInt();
//            int j = in.nextInt();
//            arr[i][j] = 1;
//            arr[j][i] = 1;
//            linkedNum[i]++;
//            linkedNum[j]++;
//        }
//        LinkedList<Integer> linkedNumIsOne = new LinkedList<Integer>();
//        for (int i = 1; i < linkedNum.length; i++) {
//            if(linkedNum[i] == 1)
//                linkedNumIsOne.add(i);
//        }
//        while (linkedNumIsOne.size() > 0) {
//            int ve = linkedNumIsOne.poll();
//            for(int i = 1; i < arr[ve].length; i++) {
//                if(arr[ve][i] == 1) {
//                    arr[ve][i] = 0;
//                    arr[i][ve] = 0;
//                    linkedNum[ve]--;
//                    linkedNum[i]--;
//                    if(linkedNum[i] == 1)
//                        linkedNumIsOne.add(i);
//                    break;
//                }
//            }
//        }
//        ArrayList<Integer> ans = new ArrayList<Integer>();
//        for(int i = 1; i < linkedNum.length; i++) {
//            if(linkedNum[i] == 0)
//                ans.add(i);
//        }
//        for (int i = 0; i < ans.size(); i++) {
//            System.out.print(ans.get(i));
//            if(i != ans.size() - 1)
//                System.out.println();
//        }
    }
}
