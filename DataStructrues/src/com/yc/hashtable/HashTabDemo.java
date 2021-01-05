package com.yc.hashtable;

import java.util.Scanner;

public class HashTabDemo {
public static void main(String[] args) {
	HashTab hashTab = new HashTab(7);
	while(true) {
		System.out.println("-----------雇员管理系统---------");
		Scanner sc = new Scanner(System.in);
		String op = "";
		System.out.println("add:添加雇员");
		System.out.println("list:查看所有雇员");
		System.out.println("findEmpById:根据id查找雇员");
		System.out.println("exit:退出系统");
		System.out.println("请输入：");
		op = sc.next();
		switch(op) {
		case "add":
			System.out.println("请输入雇员id:");
			int id = sc.nextInt();
			System.out.println("请输入雇员姓名:");
			String name = sc.next();
			Emp emp = new Emp(id, name);
			hashTab.add(emp);
			break;
		case "list":
			hashTab.list();
			break;
		case "findEmpById":
			System.out.println("请输入雇员id:");
			id = sc.nextInt();
			hashTab.findEmpById(id);
			break;
		case "exit":
			sc.close();
			System.exit(0);
		}
			
	}
}

}
//雇员类
class Emp{
	public int id;
	public String name;
	public Emp next;
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
class EmpLinkedList{
	private Emp head;
	public void add(Emp emp) {
		if(head == null) {
			head = emp;
			return;
		}else {
			Emp curEmp = head;
			while(true) {
				if(curEmp.next == null) {
					curEmp.next = emp;
					break;
				}
				curEmp = curEmp.next;
			}
		}
	}
	public void list() {
		System.out.println("==============");
		if(head == null) {
			System.out.println("当前链表为空");
		}else {
			Emp cur = head;
			while(cur != null) {
				System.out.println("=> 雇员id:" + cur.id + ",雇员姓名:" + cur.name);
				cur = cur.next;
			}
		}
		System.out.println("==============");
	}
	public Emp findEmpById(int id) {
		if(head == null) {
			System.out.println("链表为空，无法找到雇员信息");
			return null;
		}
		Emp cur = head;
		while(cur != null) {
			if(cur.id == id) {
				break;
			}
			if(cur.next == null) {
				cur = null;
				break;
			}
			cur = cur.next;
		}
		return cur;
	}
}
class HashTab{
	EmpLinkedList[] empLinkedListArr;
	public HashTab(int size) {
		empLinkedListArr = new EmpLinkedList[size];
		for(int i=0; i<size; i++) {
			empLinkedListArr[i] = new EmpLinkedList();
		}
	}
	public void add(Emp emp) {
		//先确定添加到哪一个链表
		int eid = hash(emp.id);
		empLinkedListArr[eid].add(emp);
	}
	public void list() {
		for(int i=0, len=empLinkedListArr.length; i<len; i++) {
			empLinkedListArr[i].list();
		}
	}
	public void findEmpById(int id) {
		int eid = hash(id);
		Emp emp = empLinkedListArr[eid].findEmpById(id);
		if(emp == null) {
			System.out.println("无该雇员信息");
		}else {
			System.out.println("雇员id:" + id + ",雇员姓名:" + emp.name);
		}
	}
	public int hash(int id) {
		return id%empLinkedListArr.length;
	}
}