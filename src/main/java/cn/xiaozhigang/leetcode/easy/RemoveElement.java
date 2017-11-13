package cn.xiaozhigang.leetcode.easy;

/**
 * 题目：去掉数组中指定的元素，返回剩余元素个数
 * */
public class RemoveElement {
    /**
     * 复杂度：o(n)
     * 算法描述：一旦遇到指定值，就将数组最后一个元素放到当前位置，并更新数组有效长度减一
     * */
    public static int removeElement(int[] nums, int val) {
        int newLength = nums.length;
        for (int i = 0; i < newLength; i++) {
            if(nums[i] == val) {
                nums[i] = nums[newLength - 1];
                newLength--;
                i--;
            }
        }
        return newLength;
    }

    public static void main(String[] args) {
        int [] nums = {3,2,2,3};
        int count = removeElement(nums,3);
        for (int i = 0; i < count; i++)
            System.out.println(nums[i]);
    }
}
