package com.yc.doubleLinkedList;

public class DoubleLinkedList {
	private HeroNode2 head = new HeroNode2(0, "", "");
	
	//返回头结点
	public HeroNode2 getHead(){
		return head;
	}
	//遍历双向链表
	public void list(){
		if(head.next == null){
			System.out.println("链表为空~~");
			return;
		}
		HeroNode2 temp = head.next;
		while(temp != null){
			System.out.println(temp);
			temp = temp.next;
		}
	}
	//添加一个结点到双向链表的最后
	public void add(HeroNode2 heroNode){
		//遍历到链表最后，进行添加
		HeroNode2 temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = heroNode;
		heroNode.pre = temp;
	}
	//修改一个结点的内容，可以看到双向链表的结点内容修改和单向链表一样
	public void update(HeroNode2 newNode){
		if(head.next==null){
			System.out.println("链表为空~~~");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false;
		while(temp != null){
			if(temp.no == newNode.no){
				temp.name = newNode.name;
				temp.nickname = newNode.nickname;
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(!flag){
			System.out.printf("未找到%d号结点，不能修改！\n", newNode.no);
		}
	}
	//从双向链表中删除一个结点
	public void del(int no){
		if(head.next==null){
			System.out.println("链表为空~~~");
			return;
		}
		boolean flag = false;
		HeroNode2 temp = head.next;
		while(temp != null){
			if(temp.no == no){
				temp.pre.next = temp.next;
				//删除的如果是最后一个结点，则不能有这一步
				if(temp.next != null){
					temp.next.pre = temp.pre;
				}			
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(!flag){
			System.out.printf("未找到%d号结点，不能删除！", no);
		}
	}
	//添加的第二种，按照编号顺序，注意空指针异常
	public void addByOrder(HeroNode2 newNode){
		HeroNode2 temp = head.next;
		HeroNode2 next = null;
		while(temp != null){
			if(temp.next != null){
				if(temp.no <= newNode.no && newNode.no <= temp.next.no){
					//保存temp.next
					next = temp.next;
					temp.next = newNode;
					next.pre = newNode;
					newNode.pre = temp;
					newNode.next = next;
					break;
				}
			}else{
				if(temp.no <= newNode.no){
					temp.next = newNode;
					newNode.pre = temp;
					break;
				}
			}
			temp = temp.next;
		}
	}
	
}
