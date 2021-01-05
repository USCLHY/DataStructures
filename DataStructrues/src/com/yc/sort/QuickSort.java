package com.yc.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] nums = {-1, 20, 0, -98, 908, 10, 2, 5};
		quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
	public static void quickSort(int[] arr, int left, int right){
		int l = left;
		int r = right;
		//pivot中轴值
		int pivot = arr[(l+r)/2];
		int temp = 0;
		//while循环的目的是让比pivot值小的放到左边
		//比pivot值大的放到右边
		while(l < r){
			//在pivot的左边一直找，找到大于等于pivot值，才退出
			while(arr[l] < pivot){
				l += 1;
			}
			//在pivot的右边一直找，找到小于等于pivot值，才退出
			while(arr[r] > pivot){
				r -= 1;
			}
			//如果l>=r说明pivot左右两边的值，左边全部是小于等于pivot值，右边全部是大于等于pivot值
			if(l >= r){
				break;
			}
			//将两个值交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			//如果交换完后，发现这个arr[l]==pivot值 相等 r--，前移
			if(arr[l] == pivot){
				r--;
			}
			//如果交换完后，发现这个arr[r]==pivot值 相等 l++，前移
			if(arr[r] == pivot){
				l++;
			}
		}
		//如果l==r，必须l++，r--，否则会出现栈溢出
		if(l == r){
			l++;
			r--;
		}
		//向左递归
		if(left < r){
			quickSort(arr, left, r);
		}
		//向右递归
		if(right > l){
			quickSort(arr, l, right);
		}
	}
}
