package com.yc.circleSingleLinkedList;

public class CircleSingleLinkedListDemo {

	public static void main(String[] args) {
		CircleSingleLinkedList02 list = new CircleSingleLinkedList02();
		list.addBoy(50);
		list.countBoy(10, 20, 50);
	}

}
class CircleSingleLinkedList02{
	private Boy first = null;
	
	//添加nums个小�?
	public void addBoy(int nums){
		if(nums < 1){
			System.out.println("数据不合法！");
			return;
		}
		Boy curBoy = null;
		for(int i=1; i<=nums; i++){
			Boy boy = new Boy(i);
			//自己成环
			if(i == 1){
				first = boy;
				first.setNext(first);
				curBoy = first;
			}else{
				curBoy.setNext(boy);
				curBoy = curBoy.getNext();
				curBoy.setNext(first);
			}
		}
	}
	//遍历当前的环形链�?
	public void showBoy(){
		if(first == null){
			System.out.println("暂无小孩成环~~");
			return;
		}
		Boy curBoy = first;
		while(curBoy.getNext() != first){
			System.out.println("小孩编号为：" + curBoy.getNo());
			curBoy = curBoy.getNext();
		}
		System.out.println("小孩编号为：" + curBoy.getNo());
	}
	//根据用户的输入，计算小孩出圈的顺�?
	public void countBoy(int startNo, int countNum, int nums){
		if(first == null || startNo < 1 || startNo > nums){
			System.out.println("暂无小孩成环~~~");
			return;
		}
		Boy helper = first;
		while(helper.getNext() != first){
			helper = helper.getNext();
		}
		//�?�?始默认first指向第一个小孩，helper指向�?后一个，根据第几个小孩开始报数，初始化一�?
		for(int i=0; i<startNo-1; i++){
			first = first.getNext();
			helper = helper.getNext();
		}
		//�?始报�?
		while(helper != first){
			//每一轮，两个指针后移countNum-1�?
			for(int i=0; i<countNum-1; i++){
				first = first.getNext();
				helper = helper.getNext();		
			}
			System.out.printf("小孩%d 出圈\n", first.getNo());
			//将结点删�?
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.println("�?后留在圈中的小孩为：" + first.getNo());
	}
}
