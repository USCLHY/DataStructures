package com.yc.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = {-1, 0, 1, 2, 3, 3, 10};
		List<Integer> list = binarySearch2(arr, 0, arr.length-1, 3);
		System.out.println(list);
	}
	/**
	 * 二分查找
	 * @param arr  数组
	 * @param left  左边的索�?
	 * @param right 右边的索�?
	 * @param findVal 查找�?
	 * @return  找到返回mid，未找到返回-1
	 */
	private static int binarySearch(int[] arr, int left, int right, int findVal) {
		if(left > right) {
			return -1;
		}
		int mid = (left + right)/2;
		int midVal = arr[mid];
		if(findVal < midVal) {
			//向右递归
			return binarySearch(arr, left, mid-1, findVal);
		}else if(findVal > midVal) {
			//向左递归
			return binarySearch(arr, mid+1, right, findVal);
		}else {
			return mid;
		}	
	}
	
	
	public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
		//当left > right时，说明递归整个数组，但是没有找�?
		if(left > right) {
			return new ArrayList<Integer>();
		}
		
		int mid = (left + right)/2;
		int midVal = arr[mid];
		
		if(findVal > midVal) {
			return binarySearch2(arr, mid+1, right, findVal);
		}else if(findVal < midVal) {
			return binarySearch2(arr, left, mid-1, findVal);
		}else {
			//找到�?
			/**
			 * 在找到findVal之后，不要马上返�?
			 * 向mid索引的左边扫描，将所有满足findVal的元素的下标，加入到集合ArrayList
			 * 向mid索引的右边扫描，将所有满足findVal的元素的下标，加入到集合ArrayList
			 * 将ArrayList返回
			 */
			List<Integer> resIndexList = new ArrayList<Integer>();
			int temp = mid - 1;
			while(true) {
				if(temp<0 || arr[temp]!=findVal) {
					break;//�?�?
				}
				//否则，将temp放入到resIndexList
				resIndexList.add(temp);
				temp--;//temp左移
			}
			resIndexList.add(mid);
			
			//向mid索引值的右边扫描，将�?有满�?1000的元素下标加入到集合ArrayList
			temp = mid+1;
			while(true) {
				if(temp > arr.length-1 || arr[temp] != findVal) {
					break;
				}
				//否则，将temp放入到resIndexList
				resIndexList.add(temp);
				temp++;
			}
			return resIndexList;
		}
	}

}
