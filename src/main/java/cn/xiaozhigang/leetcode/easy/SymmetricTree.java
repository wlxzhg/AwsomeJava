package cn.xiaozhigang.leetcode.easy;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SymmetricTree {
    public void dfs(int index,TreeNode root,HashMap<Integer,TreeNode> map) {
        if(root == null) return;
        if(root.left != null) {
            map.put(index * 2,root.left);
            dfs(index * 2,root.left,map);
        }
        if(root.right != null) {
            map.put(index * 2 + 1,root.right);
            dfs(index * 2 + 1,root.right,map);
        }
    }

    public int getRelatedNum(int num) {
        if(num == 1) return 1;
        int time = 0;
        int temp = num;
        while (temp > 0) {
            temp = temp / 2;
            time++;
        }
        return (int) (Math.pow(2,time - 1) + Math.pow(2,time) - 1 - num);
    }

    public boolean isSymmetric(TreeNode root) {
        HashMap<Integer,TreeNode> map = new HashMap<Integer, TreeNode>();
        dfs(1,root,map);
        Set<Map.Entry<Integer, TreeNode>> set= map.entrySet();
        for (Map.Entry<Integer,TreeNode> entry : set) {
            TreeNode node = entry.getValue();
            int index = entry.getKey();
            TreeNode node1 = map.get(getRelatedNum(index));
            if(node1 == null || node1.val != node.val)
                return false;
        }
        return true;
    }

    /**
     * 思路不对
     * */
    public static boolean isSymmetric3(TreeNode root) {
        if(root == null) return true;
        if(root.right == null && root.left == null) return true;
        HashMap<Integer,TreeNode> trees = new HashMap<Integer, TreeNode>();
        if(root.left != null) trees.put(1,root.left);
        if(root.right != null) trees.put(2,root.right);
        int nodesNums = 2;
        while (trees.size() > 0) {
            HashMap<Integer,TreeNode> tempTrees = new HashMap<Integer, TreeNode>();
            Set<Map.Entry<Integer, TreeNode>> set= trees.entrySet();
            int i = 1;
            for (Map.Entry<Integer,TreeNode> entry : set) {
                TreeNode node = entry.getValue();
                TreeNode anotherNode = trees.get(nodesNums - entry.getKey() + 1);
                if(anotherNode == null || node.val != anotherNode.val) return false;
                if (node.left != null)
                    tempTrees.put(i,node.left);
                i++;
                if (node.right != null)
                    tempTrees.put(i,node.right);
                i++;
            }
            if(tempTrees.size() == 0) return true;
            else trees = tempTrees;
            nodesNums = nodesNums * 2;
        }
        return false;
    }

    /**
     * 超时
     */
    public static boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int[] valueArr = new int[1000];
        queue.add(root);
        while (queue.size() != 0) {
            int size = queue.size();
            int[] valueArr2 = valueArr;
            if(size > 1000){
                valueArr2 = new int[size];
            }
            boolean isAllNull = true;
            for (int i = 0; i < size; i++) {
                Object node = queue.poll();
                if(node == null){
                    valueArr2[i] = 0;
                    queue.add(null);
                    queue.add(null);
                } else {
                    valueArr2[i] = ((TreeNode) node).val;
                    isAllNull = false;
                    queue.add(((TreeNode) node).left);
                    queue.add(((TreeNode) node).right);
                }
            }
            if(isAllNull) return true;
            for (int i = 0; i < size/2; i++) {
                if(valueArr2[i] != valueArr2[size - 1 - i])
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
