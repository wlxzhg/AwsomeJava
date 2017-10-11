/*Accepted*/
package cn.xiaozhigang.leetcode.easy;

import java.lang.Thread.State;
import java.util.Stack;

public class ValidParentheses {
  public boolean isValid(String s) {
	if(s.length() == 0) return false;
	String left = "({[";
	String right = ")}]";
	Stack<Character> stack = new Stack<Character>();
	for(int i = 0; i < s.length(); i++) {
	  if(left.indexOf(s.charAt(i)) != -1)
	    stack.push(s.charAt(i));
	  else {
	    if(stack.empty()) return false;
	    if(right.charAt(left.indexOf(stack.peek())) != s.charAt(i)) return false;
	    stack.pop();
	  }
	}
	return stack.empty();
  }
  public static void main(String[] args) {
	ValidParentheses validParentheses = new ValidParentheses();
	System.out.println(validParentheses.isValid("()[{}]{(("));
  }
}
