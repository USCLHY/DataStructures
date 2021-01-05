package com.yc.linkedStack;

public class LinkedStackDemo {
	public static void main(String[] args) {
		LinkedStack stack = new LinkedStack();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		stack.push(n1);
		stack.push(n2);
		stack.push(n3);
		stack.push(n4);
		stack.list();
		System.out.println("~~~~~~~");
		stack.pop();
		stack.pop();
		stack.list();
		System.out.println("~~~~~~~");
		stack.push(new Node(5));
		stack.push(new Node(7));
		stack.list();
	}
	
	
}
//链表模拟�?
class LinkedStack{
	private Node top = new Node(-1);
	//构�?�器
	public LinkedStack(){
		top.down = null;
	}
	//栈空
	public boolean isEmpty(){
		return top.down == null;
	}
	//入栈
	public void push(Node node){
		node.down = top;
		top = node;
	}
	//出栈
	public Node pop(){
		if(isEmpty()){
			throw new RuntimeException("栈为空，不能出栈");
		}
		Node tNode = top;
		top = top.down;
		return tNode;
	}
	//遍历
	public void list(){
		if(isEmpty()){
			System.out.println("栈为空，不能出栈");
			return;
		}
		Node cur = top;
		while(cur.getDown() != null){
			System.out.println("结点号：" + cur.getNo());
			cur = cur.down;
		}
	}
}


//结点�?
class Node{
	int no;
	Node down;//向下指的指针
	
	public Node(int no) {
		super();
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Node getDown() {
		return down;
	}
	public void setDown(Node down) {
		this.down = down;
	}
	
}
