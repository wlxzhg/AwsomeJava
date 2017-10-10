/*Accepted*/
/*˼·��Ҫȥ�������е��ظ�Ԫ�أ��������ĺ�˳��ģ�����ʣ��Ԫ�ظ���
 * �ҵ��ظ���Ԫ�أ�������Ԫ����ǰ�ƶ�
 * */
package cn.xiaozhigang.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] nums) {
		if(nums == null) return 0;
		int length = nums.length;
		int l = 0;
		for(; l < length; l++) {
			if(l + 1 < length && nums[l+1]==nums[l]) {
				int i = l + 1;
				for(i = l + 1; i < length; i++)
					if(nums[i] != nums[l]) break;
				for(int j = i; j < length; j++) 
					nums[j - (i - l - 1)] = nums[j];
				length = length - (i - l - 1);
			} 
		}
		return l;
	}
	public static void main(String[] args) {
		int []nums = {1,1,2,3,5,5,7,8};
		System.out.println(removeDuplicates(new int[4]));
		for(int i : nums) {
			System.out.print(i + " ");
		}
	}
}
