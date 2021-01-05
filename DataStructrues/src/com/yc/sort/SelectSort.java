package com.yc.sort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		int[] arr = {1, 9, 0, -2, 3, 4, 5};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));

	}

//	private static void selectSort(int[] arr) {
//		int minIndex;
//		int min;	
//		for(int i=0; i<arr.length-1; i++){
//			minIndex = i;
//			min = arr[i];
//			for(int j=i+1; j<arr.length; j++){
//				if(arr[j] < min){
//					minIndex = j;
//					min = arr[j];
//				}
//			}
//			//将最小值放在arr[i]，即交换
//			if(minIndex != i){			
//				arr[minIndex] = arr[i];
//				arr[i] = min;
//			}
//		}
//	}

	private static void selectSort(int[] arr){
		int min = 0;
		int minIndex = arr[0];
		for(int i=0; i<arr.length-1; i++){
			min = arr[i];
			minIndex = i;
			for(int j=i+1; j<arr.length; j++){
				if(min > arr[j]){
					min = arr[j];
					minIndex = j;
				}				
			}		
			if(i != minIndex){
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}

}
