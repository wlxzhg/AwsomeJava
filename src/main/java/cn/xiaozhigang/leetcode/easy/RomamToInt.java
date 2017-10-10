/*Accepted*/
package cn.xiaozhigang.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomamToInt {
	public static int romanToInt(String s) {
		int result = 0;
		char [] sArr = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>(); 
		map.put('I', 1); 
		map.put('X', 10); 
		map.put('C', 100);
		map.put('M', 1000);
		map.put('V', 5);
		map.put('L', 50);
		map.put('D', 500);
		for(int i = 0; i < sArr.length; i++) {
			if(i != sArr.length - 1 && (sArr[i] == 'I' || sArr[i] == 'X' || sArr[i] == 'C')) {
				if(map.get(sArr[i+1]) > map.get(sArr[i])) {
					result += (map.get(sArr[i+1]) - map.get(sArr[i]));
					i++;
				} else {
					result += map.get(sArr[i]);
				}
			} else {
				result += map.get(sArr[i]);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(romanToInt("I"));
		System.out.println(romanToInt("II"));
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("XCIX"));
		System.out.println(romanToInt("MCMXCIX"));
		System.out.println(romanToInt("MMMCMXCIX"));
		System.out.println(romanToInt("XLIX"));
	}
}
