package com.yc.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test2 {
	public static void main(String[] args) {
		 String str="(中文问号？123???英文)问号?我是华丽[的制表符\t]我是华丽{的空格符 我是华丽}的换行符\n";
		 String rex="\\b";
		 
		 Pattern pattern=Pattern.compile(rex);
		 Matcher matcher=pattern.matcher(str);
		 
		 String [] result=pattern.split(str); 
		 
		 for(String string:result){
		  System.out.println("分割的字符串:"+"["+string+"]");
		 }
		 }
	
	//横向比较
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0 || strs == null){
			return "";
		}
		String prefix = strs[0];
		int count = strs.length;
		for(int i=1; i<count; i++){
			prefix = longestCommonPrefix(prefix, strs[i]);
			if(prefix.length() == 0){
				break;
			}
		}
		return prefix;
    }

	private String longestCommonPrefix(String prefix, String str) {
		int len = Math.min(prefix.length(), str.length());
		int index = 0;
		while(index < len && prefix.charAt(index) == str.charAt(index)){
			index++;
		}
		return str.substring(0, index);
	}
	
	//纵向比较
	public String longestCommonPrefix2(String[] strs){
		if(strs.length == 0 || strs == null){
			return null;
		}
		int len = strs[0].length();
		int count = strs.length;
		for(int i=0; i<len; i++){
			char ch = strs[0].charAt(i);
			for(int j=1; j<count; j++){
				//两种情况：1、当前串长不够，2、字符不匹配
				if(strs[j].length() == i || strs[j].charAt(i) != ch){
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
	
	public int maxArea(int[] height) {
		int i=0, j=height.length-1, res=0;
		while(i < j){
			res = height[i] < height[j]? Math.max(res, (j-i) * height[i++]) : Math.max(res, (j-i) * height[j--]);
		}
		return res;
	}
}
