package com.yc.sort;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int arr[] = {-2, 12, 2, 23, 0, -3, 100};
//		System.out.println("选择排序：");
//		selectSort(arr);
//		System.out.println(Arrays.toString(arr));
//		System.out.println("插入排序：");
//		insertSort(arr);
//		System.out.println(Arrays.toString(arr));
//		System.out.println("希尔排序：");
//		shellSort(arr);
//		System.out.println(Arrays.toString(arr));
//		System.out.println("快速排序：");
//		quickSort(arr, 0, arr.length-1);
//		System.out.println(Arrays.toString(arr));
		System.out.println("归并排序：");
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	//冒泡排序
	private static void bubbleSort(int[] arr) {
		int temp = 0;
		boolean flag = false;//判断数组在这一轮是否进行过排序
		for(int i=0; i<arr.length-1; i++) {
			flag = false;
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = true;
				}
			}
			if(!flag) {
				break;
			}
		}
	}
	
	//选择排序
	private static void selectSort(int[] arr) {
		int min = arr[0];
		int minIndex = 0;
		for(int i=0; i<arr.length-1; i++) {
			min = arr[i];
			minIndex = i;
			for(int j=i+1; j<arr.length; j++) {
				if(min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			if(i != minIndex) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}
	
	//插入排序
	private static void insertSort(int[] arr) {
		int insertVal;
		int insertIndex;
		for(int i=1; i<arr.length; i++) {
			insertVal = arr[i];
			insertIndex = i-1;//前一个位置
			while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex+1] = arr[insertIndex];
				//arr[insertIndex] = insertVal;
				insertIndex--;
			}
			if(i != insertIndex+1) {
				arr[insertIndex+1] = insertVal;
			}
		}
	}
	
	//希尔排序
	private static void shellSort(int[] arr) {
		int len = arr.length;
		int insertVal;
		int insertIndex;
		for(int gap = len/2; gap > 0; gap /=2) {
			for(int i=gap; i<arr.length; i++) {
				insertVal = arr[i];
				insertIndex = i-gap;
				while(insertIndex >= 0 && arr[insertIndex] > insertVal) {
					arr[insertIndex+gap] = arr[insertIndex];
					insertIndex -= gap;
				}
				if(i != insertIndex + gap) {
					arr[insertIndex+gap] = insertVal;
				}
			}
		}
	}
		
	//快速排序
	private static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			int index = findIndex(arr, left, right);
			System.out.println(Arrays.toString(arr));
			quickSort(arr, left, index-1);
			quickSort(arr, index+1, right);
		}
	}
	//寻找基准数的真实下标
	private static int findIndex(int[] arr, int left, int right) {
		int tmp = arr[left];
		//先从右边开始
		while(left < right) {
			while(left < right && arr[right] >= tmp) {
				right--;
			}
			arr[left] = arr[right];
			while(left < right && arr[left] <= tmp) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = tmp;
		return left;
	}
	
	private static void mergeSort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}

	private static void sort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = (left + right)/2;//分成两部分进行归并
			sort(arr, left, mid);//对左半部分进行归并
			sort(arr, mid+1, right);//对右半部分进行归并
			merge(arr, left, mid, right);//治：归并后进行合并
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int[] copy = Arrays.copyOf(arr, arr.length);
		int i = left, j = mid+1, k = left;
		while(i <= mid && j <= right) {
			if(copy[i] <= copy[j]) {
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
