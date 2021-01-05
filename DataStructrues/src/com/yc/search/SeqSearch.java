package com.yc.search;


public class SeqSearch {
	public static void main(String[] args) {
		int arr[] = {-1, 0, 1, 2, 3, 5, 10};
		int index = seqSearch(arr, 3);
		System.out.println(index);
	}
	//线性查找
	private static int seqSearch(int[] arr, int findVal) {
		for(int i=0; i<arr.length; i++) {
			if(findVal == arr[i]) {
				return i;
			}
		}
		return -1;
	}
}
