package com.yc.arrayStack;

public class Calculator {

	public static void main(String[] args) {
		String expression = "8*2*2-4+6-4";
		//创建两个栈，一个数栈，一个符号栈
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		//定义需要的相关变量
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		String keepNum = "";
		//开始while循环扫描expression
		while(true){
			//依次得到expression的每一个字符
			ch = expression.substring(index, index+1).charAt(0);
			//入栈的为运算符
			if(operStack.isOper(ch)){
				//符号栈空，直接入栈
				if(operStack.isEmpty()){
					operStack.push(ch);
				}else{
					if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
						//数栈出2个，符号栈出一个，结果入数栈，ch入符号栈
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = operStack.cal(num1, num2, oper);
						numStack.push(res);
						operStack.push(ch);
					}else{
						//优先级高，直接入栈
						operStack.push(ch);
					}
				}
			}else{
				//数字直接入栈
				numStack.push(ch - 48);
			}
			index ++;
			if(index >= expression.length()){
				break;
			}
		}
		//最后一步，栈中的数字和符号依次出栈进行运算
		while(true){
		if(operStack.isEmpty()){
			break;
		}
		num1 = numStack.pop();
		num2 = numStack.pop();
		oper = operStack.pop();
		res = operStack.cal(num1, num2, oper);
		numStack.push(res);
	}
	System.out.println(expression + "=" + numStack.pop());
	}

}
class ArrayStack2{
	private int maxSize;
	private int[] stack;
	private int top = -1;
	
	//构造器
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	//增加一个方法，可以返回当前栈顶的值，都是不是真正的top
	public int peek(){
		return stack[top];
	}
	
	//栈满
	public boolean isFull(){
		return top == maxSize-1;
	}
	//栈空
	public boolean isEmpty(){
		return top == -1;
	}
	//入栈-push
	public void push(int val){
		//先判断栈是否满
		if(isFull()){
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = val;
	}
	//出栈-pop
	public int pop(){
		//先判定栈是否为空
		if(isEmpty()){
			//抛出异常
			throw new RuntimeException("栈空，没有数据~");
		}
		int value = stack[top];
		top--;
		return value;
	}
	//显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
	public void list() {
		if(isEmpty()) {
			System.out.println("栈空，没有数据~~");
			return;
		}
		//需要从栈顶开始显示数据
		for(int i = top; i >= 0 ; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
	//返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
	//数字越大，则优先级就越高.
	public int priority(int oper) {
		if(oper == '*' || oper == '/'){
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1; // 假定目前的表达式只有 +, - , * , /
		}
	}
	//判断是不是一个运算符
	public boolean isOper(char val){
		return val=='+' || val=='-' || val=='*' || val=='/';
	}
	//计算方法
	public int cal(int num1, int num2, int oper){
		int res = 0;
		switch(oper){
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}
}
