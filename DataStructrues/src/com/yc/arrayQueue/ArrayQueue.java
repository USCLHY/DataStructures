package com.yc.arrayQueue;

//简单数组模拟队列
public class ArrayQueue {
	private int maxSize;//队列最大容量
	private int front;//队列头
	private int rear;//队列尾
	private int[] arr;
	
	//队列的构造器
	public ArrayQueue(int arrMaxSize){
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;
		rear = -1;
	}
	
	//判断队列满
	public boolean isFull(){
		return rear == maxSize-1;
	}
	
	//判断队列空
	public boolean isEmpty(){
		return front == rear;
	}
	
	//添加数据到队列
	public void addQueue(int data) {
		if(isFull()){
			System.out.println("队列满，不能加数据~~~~");
			return;
		}
		rear++;
		arr[rear] = data;
	}
	
	//从队列依次取数据
	public int getQueue(){
		if(isEmpty()){
			throw new RuntimeException("队列为空，不能取数据~~~");
		}
		front++;
		return arr[front];
	}
	
	//查看队列所有数据
	public void showQueue(){
		if(isEmpty()){
			System.out.println("队列为空，不能取数据~~~");
			return;
		}
		for(int i=front+1; i<=rear; i++){
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}
	
	//显示队列的头数据，注意不是取数据
	public int headQueue(){
		if(isEmpty()){
			throw new RuntimeException("队列为空，不能取数据~~~");
		}
		return arr[front+1];
	}
}
