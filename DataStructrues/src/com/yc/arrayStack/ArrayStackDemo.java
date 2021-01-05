package com.yc.arrayStack;

import java.util.Scanner;

public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(4);
		arrayStack.push(3);
		arrayStack.push(4);
		arrayStack.push(5);
		arrayStack.push(1);
		arrayStack.list();
		System.out.println("~~~~~~");
		arrayStack.pop();
		arrayStack.pop();
		arrayStack.list();
		System.out.println("~~~~~~");
		arrayStack.push(7);
		arrayStack.push(10);
		arrayStack.list();
	}
}

//定义一个 ArrayStack 表示栈
class ArrayStack{
	private int maxSize;
	private int[] stack;
	private int top = -1;
	
	//构造器
	public ArrayStack(int maxSize){
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	//判断栈满
	public boolean isFull(){
		return top == maxSize-1;
	}
	
	//判断栈空
	public boolean isEmpty(){
		return top == -1;
	}
	
	//入栈
	public void push(int value){
		if(isFull()){
			System.out.println("栈满，不能入栈！");
			return;
		}
		stack[++top] = value;
	}
	
	//出栈
	public int pop(){
		if(isEmpty()){
			throw new RuntimeException("栈空，无数据！");
		}
		int value = stack[top--];
		return value;
	}
	
	//显示栈的情况，遍历
	public void list(){
		if(isEmpty()){
			System.out.println("栈空，无数据！");
			return;
		}
		int temp = top;
		while(temp != -1){
			System.out.printf("stack[%d]=%d\n", temp, stack[temp]);
			temp--;
		}
	}
}
