/*Accepted*/
package cn.xiaozhigang.leetcode.easy;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
	if(strs == null || strs.length == 0) return "";
	boolean flag = true;
	for(String string : strs) {
		if(string.length() == 0) {
			flag = false;
			break;
		}
		if(strs[0].charAt(0) != string.charAt(0)) {
			flag = false;
			break;
		}
	}
	if(flag == false) return "";
	int endIndex = 1;
	for(;;endIndex++) {
      for(String string : strs) {
        if(string.length() <= endIndex) {
        	return strs[0].substring(0, endIndex);
        }
    	if(strs[0].charAt(endIndex) != string.charAt(endIndex)) {
    		return strs[0].substring(0, endIndex);
        }
      }
	} 
  }
  public static void main(String[] args) {
    String[] strings = {"ab","abc","hello"};
    LongestCommonPrefix aCommonPrefix = new LongestCommonPrefix();
    System.out.println(aCommonPrefix.longestCommonPrefix(strings));
  }
}
