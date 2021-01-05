package com.yc.singleLinkedList;

public class singleLinkedListTest {

	public static void main(String[] args) {
		singleLinkedList list = new singleLinkedList();
		HeroNode node01 = new HeroNode(1, "宋江", "及时�?");
		HeroNode node02 = new HeroNode(5, "卢俊�?", "玉麒�?");
		HeroNode node03 = new HeroNode(7, "吴用", "智多�?");
		list.add(node01);
		list.add(node02);
		list.add(node03);
		list.list();
		System.out.println("~~~~~~~~~");
		singleLinkedList list02 = new singleLinkedList();
		HeroNode node04 = new HeroNode(4, "林冲", "豹子�?");
		HeroNode node05 = new HeroNode(6, "武松", "打虎");
		HeroNode node06 = new HeroNode(8, "公孙�?", "入云�?");
		list02.add(node04);
		list02.add(node05);
		list02.add(node06);
		list02.list();
		System.out.println("~~~~~~~~~");
		//singleLinkedList list03 = list.mergeTwoLists(list, list02);
		singleLinkedList list03 = list.merge(list, list02);
		list03.list();
	}

}
