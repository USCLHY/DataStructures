package com.yc.sort;

import java.util.Arrays;

public class MyTest {

	public static void main(String[] args) {
		int[] arr = {0, -2, 3, 12, -4, 10, 1};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort(int[] arr) {
		boolean flag = false;
		int temp = 0;
		for(int i=0; i<arr.length-1; i++) {
			flag = false;
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if(!flag) {
				break;
			}
		}
	}
	
	public static void selectSort(int[] arr) {
		int min = arr[0];
		int minIndex = 0;
		for(int i=0; i<arr.length-1; i++) {
			min = arr[i];
			minIndex = i;
			for(int j=i; j<arr.length; j++) {
				if(arr[j] < min) {
					min = arr[j];
					minIndex = j;
				}
			}
			if(minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}
	//插入排序
	public static void insertSort(int[] arr) {
		int insertVal;
		int insertIndex;
		for(int i=1; i<arr.length; i++) {
			insertVal = arr[i];
			insertIndex = i-1;
			while(insertIndex >= 0 && arr[insertIndex] > insertVal) {
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;
			}
			if(insertIndex + 1 != i) {
				arr[insertIndex+1] = insertVal;
			}
		}
	}
	//希尔排序
	public static void shellSort(int[] arr) {
		for(int gap=arr.length/2; gap>0; gap/=2) {
			for(int i=gap; i<arr.length; i++) {
				int insertVal = arr[i];
				int insertIndex = i-gap;
				while(insertIndex >= 0 && arr[insertIndex] > insertVal) {
					arr[insertIndex+gap] = arr[insertIndex];
					insertIndex -= gap;
				}
				if(insertIndex + gap != i) {
					arr[insertIndex+gap] = insertVal;
				}
			}
		}
	}
	//快速排序
	public static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			int index = getIndex(arr, left, right);
			quickSort(arr, left, index-1);
			quickSort(arr, index+1, right);
		}
	}

	private static int getIndex(int[] arr, int left, int right) {
		int pivot = arr[left];
		while(left < right) {
			while(left < right && arr[right] > pivot) {
				right--;
			}
			arr[left] = arr[right];
			while(left < right && arr[left] < pivot) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = pivot;
		return left;
	}
	//归并排序
	public static void mergeSort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}

	private static void sort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = (left + right)/2;
			sort(arr, left, mid);//对左半部分归并
			sort(arr, mid+1, right);//对右半部分归并
			merge(arr, left, right, mid);//治
		}
		
	}

	private static void merge(int[] arr, int left, int right, int mid) {
		int[] copy = Arrays.copyOf(arr, arr.length);
		int i=left, j=mid+1, k=left;
		while(i <= mid && j <= right) {
			if(copy[i] < copy[j]) {
				arr[k++] = copy[i++];
			}else {
				arr[k++] = copy[j++];
			}
		}
		while(i <= mid) {
			arr[k++] = copy[i++];
		}
		while(j <= right) {
			arr[k++] = copy[j++];
		}
	}
}
