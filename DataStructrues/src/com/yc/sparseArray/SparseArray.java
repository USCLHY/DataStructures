package com.yc.sparseArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 * @author LHY
 *
 */
public class SparseArray {
	//将一个二维数组转换为稀疏数组
	public static int[][] toSparseArray(int [][] array){
		int sum = 0;
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++){
				if(array[i][j] != 0){
					sum++;
				}
			}
		}
		int[][] sparseArray = new int[sum+1][3];
		sparseArray[0][0] = array.length;
		sparseArray[0][1] = array[0].length;
		sparseArray[0][2] = sum;
		int count=0;//记录这是第几行
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++){
				if(array[i][j] != 0){
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = array[i][j];
				}
			}
		}
		return sparseArray;
	}
	//将稀疏数组转为二维数组
	public static int[][] toReverSe(int[][] sparseArray){
		int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];
		for(int i=1; i<=sparseArray[0][2]; i++){
			array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		return array;
	}
	//将稀疏数组存到文件
	public static void saveSparseArray(int[][] sparseArray, String filePath) throws IOException{
		File file = new File(filePath);
		if(!file.exists()){
			file.createNewFile();
		}
		FileWriter out = new FileWriter(file);
		for(int i=0; i<sparseArray.length; i++){
			for(int j=0; j<sparseArray[i].length; j++){
				out.write(sparseArray[i][j] + "\t");
			}
			out.write("\n");
		}
		out.close();
	}
	//读取稀疏数组，并将其转化为二维数组
	public static int[][] readToArray(String filePath) throws IOException{
		File file = new File(filePath);
		if(!file.exists()){
			return null;
		}
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = "";//读取的一行数据
		int row = 0;
		String[][] str = new String[100][100];
		while((line = in.readLine()) != null){
			str[row] = line.split("\t");
			row++;
		}
		in.close();
		int sparseArray[][] = new int[row][3];
		for(int i=0; i<row; i++){
			for(int j=0; j<3; j++){
				sparseArray[i][j] = Integer.parseInt(str[i][j]);
			}
		}
		return SparseArray.toReverSe(sparseArray);
	}
}
