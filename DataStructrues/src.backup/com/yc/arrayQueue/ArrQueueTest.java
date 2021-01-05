package com.yc.arrayQueue;

import java.util.Scanner;

public class ArrQueueTest {

	public static void main(String[] args) {
		CircleArrayQueue arrayQueue = new CircleArrayQueue(4);//设置�?4，其实队列最大有效个数为3，因为rear空出了一个位置作为约�?
		char key = '0';
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("a(add)");
			System.out.println("g(get)");
			System.out.println("s(show)");
			System.out.println("e(exit)");
			key = sc.next().charAt(0);
			switch(key){
			case 'a':
				System.out.println("请输入一个数�?");
				int data = sc.nextInt();
				arrayQueue.addQueue(data);
				break;
			case 'g':
				arrayQueue.getQueue();
				break;
			case 's':
				arrayQueue.showQueue();
				break;
			case 'e':
				sc.close();
				System.exit(0);
			}
		}
	}

}
