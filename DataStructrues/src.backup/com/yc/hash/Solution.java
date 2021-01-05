package com.yc.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {1,1,2,2,2,3,3,3,3};
		//System.out.println(s.longestPalindrome2("abcsca"));
//		int[] arr = s.topKFrequent(nums, 2);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(s.reverse(153423646));
		System.out.println(s.myAtoi("-001"));
	}
   
//    public int lengthOfLongestSubstring(String s) {
//    	Set<Character> set = new HashSet<Character>();
//    	int len = s.length();
//    	//右指针初始化�?-1，相当于在字符串的左边界的左侧，还没有开始移�?
//    	int rk=-1, ans = 0;
//    	for(int i=0; i<len; i++){
//    		if(i != 0){
//    			//左指针向右移动一格，移除�?个字�?
//    			set.remove(s.charAt(i-1));
//    		}
//    		while( rk+1<len && !set.contains(s.charAt(rk+1))){
//    			//不断移动右指�?
//    			set.add(s.charAt(rk+1));
//    			++rk;
//    		}
//    		//第i到rk个字符是�?个无重复字符的最长子�?
//    		ans = Math.max(ans, rk-i+1);
//    	}
//    	return ans;
//    }
    
    public int lengthOfLongestSubstring(String s){
    	if(s.length() == 0){
    		return 0;
    	}
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	int max = 0;//当前无重复的�?长子�?
    	int left = 0;//滑动窗口左指�?
    	for(int i=0; i<s.length(); i++){
    		char ch = s.charAt(i);
    		if(map.containsKey(ch)){
    			//两种情况，为�?么是取两者的max
    			//1、当前字符ch包含在当前子段中，如abca，那么就直接left=map.get(ch)+1
    			//2、当前字符ch不包含在当前子段
    			left = Math.max(left, map.get(ch)+1);
    		}
    		map.put(ch, i);
    		max = Math.max(max, i-left+1);//比较当前子串和max
    	}
    	return max;
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int i=0, j=0, t=0, len1 = nums1.length, len2 = nums2.length;	
    	int len = len1+len2;
    	int[] res = new int[len];	
    	while(i < len1 && j < len2){
    		if(nums1[i] <= nums2[j]){
    			res[t++] = nums1[i++];
    		}else{
    			res[t++] = nums2[j++];
    		}
    	}
    	while(i < len1){
    		res[t++] = nums1[i++];
    	}
    	while(j < len2){
    		res[t++] = nums2[j++];
    	}
    	return len/2*2==len ? (double)(res[len/2]+res[len/2-1])/2 : res[len/2];
    }
    
    public String longestPalindrome(String s){
    	int len = s.length();
    	if(len < 2){
    		return s;
    	}
    	int maxLen = 1;
    	String res = s.substring(0, 1);
    	//中心位置枚举到len-2即可，因为最后一个字符无法扩�?
    	for(int i=0; i<len-1; i++){
    		String oddStr = centerSpread(s, i, i);//这样扩散是以我们枚举的这单个字符作为中心，得到的是奇数串
    		String evenStr = centerSpread(s, i, i+1);//以枚举的字符和它后面那个字符之间的间隙作为中心，得到的是偶数�?
    		String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;//取这两种情况长度更大的作为res
    		if(maxLenStr.length() > maxLen){
    			maxLen = maxLenStr.length();
    			res = maxLenStr;
    		}
    	}
    	return res;
    }

	private String centerSpread(String s, int left, int right) {
		int l = left;
		int r = right;
		while(l >= 0 && r < s.length()){
			if(s.charAt(l) != s.charAt(r)){
				break;
			}
			l -= 1;
			r += 1;
		}
		return s.substring(l+1, r);
	}
	
	//动�?�规�?
	public String longestPalindrome2(String s){
		int len = s.length();
		if(len < 2){
			return s;
		}
		int maxLen = 1;
		int begin = 0;
		//dp[i][j]表示s[i,...j]是否是回文串 boolean
		boolean[][] dp = new boolean[len][len];
		//单个字符�?定是回文�?
		for(int i=0; i<len; i++){
			dp[i][i] = true;
		}
		char[] charArray = s.toCharArray();
		
		for(int j=1; j<len; j++){
			for(int i=0; i<j; i++){
				if(charArray[i] != charArray[j]){
					dp[i][j] = false;
				}else{
					//字符串长度小于等�?3，就只要比较首尾两个字符即可
					//即length=j-i+1<=3  -> j-i<=2
					if(j - i < 3){
						dp[i][j] = true;
					}else{
						//去掉首尾，dp[i][j] -> dp[i+1][j-1]
						dp[i][j] = dp[i+1][j-1];
					}
				}
				//只要dp[i][j] == true成立，就表示s[i,...j]是回文，此时记录
				if(dp[i][j] && j - i + 1 > maxLen){
					maxLen = j-i+1;
					begin = i;//这里只要记录�?始下标即可，后面可以由长度推出str
				}
			}
		}
		return s.substring(begin, begin+maxLen);
	}
	
	//前k个高频元�?
	public int[] topKFrequent(int[] nums, int k) {
		int[] res = new int[k];
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
//		for(int item : nums){
//			if(!map.containsKey(item)){
//				map.put(item, 1);
//			}else{
//				map.put(item, map.get(item)+1);
//			}
//		}
		 for (int num : nums) {
			 //getOrDefault意�?�就是当Map集合中有这个key时，就使用这个key值，如果没有就使用默认�?�defaultValue
	            map.put(num, map.getOrDefault(num, 0) + 1);
	     }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer,Integer>>() {
			@Override
			public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}   	
        });
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }

