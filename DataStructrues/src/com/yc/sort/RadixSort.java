package com.yc.sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] nums = {12, 10, 212, 34, 902};
		radixSort(nums);
		System.out.println(Arrays.toString(nums));
	}
//	public static void radixSort(int[] arr){
//		//1、得到数组中最大的数的位数
//		int max = arr[0];//假设第一个数是最大
//		for(int i=1; i<arr.length; i++){
//			if(arr[i] > max){
//				max = arr[i];
//			}
//		}
//		//得到最大数是几位数
//		int maxLength = (max + "").length();	
//		//定义一个二维数组，表示10个桶，每个桶是一个一维数组
//		/**
//		 * 说明：
//		 * 1、二维数组包含10个一维数组
//		 * 2、为了防止在放入数的时候，数据溢出，每一个一维数组，长度定为arr.length
//		 * 3、基数排序是用空间换取时间的经典算法	
//		 */
//		int[][] bucket = new int[10][arr.length];		
//		//为了记录每个桶中，实际存放了多少数据，定义一个一维数组来记录各个桶每次放入的数据个数
//		//如：bucketElementCounts[0],记录的就是bucket[0]桶存放的数据个数
//		int[] bucketElementCounts = new int[10];		
//		for(int i=0, n=1; i<maxLength; i++, n*=10){
//			//针对每个元素的对应位进行排序处理
//			for(int j=0; j<arr.length; j++){
//				int digitOfElement = arr[j] / n % 10;
//				//放入对应的桶
//				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//				bucketElementCounts[digitOfElement]++;
//			}
//			//按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
//			int index = 0;
//			//遍历每一桶，将桶中的数据，放入到原数组
//			for(int k=0; k<bucketElementCounts.length; k++){
//				//桶中有数据才放入
//				if(bucketElementCounts[k] != 0){
//					for(int l=0; l<bucketElementCounts[k]; l++){
//						arr[index++] = bucket[k][l];
//					}
//				}
//				bucketElementCounts[k] = 0;
//			}			
//		}
//	}
	public static void radixSort(int[] arr){
		//找出最大数，求出它的位数
		int max = arr[0];
		for(int i=0; i<arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		int maxLength = (max + "").length();
		int[][] bucket = new int[10][arr.length];//桶子
		int[] bucketElementCounts = new int[10];//记录每个桶子存储的数字个数
		//这一层是不断的进位
		for(int i=0, n=1; i<maxLength; i++, n*=10){
			//这一层是处理数据，放入桶中
			for(int j=0; j<arr.length; j++){
				int digitOfElement = arr[j] / n % 10;//取数位
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			int index = 0;
			for(int k=0; k<bucketElementCounts.length; k++){
				if(bucketElementCounts[k] != 0){
					for(int l=0; l<bucketElementCounts[k]; l++)
					arr[index++] = bucket[k][l];
				}
				bucketElementCounts[k] = 0;
			}			
		}
	}
}
