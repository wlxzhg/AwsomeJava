package cn.xiaozhigang.learn.gramer;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(null);
        String s = queue.poll();
        System.out.println(s == null);
    }
}