//	public int reverse(int x){		
//		int ans = 0;
//        while (x != 0) {
//            int pop = x % 10;
//            //int类型的取值范围为-2147483648�?2147483647�?
//            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) 
//                return 0;
//            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) 
//                return 0;
//            ans = ans * 10 + pop;
//            x /= 10;
//        }
//        return ans;
//	}
	
	public int reverse(int x){
		int ans = 0;
		while(x != 0){
			int pop = x % 10;
			//这里要预处理�?下，int类型的取值范围为-2147483648�?2147483647，我们是看到它的前一�?
			if((ans > Integer.MAX_VALUE/10) || (ans == Integer.MAX_VALUE/10 && pop > 8)){
				return 0;
			}
			if((ans < Integer.MIN_VALUE/10) || (ans == Integer.MIN_VALUE/10 && pop < -7)){
				return 0;
			}
			//这一步很关键
			ans = ans * 10 + pop;
			x /= 10;
		}
		return ans;
	}
	
	public int myAtoi(String str) {
        //1、在str中检索出第一个最长的数字字符�?
		char[] ch = str.toCharArray();
		boolean flag = false;//用来判断是否遇到第一个字�?
		boolean isPositive = true;
		int ans = 0;
		for(int i=0; i<ch.length; i++){
			//�?头遇到空格直接跳过，直到第一个字符，判断是否�?+�?-、数�?
			if(!flag){
				if(ch[i] == ' '){
					continue;
				}else{
					if(ch[i] != '+' && ch[i] != '-' && !(ch[i] >= '0' && ch[i] <= '9')){
						return 0;
					}else{						
						if(!(ch[i] >= '0' && ch[i] <= '9')){
							if(ch[i] == '-')
								isPositive = false;
							i++;
						}						
						while(i < ch.length && ch[i] >= '0' && ch[i] <= '9' ){
							int pop = ch[i] - '0';
							//这里要预处理�?下，int类型的取值范围为-2147483648�?2147483647，我们是看到它的前一�?
							if(isPositive && ((ans > Integer.MAX_VALUE/10) || (ans == Integer.MAX_VALUE/10 && pop > 7))){
								return Integer.MAX_VALUE;
							}
							if(!isPositive && ((-1*ans < Integer.MIN_VALUE/10) || (-1*ans == Integer.MIN_VALUE/10 && pop > 8))){
								return Integer.MIN_VALUE;
							}
							//每一步都把符号位乘进�?:res = res * 10 + sign * (currChar - '0'); sign=-1
							ans = ans * 10 + pop;
							i++;
					}
						break;
					}									
				}
			}			
		}
		if(!isPositive)
			ans *= -1;
		return ans;
    }
}
