package com.yc.arrayQueue;

//�?单数组模拟队�?
public class ArrayQueue {
	private int maxSize;//队列�?大容�?
	private int front;//队列�?
	private int rear;//队列�?
	private int[] arr;
	
	//队列的构造器
	public ArrayQueue(int arrMaxSize){
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;
		rear = -1;
	}
	
	//判断队列�?
	public boolean isFull(){
		return rear == maxSize-1;
	}
	
	//判断队列�?
	public boolean isEmpty(){
		return front == rear;
	}
	
	//添加数据到队�?
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
	
	//查看队列�?有数�?
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
