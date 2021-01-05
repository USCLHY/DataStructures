package com.yc.recursion;

public class Queen8 {
	int max = 8;
	int[] array = new int[max];
	static int count = 0;
	static int judgeCount = 0;
	public static void main(String[] args) {
		Queen8 q = new Queen8();
		q.check(0);
		System.out.println("�?共解法数�?" + count);
		System.out.println("�?共判断冲突的次数�?" + judgeCount);
	}
	//编写�?个方法，放置n个皇�?
	//特别注意：check是每�?次�?�归
	public void check(int n){
		if(n == max){
			print();
			return;
		}
		//依次放入皇后，并判断是否冲突
		for(int i=0; i<max; i++){
			//先把当前这个皇后n，放到该行的第i�?
			array[n] = i;
			//判断当放置n个皇后到i列时，是否冲�?
			if(judge(n)){//不冲�?
				//接着放第n+1个皇后，即开始�?�归
				check(n+1);
			}
			//如果冲突，就继续执行array[n]=i；即将第n个皇后，放置在本行的后一个位�?
		}
	}
	//查看当我们放置第n个皇后，就去�?测该皇后是否和前面已经摆放的皇后冲突
	/**
	 * 
	 * @param n 表示第n个皇�?
	 * @return
	 */
	private boolean judge(int n) {
		judgeCount++;
		for(int i=0; i<n; i++){
			//说明
			//1、array[i] == array[n]		同一�?
			//2、Math.abs(n - i) == Math.abs(array[n] - array[i])	同一斜线
			//同一行不�?要判断，因为是一维数�?
			if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i]))
				return false;
		}
		return true;
	}
	private void print() {
		count++;
		for(int i=0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
