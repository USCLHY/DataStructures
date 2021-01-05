package com.yc.sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {101, 34, 119, 1, -1, 89};
		System.out.println("排序前：");
		System.out.println(Arrays.toString(arr));
		insertSort(arr);
		System.out.println("排序后：");
		System.out.println(Arrays.toString(arr));
	}
	//插入排序
//	private static void insertSort(int[] arr) {
//		int insertVal = 0;
//		int insertIndex = 0;
//		for(int i=1; i<arr.length; i++){
//			//定义待插入的值
//			insertVal = arr[i];
//			insertIndex = i-1;
//			while(insertIndex >= 0 && insertVal < arr[insertIndex]){
//				//这个数的前一个位置值要大，就把前一个数往后挪一位
//				arr[insertIndex+1] = arr[insertIndex];
//				insertIndex--;
//			}
//			if(insertIndex + 1 != i){
//				//最后把插入的数放到arr[insertIndex+1]
//				arr[insertIndex + 1] = insertVal;
//			}
//		}
//	}
	
	private static void insertSort(int[] arr){
		int insertIndex = 0;
		int insertVal = 0;
		for(int i=1; i<arr.length; i++){
			insertVal = arr[i];
			insertIndex = i-1;//前一个位置
			while(insertIndex >= 0 && insertVal < arr[insertIndex]){
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;
			}
			if(i != insertIndex+1){
				arr[insertIndex+1] = insertVal;
			}
		}
	}
	

}
