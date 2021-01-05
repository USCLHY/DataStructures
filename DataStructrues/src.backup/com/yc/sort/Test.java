package com.yc.sort;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] arr = {10, 12, -10, 0, 23, 4};
		//bubbleSort(arr);
		//selectSort(arr);
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertSort(int[] arr) {
		int i, insertIndex, insertVal;
		for(i=1; i<arr.length; i++){
			insertIndex = i-1;
			insertVal = arr[i];
			while(insertIndex >= 0 && arr[insertIndex] > insertVal){
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			if(insertIndex != i-1){
				arr[insertIndex + 1] = insertVal;
			}
		}
	}

	private static void selectSort(int[] arr) {
		int i, j, min, minIndex;
		for(i=0; i<arr.length-1; i++){
			min = arr[i];
			minIndex = i;
			for(j=i+1; j<arr.length; j++){
				if(min > arr[j]){
					min = arr[j];
					minIndex = j;
				}
			}
			if(minIndex != i){
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}

	private static void bubbleSort(int[] arr) {
		int i, j, temp;
		boolean flag = false;//判断在这�?轮是否发生交�?
		for(i=0; i<arr.length-1; i++){
			for(j=0; j<arr.length-1-i; j++){
				if(arr[j] > arr[j+1]){
					flag = true;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if(!flag){
				break;
			}else{
				flag = false;
			}
		}
	}

}
