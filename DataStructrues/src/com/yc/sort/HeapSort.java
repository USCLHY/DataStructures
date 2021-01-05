package com.yc.sort;

import java.util.Arrays;

public class HeapSort {
	public static void heapSort(int[] arr) {
		int temp = 0;
		System.out.println("堆排序");
		//将无序序列构建成为一个堆，根据升序降序需求选择大顶堆或小顶堆
		for(int i=arr.length/2-1; i>=0; i--) {
			adjustHeap(arr, i, arr.length);
		}
		/**
		 * 2）将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端
		 * 3）重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，
		 * 反复执行调整+交换步骤，直到整个序列有序
		 */
		for(int j=arr.length-1; j>0; j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, j);
		}
	}
	/**
	 * 将一个数组(二叉树)，调整成一个大顶堆
	 * 功能：完成 将以i对应的非叶子结点的树调整成大顶堆
	 * @param arr 待调整的数组
	 * @param i 表示非叶子结点在数组中索引
	 * @param length 表示对多少个元素继续调整，length是在逐渐的减少
	 */
	private static void adjustHeap(int[] arr, int i, int length) {
		int temp = arr[i];//先取出当前元素
		for(int k=2*i+1; k<length; k=k*2+1) {
			if(k+1<length && arr[k]<arr[k+1]) {//左子结点小于右子结点
				k++;//指向右子结点
			}
			if(arr[k] > temp) { //右子结点大于父节点
				arr[i] = arr[k];
				i = k;
			}else {
				break;
			}
		}
		arr[i] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {-1, 2, 32, 0, 12, -99};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
