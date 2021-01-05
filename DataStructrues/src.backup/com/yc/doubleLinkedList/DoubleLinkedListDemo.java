package com.yc.doubleLinkedList;


public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		HeroNode2 node01 = new HeroNode2(1, "宋江", "及时�?");
		HeroNode2 node02 = new HeroNode2(2, "卢俊�?", "玉麒�?");
		HeroNode2 node03 = new HeroNode2(4, "吴用", "智多�?");
		list.add(node01);
		list.add(node02);
		list.add(node03);
//		System.out.println(node02.pre);
//		System.out.println(node02.next);
//		System.out.println("~~~~~~");
//		list.list();
//		list.del(2);
//		System.out.println("~~~~~~");
//		list.list();
//		System.out.println("~~~~~~~");
//		list.update(new HeroNode2(1, "小宋", "呼保�?"));
//		list.list();
//		
//		System.out.println("~~~~~~~");
//		list.del(3);
//		list.list();
		list.addByOrder(new HeroNode2(3, "武松", "打虎"));
		list.addByOrder(new HeroNode2(6, "史进", "九纹�?"));
		list.addByOrder(new HeroNode2(9, "李�??", "黑旋�?"));
		list.addByOrder(new HeroNode2(5, "喊喊", "呵呵"));
		list.list();
	}

}
