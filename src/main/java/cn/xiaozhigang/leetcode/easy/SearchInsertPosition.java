package cn.xiaozhigang.leetcode.easy;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(target <= nums[i])
                return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println("start");
        System.out.println(searchInsert(new int[] {1,3,5,6},5));
        System.out.println(searchInsert(new int[] {1,3,5,6},2));
        System.out.println(searchInsert(new int[] {1,3,5,6},7));
        System.out.println(searchInsert(new int[] {1,3,5,6},0));
        System.out.println(searchInsert(new int[] {1,3},4));
        System.out.println("end");
    }
}
