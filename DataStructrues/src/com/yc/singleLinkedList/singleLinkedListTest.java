package com.yc.singleLinkedList;

public class singleLinkedListTest {

	public static void main(String[] args) {
		singleLinkedList list = new singleLinkedList();
		HeroNode node01 = new HeroNode(1, "宋江", "及时雨");
		HeroNode node02 = new HeroNode(5, "卢俊义", "玉麒麟");
		HeroNode node03 = new HeroNode(7, "吴用", "智多星");
		list.add(node01);
		list.add(node02);
		list.add(node03);
		list.list();
		System.out.println("~~~~~~~~~");
		singleLinkedList list02 = new singleLinkedList();
		HeroNode node04 = new HeroNode(4, "林冲", "豹子头");
		HeroNode node05 = new HeroNode(6, "武松", "打虎");
		HeroNode node06 = new HeroNode(8, "公孙胜", "入云龙");
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
