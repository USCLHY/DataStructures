package com.yc.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {1, 3, 2, -1, 10, 9};
		bubbleSort(arr);
		for(int i : arr)
		System.out.print(i + " ");
	}

//	//冒泡排序	时间复杂�? O(n^2)
//	private static void bubbleSort(int[] arr) {
//		boolean flag = false;
//		int temp;
//		//�?共进行n-1轮，因为�?后一次不比较
//		for(int i=0; i<arr.length-1; i++){
//			//每次都是把前面arr.length-i个数�?大的放在�?�?
//			for(int j=0; j<arr.length-1-i; j++){
//				if(arr[j] > arr[j+1]){
//					flag = true;
//					temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//				}
//			}
//			//代表这一轮没有发生交换，即数组有�?
//			if(!flag){
//				break;
//			}else{
//				flag = false;
//			}
//		}
//	}
	
	private static void bubbleSort(int[] arr){
		boolean flag = false;
		int temp = 0;
		for(int i=0; i<arr.length-1; i++){
			//为什么是arr.length-1-i，因为我们是会提前看到下�?个数，所有最后的下标arr.length-i-1
			for(int j=0; j<arr.length-i-1; j++){
				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = true;
				}
			}
			if(!flag){
				break;
			}
			flag = false;
		}
	}

}
