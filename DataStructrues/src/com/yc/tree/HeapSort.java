package com.yc.tree;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = {1,0,-2,-99,30,123,43,12,11,35,-11};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void heapSort(int[] arr) {
		int temp = 0;
		for(int i=arr.length/2-1; i>=0; i--) {
			adjustHeap(arr, i, arr.length);
		}
		for(int j=arr.length-1; j>0; j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, j);
		}
	}

	private static void adjustHeap(int[] arr, int i, int length) {
		int temp = arr[i];
		for(int k=2*i+1; k<length; k=2*k+1) {
			if(k+1<length && arr[k] < arr[k+1]) {
				k++;
			}
			if(arr[k] > temp) {
				arr[i] = arr[k];
				i = k;
			}else {
				break;
			}
		}
		arr[i] = temp;
	}
}
