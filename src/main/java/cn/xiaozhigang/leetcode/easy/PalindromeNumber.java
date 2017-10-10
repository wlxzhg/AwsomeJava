/*Accepted*/
package cn.xiaozhigang.leetcode.easy;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		if(x < 0) return false;
		int temp = x;
		long reverse = 0;
		while(x != 0) {
			reverse = (reverse * 10) + (x % 10);
			x = x / 10;
		}
		if(reverse == temp) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(1000));
		System.out.println(isPalindrome(1001));
		System.out.println(isPalindrome(-1001));
		System.out.println(isPalindrome(123321));
	}
}
