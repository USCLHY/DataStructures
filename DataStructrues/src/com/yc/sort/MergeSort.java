package com.yc.sort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {-1, -90, 0, 23, 12, 100, 234, 67};
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length-1, temp);
		System.out.println(Arrays.toString(arr));
	}
	public static void mergeSort(int[] arr, int left, int right, int[] temp){
		if(left < right){
			int mid = (left + right) / 2;//中间索引
			//向左递归进行分解
			mergeSort(arr, left, mid, temp);
			//向右递归进行分解
			mergeSort(arr, mid+1, right, temp);
			//合并
			merge(arr, left, mid, right, temp);
		}
	}
	/**
	 * 合并的方法
	 * @param arr
	 * @param left
	 * @param mid
	 * @param right
	 * @param temp
	 */
	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int l = left;
		int r = mid+1;
		int t = 0;//temp数组下标
		while(l <= mid && r <= right){
			if(arr[l] <= arr[r]){
				temp[t++] = arr[l++];
			}
			if(arr[r] <= arr[l]){
				temp[t++] = arr[r++];
			}			
		}
		while(l <= mid){
			temp[t++] = arr[l++];
		}
		while(r <= right){
			temp[t++] = arr[r++];
		}
		//将temp数组拷贝给arr
//		t = 0;
//		int tempLeft = left;
//		while(tempLeft <= right){
//			arr[tempLeft] = temp[t];
//			t += 1;
//			tempLeft += 1;
//		}
		t = 0;
		for(int k=left; k<=right; k++){
			arr[k] = temp[t++];
		}
	}
}
