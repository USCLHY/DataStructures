package com.yc.arrayStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//1、实现中�?表达�?->后缀表达�?	2、计算后�?表达�?
public class PolandNotation {

	public static void main(String[] args) {
		PolandNotation polandNotation = new PolandNotation();
//		String expression = "1+(2+3)*40-10";
//		String suffixExpression = "30 4 + 5 * 6 -";
//		int res = cal(suffixExpression);
//		System.out.println(res);
		
		String ex = "1+(4+2)*2";
		List<String> list = polandNotation.transform(ex);
		System.out.println(list);
		String str = "";
		for(int i=0; i<list.size(); i++){
			str += list.get(i);
			if(i != list.size()-1){
				str += " ";
			}
		}
		System.out.println(str);
		int res = cal(str);
		System.out.println(res);
	}
	//将中�?表达式转换为后缀表达�?
	public List<String> transform(String exp){
		Stack<String> stack = new Stack<String>();//运算符栈
		List<String> list = new ArrayList<String>();//存储中间结果，使用一个list集合
		Operation op = new Operation();
		char[] arr = exp.toCharArray();
		String[] str = new String[arr.length];
		for(int i=0; i<arr.length; i++){
			str[i] = arr[i] + "";
		}
		//遍历表达式的每一个元素，按算法实现操�?
		for(String item : str){
			//如果是一个数，加入s2
			if(item.matches("\\d+")){
				list.add(item);
			}else if(item.equals("(")){
				stack.push(item);
			}else if(item.equals(")")){
				//如果是右括号")"，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对左括号丢弃
				while(!stack.peek().equals("(")){
					list.add(stack.pop());
				}
				stack.pop();
			}else{
				while(stack.size()>0 && op.priority(stack.peek()) >= op.priority(item)){
					list.add(stack.pop());
				}
				//还需要将item压入�?
				stack.push(item);
			}
			}
			//�? s1 中剩余的运算符依次弹出并加入 s2
			while(stack.size() > 0){
				list.add(stack.pop());
		}
		return list;
	}

	//将后�?表达式的元素依次入栈，计算�??
	public static int cal(String exp){
		String[] split = exp.split(" ");
		Stack<String> stack = new Stack<String>();
		for(String data : split){
			//如果是数字则直接入栈
			if(data.matches("\\d+")){
				stack.push(data);
			}else{
				//从栈顶弹出两个数，和运算符进行运算，将结果压入栈�?
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				int res = 0;
				switch(data){
				case "+":
					res = num1 + num2;
					break;
				case "-":
					res = num2 - num1;
					break;
				case "*":
					res = num1 * num2;
					break;
				case "/":
					res = num2 / num1;
					break;
				default:
					throw new RuntimeException("运算符有�?");
				}
				stack.push(res + "");//将结果压入栈�?
			}
		}
		return Integer.parseInt(stack.pop());
	}
class Operation{
	private final static int MUL = 1;
	private final static int DIV = 1;
	private final static int ADD = 0;
	private final static int SUB = 0;
	private final static int LEFT = -1;
	private final static int RIGHT = -1;
	
	//返回运算符优先级
	public int priority(String oper){
		switch(oper){
		case "+":
			return ADD;
		case "-":
			return SUB;
		case "*":
			return MUL;
		case "/":
			return DIV;
		case "(":
			return LEFT;
		case ")":
			return RIGHT;
		default:
			throw new RuntimeException("运算符有�?");
		}
	}
}

}
