package com.yc.recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
//	private static List<String> res = new LinkedList<String>();
//	
//	public List<String> readBinaryWatch(int num){
//		res.clear();
//		dfs(num, 0, 0, 1, 1, new LinkedList<Integer>(), new LinkedList<Integer>());
//		return res;
//	}
//	/**
//	 * 
//	 * @param num	LED亮的数量
//	 * @param h	为选中时钟部分的灯数
//	 * @param m	为选中分钟部分的灯数
//	 * @param startH 开始位运算，初始化为1
//	 * @param startM 开始位运算，初始化为1
//	 * @param hours 存储小时
//	 * @param mins 存储分钟
//	 */
//	private void dfs(int num, int h, int m, int startH, int startM, LinkedList<Integer> hours,LinkedList<Integer> mins) {
//		if(hours.size() + mins.size() == num){
//			if(h < 12 && m < 60)
//			res.add(String.format("%d:%02d", h, m));
//			return;
//		}
//		for(int i=startH; i<=8; i<<=2){
//			hours.addLast(i);
//			dfs(num, h+i, m, i<<1, startM, hours, mins);
//			hours.removeLast();
//		}
//		for(int j=startM; j<=32; j<<=2){
//			mins.addLast(j);
//			dfs(num, h, m+j, startH, j<<1, hours, mins);
//			mins.removeLast();
//		}
//		
//	}
//	
//	
//	char[][] map = {{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'},
//			{'t','u','v'}, {'w','x','y','z'}};
//	static List<String> rs = new ArrayList<String>();
//	
//	 public List<String> letterCombinations(String digits){
//		 rs.clear();
//		 int[] nums = new int[digits.length()];
//		 for(int i=0; i<digits.length(); i++){
//			 nums[i] = Integer.parseInt(digits.substring(i, i+1));
//		 }
//		 dfs(0, nums.length, nums, new StringBuilder());
//		 return rs;
//	 }
//	private void dfs(int step, int size, int[] nums, StringBuilder cur) {
//		if(step == size){
//			rs.add(cur.toString());
//			return;
//		}
//		char[] arr = map[nums[step]];
//		for(int i=0; i<arr.length; i++){
//			dfs(step+1, size, nums, cur.append(arr[i]));
//			cur.deleteCharAt(cur.length()-1);
//		}
//	}
//	public static void main(String[] args) {
//		Solution s = new Solution();
//		int[] nums = {10,1,2,7,6,1,5};
//		System.out.println(s.combinationSum(nums, 8));
//	}
//    
//	public boolean isPalindrome(int x) {
//		if(x < 0 || (x % 10 == 0 && x != 0)){
//			return false;
//		}
//		int ans = 0;
//		while(x > ans){
//			ans = ans * 10 + x % 10;
//			x /= 10;
//		}
//		return x == ans || x == ans/10;
//    }
//
//	 List<List<Integer>> ans = new ArrayList<List<Integer>>();	 
//	 public List<List<Integer>> combinationSum(int[] candidates, int target){
//		  ans.clear();
//		  if(candidates == null || candidates.length == 0 || target < 0){
//			   return ans;
//		  }
//		  Arrays.sort(candidates);
//		  dfs(0, 0, candidates, target, new ArrayList<Integer>());
//		  return ans;
//	 }
//	private void dfs(int step, int sum, int[] candidates, int target, ArrayList<Integer> cur) {
//		if(sum == target){
//			ans.add(new ArrayList<Integer>(cur));
//			return;
//		}
//		for(int i=step; i<candidates.length; i++){
//				//大剪枝
//				if(sum + candidates[i] > target){
//					break;
//				}
//				//剪枝：不允许搜索树中同一层出现相同元素
//				if (i > step && candidates[i] == candidates[i - 1]) {
//	                continue;
//	            }
//				cur.add(candidates[i]);
//				dfs(i+1, sum+candidates[i], candidates, target, cur);
//				cur.remove(cur.size()-1);
//		}
//	}

//	 public List<List<Integer>> combinationSum3(int k, int n) {
//		 List<List<Integer>> res = new ArrayList<>();
//	        dfs(res, new ArrayList<>(), k, 1, n);
//	        return res;
//	 }
//	 private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
//	        //终止条件，如果满足这个条件，再往下找也没什么意义了
//	        if (list.size() == k || n <= 0) {
//	            //如果找到一组合适的就把他加入到集合list中
//	            if (list.size() == k && n == 0)
//	                res.add(new ArrayList<>(list));
//	            return;
//	        }
//	        for (int i = start; i <= 9; i++) {
//	            //选择当前值
//	            list.add(i);
//	            //递归
//	            dfs(res, list, k, i + 1, n - i);
//	            //撤销选择
//	            list.remove(list.size() - 1);
//	        }
//	 }
	 
	 
	public static void main(String[] args) {
		Solution s = new Solution();
//		int nums[] = {1,2,2};
//		System.out.println(s.removeDuplicates(nums));
//		System.out.println(Arrays.toString(nums));
		String haystack = "leetcode", needle = "de";
		System.out.println(haystack.indexOf(0));
		System.out.println(needle.indexOf(0));
		System.out.println(s.strStr(haystack, needle));
	}
	/*删除数组中的重复元素，返回移除后数组的新长度。并且修改数组
	 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],

	函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

	你不需要考虑数组中超出新长度后面的元素。
	
	
	因为数组是有序的，所以重复的元素一定会相邻
	采用双指针，一个记作first，一个记为second
	算法流程为：
	1、依次比较nums[first]和nums[second]是否相等
	若相等，则second++;
	若不等，则将nums[first+1] = nums[second],同时first++,second++，这样做就可以保证我们每次做完first前面一定不含重复元素
	重复上述步骤，直到length-1
	最后返回的是first+1，即为数组长度
	*/
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) 
			return 0;
		if(nums.length == 1)
			return 1;
	    int first= 0;
	    int second = 1;
	    while(second < nums.length){
	        if(nums[first] != nums[second]){
	            nums[first + 1] = nums[second];
	            first++;
	        }
	        second++;
	    }
	    return first + 1;
    }
	/**
	 * 算法思想：拷贝覆盖
	 * 主要思路遍历数组nums，每次取出的数字变量为num，同时设置一个下标ans
	 * 算法流程：
	 * 遍历中若出现数字与需要移除的数不等时，则进行拷贝覆盖，nums[ans] = num，同时ans++
	 * 如果相同，则跳过该数字不进行拷贝覆盖，最后ans即为新的数组长度
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		 if(nums == null || nums.length == 0){
			 return 0;
		 }
		 int ans = 0;
		 for(int num : nums){
			 if(num != val){
				 nums[ans] = num;
				 ans++;
			 }
		 }
		 return ans;//即为所求
    }
	/**
	 * 算法思想：
	 * 滑动窗口
	 * @param haystack
	 * @param needle
	 * @return
	 */
	 public int strStr(String haystack, String needle) {
		 int L = needle.length(), n = haystack.length();
		    for (int start = 0; start < n - L + 1; ++start) {
		      if (haystack.substring(start, start + L).equals(needle)) {
		        return start;
		      }
		    }
		    return -1;
	 }
}