package com.yc.singleLinkedList;

import java.util.Stack;

public class singleLinkedList {
	private HeroNode head = new HeroNode(0, "", "");
	
	//添加节点到单向链�?
	public void add(HeroNode heroNode){
		HeroNode temp = head;
		while(true){
			if(temp.next == null){
				temp.next = heroNode;
				break;
			}
			temp = temp.next;
		}
	}
	public HeroNode getHead(){
		return head;
	}
	//根据排名将英雄插入到指定位置
	public void addByOrder(HeroNode heroNode){
		HeroNode temp = head;
		Boolean flag = false;//判断要添加的英雄结点是否已经存在，是则true
		while(true){
			if(temp.next == null){
				break;//找到了最�?
			}
			if(temp.next.no > heroNode.no){
				break;
			}
			if(temp.next.no == heroNode.no){
				flag = true;
				break;
			}
			temp = temp.next;
		}
		//判断flag的�??
		if(flag){
			System.out.printf("�?%d号英雄已经存�?!\n", temp.no);
		}else{
			//插入
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}
	
	public void update(HeroNode newHeroNode){
		//判断是否为空
		if(head.next == null){
			System.out.println("链表为空~~");
			return;
		}
		HeroNode temp = head.next;
		boolean flag = true;
		while(true){
			//无原序号结点
			if(temp == null){
				flag = false;
				break;
			}
			if(temp.no == newHeroNode.no){
				break;
			}
			temp = temp.next;
		}
		if(!flag){
			System.out.printf("查无%d号结点信�?!\n", newHeroNode.no);
			return;
		}else{
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		}
	}
	
	//删除结点
	public void del(int no){
		//判断链表是否为空
		if(head.next == null){
			System.out.println("链表为空~~");
			return;
		}
		HeroNode temp = head;
		boolean flag = true;
		while(true){
			if(temp.next == null){
				flag = false;//查无此序�?
				break;
			}
			if(temp.next.no == no){
				break;
			}
			temp = temp.next;
		}
		if(!flag){
			System.out.printf("查无%d号信�?!\n", no);
			return;
		}else{
			temp.next = temp.next.next;
		}
	}
	
	//显示链表
	public void list(){
		if(head.next == null){
			System.out.println("链表为空~~");
			return;
		}
		HeroNode temp = head.next;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
	
	//求单链表中有效结点个�?
	public int getLength(HeroNode head){
		if(head.next == null){
			return 0;
		}
		int length = 0;
		HeroNode temp = head.next;
		while(temp != null){
			length++;
			temp = temp.next;
		}
		return length;
	}
	
	//查找单链表中倒数第k个结�?
	public HeroNode findLastIndexNode(HeroNode head, int k){
		if(head.next == null || k > getLength(head) || k <= 0){
			return null;
		}
		int length = getLength(head);
		HeroNode temp = head.next;
		for(int i=0; i<length-k; i++){
			temp = temp.next;
		}
		return temp;
	}
	/*
	//单链表反�?
	public void reverseList(HeroNode head){
		//链表为空或只有一个结�?
		if(head.next == null || head.next.next == null){
			return;
		}
		HeroNode reverseHead = new HeroNode(0, "", "");
		HeroNode cur = head.next;
		HeroNode next = null;
		while(cur != null){
			next = cur.next;
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur = next;
		}
		head = reverseHead.next;
	}
	*/
	//单链表反�?
	public void reverseList(HeroNode head){
		if(head.next==null || head.next.next==null){
			return;
		}
		HeroNode cur = head.next;
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");
		while(cur != null){
			next = cur.next;//保存后续结点信息
			cur.next = reverseHead.next;//当前结点指向新链表最前端
			reverseHead.next = cur;//将cur连接到新的链表上
			cur = next;//让cur后移
		}
		head.next  = reverseHead.next;
	}
	//单链表反转�?��?�就地反转法
	public void reverse(HeroNode head){
		if(head.next == null || head.next.next==null){
			return;
		}
		HeroNode cur = head.next;
		HeroNode temp = head.next;
		HeroNode next = null;
		while(cur != null){
			while(temp != null){
				next = temp.next;
				temp.next = temp.next.next;
				temp.next.next = temp;
				temp = next;
			}
			temp = cur;
			cur = cur.next;
		}
	}
	//从尾到头打印单链�?		使用�?
	public void reversePrint(){
		if(head.next == null){
			System.out.println("链表为空~~");
			return;
		}
		if(head.next.next == null){
			System.out.println(head.next);
			return;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		while(cur != null){
			stack.push(cur);
			cur = cur.next;
		}
		while(stack.size() > 0){
			cur = stack.pop();
			System.out.println(cur);
		}
	}
	//合并两个有序的单链表，合并之后的链表依然有序
	//第一种，不会破坏原来链表的结�?
	public singleLinkedList mergeTwoLists(singleLinkedList l1, singleLinkedList l2){
		singleLinkedList l3 = new singleLinkedList();
		if(l1.head.next == null){
			return l2;
		}
		if(l2.head.next == null){
			return l1;
		}
		HeroNode t1 = l1.head.next;
		HeroNode t2 = l2.head.next;
		HeroNode t3 = l3.head;
		HeroNode node = null;
		while(t1!=null && t2!=null){
			if(t1.no <= t2.no){
				node = new HeroNode(t1.no, t1.name, t1.nickname);
				t1 = t1.next;
				t3.next = node;				
			}else{
				node = new HeroNode(t2.no, t2.name, t2.nickname);
				t2 = t2.next;
				t3.next = node;
			}
			t3 = t3.next;
		}
		while(t1 != null){
			node = new HeroNode(t1.no, t1.name, t1.nickname); 
			t1 = t1.next;
			t3.next = node;
			t3 = t3.next;
		}
		while(t2 != null){
			node = new HeroNode(t2.no, t2.name, t2.nickname);
			t2 = t2.next;
			t3.next = node;
			t3 = t3.next;
		}
		return l3;
	}
	//第二种，会改变两个链表的结构，相当于把两个链表串在了�?�?
	public singleLinkedList merge(singleLinkedList l1, singleLinkedList l2){
		singleLinkedList l3 = new singleLinkedList();
		HeroNode t3 = l3.head;
		HeroNode t1 = l1.head.next;
		HeroNode t2 = l2.head.next;
		if(t1 == null){
			return l2;
		}
		if(t2 == null){
			return l1;
		}
		while(t1 != null && t2 != null){
			if(t1.no <= t2.no){
				t3.next = t1;
				t1 = t1.next;
			}else{
				t3.next = t2;
				t2 = t2.next;
			}
			t3 = t3.next;
		}
		if(t1 != null){
			t3.next = t1;
		}
		if(t2 != null){
			t3.next = t2;
		}
		return l3;
	}
}
