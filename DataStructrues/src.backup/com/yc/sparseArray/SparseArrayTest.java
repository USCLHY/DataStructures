package com.yc.sparseArray;

import java.io.IOException;

public class SparseArrayTest {

	public static void main(String[] args) throws IOException {
		int[][] array = new int[11][11];
		array[1][2] = 1;
		array[2][3] = 2;
		array[4][4] = 2;
		int [][]sparseArray = SparseArray.toSparseArray(array);
		for(int[] row : sparseArray){
			for(int data : row){
				System.out.print(data + "\t");
			}
			System.out.println();
		}
		int[][] array02 = SparseArray.toReverSe(sparseArray);
		System.out.println();
		for(int[] row : array){
			for(int data : row){
				System.out.print(data + "\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("array03~~~~~~");
		SparseArray.saveSparseArray(sparseArray, "map.txt");
		int[][] array03 = SparseArray.readToArray("map.txt");
		for(int i=0; i<array03.length; i++){
			for(int j=0; j<array03[i].length; j++){
				System.out.print(array03[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
