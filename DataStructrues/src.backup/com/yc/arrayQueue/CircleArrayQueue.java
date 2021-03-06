package com.yc.arrayQueue;

public class CircleArrayQueue {
	private int maxSize;//éåæ?å¤§å®¹é?
	private int front;//éåå¤?,frontæåéå¤´ä½ç½®
	private int rear;//éåå°?,rearæåéå°¾çåä¸?ä¸ªä½ç½®ï¼ç¸å½äºæ¯é¢ççä¸ä¸ªä½ç½®ï¼
	private int[] arr;
	
	//éåçæé å¨
		public CircleArrayQueue(int arrMaxSize){
			maxSize = arrMaxSize;
			arr = new int[maxSize];
		}
		
		//å¤æ­éåæ»?
		public boolean isFull(){
			return (rear + 1) % maxSize == front;
		}
		
		//å¤æ­éåç©?
		public boolean isEmpty(){
			return front == rear;
		}
		
		//æ·»å æ°æ®å°éå?
		public void addQueue(int data) {
			if(isFull()){
				System.out.println("éåæ»¡ï¼ä¸è½å æ°æ®~~~~");
				return;
			}
			arr[rear] = data;
			rear = (rear + 1) % maxSize;
		}
		
		//ä»éåå¤´åæ°æ?
		public int getQueue(){
			if(isEmpty()){
				throw new RuntimeException("éåä¸ºç©ºï¼ä¸è½åæ°æ®~~~");
			}
			int value = arr[front];
			front = (front + 1) % maxSize;
			return value;
		}
		
		//æ¥çéåæ?ææ°æ?
		public void showQueue(){
			if(isEmpty()){
				System.out.println("éåä¸ºç©ºï¼ä¸è½åæ°æ®~~~");
				return;
			}
			for(int i=front; i< front + size(); i++){
				System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
			}
		}
		
		//éåææåç´ ä¸ªæ°
		private int size() {		
			return (rear + maxSize - front) % maxSize;
		}

		//æ¾ç¤ºéåçå¤´æ°æ®ï¼æ³¨æä¸æ¯åæ°æ®
		public int headQueue(){
			if(isEmpty()){
				throw new RuntimeException("éåä¸ºç©ºï¼ä¸è½åæ°æ®~~~");
			}
			return arr[front];
		}
}
