package com.yc.arrayQueue;

public class CircleArrayQueue {
	private int maxSize;//队列�?大容�?
	private int front;//队列�?,front指向队头位置
	private int rear;//队列�?,rear指向队尾的后�?个位置（相当于是预留的一个位置）
	private int[] arr;
	
	//队列的构造器
		public CircleArrayQueue(int arrMaxSize){
			maxSize = arrMaxSize;
			arr = new int[maxSize];
		}
		
		//判断队列�?
		public boolean isFull(){
			return (rear + 1) % maxSize == front;
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
			arr[rear] = data;
			rear = (rear + 1) % maxSize;
		}
		
		//从队列头取数�?
		public int getQueue(){
			if(isEmpty()){
				throw new RuntimeException("队列为空，不能取数据~~~");
			}
			int value = arr[front];
			front = (front + 1) % maxSize;
			return value;
		}
		
		//查看队列�?有数�?
		public void showQueue(){
			if(isEmpty()){
				System.out.println("队列为空，不能取数据~~~");
				return;
			}
			for(int i=front; i< front + size(); i++){
				System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
			}
		}
		
		//队列有效元素个数
		private int size() {		
			return (rear + maxSize - front) % maxSize;
		}

		//显示队列的头数据，注意不是取数据
		public int headQueue(){
			if(isEmpty()){
				throw new RuntimeException("队列为空，不能取数据~~~");
			}
			return arr[front];
		}
}
