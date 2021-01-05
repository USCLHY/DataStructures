package com.yc.doubleLinkedList;

public class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 pre;//指向前一个结点，默认为null
	public HeroNode2 next;//指向下一个结点，默认为null
	
	//构�?�器
	public HeroNode2(int no, String name, String nickname){
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	//重新定义toString方法
	@Override
	public String toString() {
		return "HeroNode[no=" + no + ",name=" + name + ",nickname=" + nickname + "]";
	}
	
}
