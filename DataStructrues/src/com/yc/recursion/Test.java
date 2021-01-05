package com.yc.recursion;

import java.util.ArrayList;
import java.util.List;

public class Test {
	List<String> res = new ArrayList<String>();
	public List<String> generateParenthesis(int n){
		res.clear();
		StringBuilder sb = new StringBuilder();
		dfs(0, 0, n, sb);
		return res;
	}
	private void dfs(int left, int right, int n, StringBuilder sb) {
			if(left + right == n*2){
				res.add(sb.toString());
				return;
			}
			//只要左括号还没有满，都可以添加
			if(left < n){
				sb.append('(');
				dfs(left+1, right, n, sb);
				sb.deleteCharAt(sb.length()-1);
			}
			//右括号小于等于左括号数
			if(right < left){
				sb.append(')');
				dfs(left, right+1, n, sb);
				sb.deleteCharAt(sb.length()-1);
			}
	}
	public static void main(String[] args) {
		Test test = new Test();
		List<String> rs = test.generateParenthesis(4);
		System.out.println(rs);
	}

}
