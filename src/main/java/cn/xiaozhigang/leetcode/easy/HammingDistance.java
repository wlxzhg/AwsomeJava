package cn.xiaozhigang.leetcode.easy;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
		byte[] arr_x = new byte[31];
		byte[] arr_y = new byte[31];
		int i = 0;
        while(x != 0) {
        	arr_x[i] = (byte)(x % 2);
        	x = x / 2;
        	i++;
        }
        i = 0;
        while(y != 0) {
        	arr_y[i] = (byte)(y % 2);
        	y = y / 2;
        	i++;
        }
        int result = 0;
        for(i = 0; i < 31; i++) {
        	if(arr_x[i] != arr_y[i])
        		result++;
        }
        return result;
    }
	public static void main(String[] args) {
		HammingDistance hammingDistance = new HammingDistance();
		System.out.println(hammingDistance.hammingDistance(93, 73));
	}
}
