package com.yc.sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
		shellSort(arr);
		shellSort2(arr);
		System.out.println(Arrays.toString(arr));
	}

	

	//1）采用交换法
	private static void shellSort(int[] arr) {
		int temp = 0, count = 0;
		for(int gap = arr.length/2; gap > 0; gap /= 2){
			for(int i=gap; i<arr.length; i++){
				//遍历各组中的元素（共gap组,每组len/gap个元素），步长gap
				for(int j=i-gap; j>=0; j-=gap){
					//如果当前元素大于步长后的那个元素，说明交换
					if(arr[j] > arr[j+gap]){
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
			System.out.println("希尔排序第" +(++count)+"轮 = "+Arrays.toString(arr));
		}
	}
	//2)	对交换式的希尔排序进行优化->移位法
//	private static void shellSort2(int[] arr) {
//		//增量gap,并逐步的缩小增量
//		for(int gap = arr.length/2; gap > 0; gap /= 2){
//			//从第gap个元素，逐个对其所在的组进行直接插入排序
//			for(int i=gap; i<arr.length; i++){
//				int j = i;
//				int temp = arr[j];
//				if(arr[j] < arr[j - gap]){
//					while(j - gap >= 0 && temp < arr[j - gap]){
//						//移动
//						arr[j] = arr[j - gap];
//						j -= gap;
//					}
//				}
//				//退出gap，给temp找到插入的位置
//				arr[j] = temp;
//			}
//		}
//	}
	
	private static void shellSort2(int[] arr){
		//增量gap，逐步缩小增量
		for(int gap = arr.length/2; gap > 0; gap /= 2){
			//从第gap个元素，逐个对其所在的组进行插入排序
			for(int i=gap; i<arr.length; i++){
				int j = i;
				int temp = arr[j];
				if(arr[j] < arr[j - gap]){
					while(j - gap >= 0 && temp < arr[j - gap]){
						//移动
						arr[j] = arr[j - gap];
						j -= gap;
					}
				}
				arr[j] = temp;
			}
		}
	}
}
