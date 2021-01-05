package com.yc.singleLinkedList;

public class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;//指向下一个结�?
	
	public HeroNode(int no, String name, String nickname){
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "HeroNode[no=" + no + ",name=" + name + ",nickname=" + nickname + "]";
	}
}
