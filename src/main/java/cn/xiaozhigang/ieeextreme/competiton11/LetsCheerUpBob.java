package cn.xiaozhigang.ieeextreme.competiton11;
import org.omg.PortableInterceptor.INACTIVE;
import sun.java2d.pipe.AATextRenderer;

import java.util.*;
import java.lang.*;

public class LetsCheerUpBob {
    public static int[] help(int a,int b,int c,int []arr2) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = arr2.length - 1; i >= 1; i--)
            stack.addFirst(arr2[i]);
        LinkedList<Integer> bobstep = new LinkedList<Integer>();
        LinkedList<Integer> mystep = new LinkedList<Integer>();
        while (stack.size() > 0) {
            int bob = stack.removeFirst();
            bobstep.add(bob);
//            System.out.println("bob 走"+bob);
            if(bobstep.contains((Integer)a) && bobstep.contains((Integer)b) &&
                    bobstep.contains((Integer)c)) {
//                System.out.println(true);
                break;
            }
            for (int i = 0; i < stack.size(); i++) {
                int thisstep = stack.get(i);
                if(thisstep != a && thisstep != b && thisstep != c) {
                    mystep.add(thisstep);
                    stack.remove(i);
//                    System.out.println("我走"+thisstep);
                    break;
                }
            }
        }
//        for (int i : bobstep) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        int []ans = new int[mystep.size()];
        int j = 0;
        for (int i : mystep) {
            ans[j++] = i;
        }
        return ans;
    }
    public static void main(String[] args) throws java.lang.Exception{
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        int[] arr2 = new int[10];
        for(int i = 1; i < 10; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            arr[i] = (a - 1) * 3 + b;
            arr2[arr[i]] = i;
        }
//        System.out.println("arr:");
//        for(int i = 1; i < 10; i++)
//            System.out.print(arr[i] + " ");
//        System.out.println();
        int minSteps = Integer.MAX_VALUE;
        int []minArray = new int[100];
        for(int i = 1; i <= 7;i+=3){
            int[] array = help(i,i+1,i+2,arr);
            int sum = 0;
            for (int j = 0; j < array.length;j++)
                sum += array[j];

            if(array.length < minArray.length) {
                minArray = array;
                minSteps = sum;
            } else if(array.length == minArray.length) {
                if(sum < minSteps) {
                    minSteps = sum;
                    minArray = array;
                }
            }
        }
        for (int i = 1; i <= 3; i++) {
            int[] array = help(i,i+3,i+6,arr);
            int sum = 0;
            for (int j = 0; j < array.length;j++)
                sum+=array[j];
            if(array.length < minArray.length) {
                minArray = array;
                minSteps = sum;
            } else if(array.length == minArray.length) {

                if(sum < minSteps) {
                    minSteps = sum;
                    minArray = array;
                }
            }

//            int sum = 0;
//            for (int j = 0; j < array.length;j++)
//                sum+=array[j];
//            if(sum < minSteps) {
//                minSteps = sum;
//                minArray = array;
//            }
        }
        int [] array7 = help(1,5,9,arr);
        int sum = 0;
        for (int j = 0; j < array7.length;j++)
            sum+=array7[j];
        if(array7.length < minArray.length) {
            minArray = array7;
            minSteps = sum;
        } else if(array7.length == minArray.length) {

            if(sum < minSteps) {
                minSteps = sum;
                minArray = array7;
            }
        }

//        int sum = 0;
//        for (int j = 0; j < array7.length; j++)
//            sum+=array7[j];
//        if(sum < minSteps) {
//            minSteps = sum;
//            minArray = array7;
//        }

        int [] array8 = help(3,5,7,arr);
        sum = 0;
        for (int j = 0; j < array8.length;j++)
            sum+=array8[j];
        if(array8.length < minArray.length) {
            minArray = array8;
            minSteps = sum;
        } else if(array8.length == minArray.length) {
            if(sum < minSteps) {
                minSteps = sum;
                minArray = array8;
            }
        }
//        sum = 0;
//        for (int j = 0; j < array8.length; j++)
//            sum+=array8[j];
//        if(sum < minSteps) {
//            minSteps = sum;
//            minArray = array8;
//        }
//        System.out.println(Arrays.toString(minArray));
        for (int j = 0; j < minArray.length; j++) {
            String str = "";
            switch (minArray[j]) {
                case 1: str = "1 1";break;
                case 2: str = "1 2";break;
                case 3: str = "1 3";break;
                case 4: str = "2 1";break;
                case 5: str = "2 2";break;
                case 6: str = "2 3";break;
                case 7: str = "3 1";break;
                case 8: str = "3 2";break;
                case 9: str = "3 3";break;
            }
            System.out.print(str);
            if(j != minArray.length - 1)
                System.out.println();
        }
    }
}
