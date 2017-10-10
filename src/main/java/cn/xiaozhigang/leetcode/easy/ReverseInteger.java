/*Accepted*/
package cn.xiaozhigang.leetcode.easy;

public class ReverseInteger {
	public static int reverse(int x) {
		long result = 0;
		int s = (x > 0)?1:-1;
		x = x * s;
		while(x != 0) {
			result = result * 10 + (x % 10);
			x = x / 10;
		}
		if(result > 2147483647 || result < -2147483648) return 0;
		return (int)(result * s);
	}
	public static void main(String[] args) {
		System.out.println(reverse(1000));
		System.out.println(reverse(-1000));
		System.out.println(reverse(2147483647));
		System.out.println(reverse(123456));
	}
}
