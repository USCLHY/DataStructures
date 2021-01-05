package com.yc.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		int arr[] = {-2, 1, 3, 3, 6, 7, 10};
		List<Integer> list = binarySearch2(arr, 0, arr.length-1, 3);
		//List<Integer> list = binarySearch2(arr, 0, arr.length-1, 3);
		System.out.println(list);
		String s = "We are happy.";
		Test t = new Test();
		System.out.println(t.replaceSpace(s));
	}

	private static int binarySearch(int[] arr, int left, int right, int findVal) {
		if(left > right) {
			return -1;
		}
		int mid = (left + right)/2;
		int midVal = arr[mid];
		if(midVal > findVal) {
			return binarySearch(arr, left, mid-1, findVal);
		}else if(midVal < findVal) {
			return binarySearch(arr, mid+1, right, findVal);
		}else {
			return mid;
		}
	}
	
	public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
		if(left > right) {
			return null;
		}
		int mid = (left + right)/2;
		int midVal = arr[mid];
		if(midVal > findVal) {
			return binarySearch2(arr, left, mid-1, findVal);
		}else if(midVal < findVal) {
			return binarySearch2(arr, mid+1, right, findVal);
		}else {
			List<Integer> res = new ArrayList<Integer>();
			int tmp = mid-1;
			//试探左边
			while(tmp >= 0 && arr[tmp] == findVal) {
				res.add(tmp);
				tmp--;	
			}
			res.add(mid);
			//试探右边
			tmp = mid+1;
			while(tmp < arr.length && arr[tmp] == findVal) {
				res.add(tmp);
				tmp++;
			}
			return res;
		}
	}
	
	public String replaceSpace(String s) {
		return s.replace(" ", "%20");
    }
	
	public int numWays(int n) {
		if(n == 0) {
			return 1;
		}
		if(n == 1 || n == 2) {
			return n;
		}		
		int[] arr = new int[n+1];
		arr[1] = 1;
		arr[2] = 2; 
		for(int i=3; i<=n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}	
		return arr[n];
    }
	

}
