package cn.xiaozhigang.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIntersection {
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0,j = 0; i < nums1.length && j < nums2.length;) {
			if(nums1[i] == nums2[j]) {
				res.add(nums1[i]);
				i++;
				j++;
			} else if(nums1[i] > nums2[j]) {
				j++;
			} else {
				i++;
			}
		}
		int[] result = new int[res.size()];
		int i = 0;
		for(int in : res) {
			result[i++] = in;
		}
		return result;
	}
	
	public static void main(String [] args) {
		ArrayIntersection arrayIntersection = new ArrayIntersection();
		int []n1 = {1,2,2,1};
		int []n2 = {2,2};
		int []result = arrayIntersection.intersect(n1, n2);
		for(int i : result) {
			System.out.print(i+"\t");
		}
	}
}
