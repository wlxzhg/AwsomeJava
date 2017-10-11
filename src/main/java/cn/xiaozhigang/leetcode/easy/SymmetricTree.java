package cn.xiaozhigang.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() != 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
