package com.yc.search;


public class InsertSearch {

	public static void main(String[] args) {
		int arr[] = {-1, 0, 1, 2, 3, 3, 10};
		int index = insertSearch(arr, 0, arr.length-1, 3);
		System.out.println(index);
	}
	//插值查找
	//注意事项：
	//1、对于数据量较大，关键字分布较均匀的查找表，采用插值查找，速度较快
	//2、关键字分布不均匀，该方法不一定比二分查找效率高
	private static int insertSearch(int[] arr, int left, int right, int findVal) {
		if(left > right || arr[0] > findVal || arr[arr.length-1] < findVal) {
			return -1;
		}
		int mid = left + (right - left) * (findVal - arr[left])/(arr[right]-arr[left]);
		int midVal = arr[mid];
		if(midVal < findVal) {
			return insertSearch(arr, mid+1, right, findVal);
		}else if(midVal > findVal) {
			return insertSearch(arr, left, mid-1, findVal);
		}else {
			return mid;
		}
	}

}
