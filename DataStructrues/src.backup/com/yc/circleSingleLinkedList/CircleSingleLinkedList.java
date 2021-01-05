package com.yc.circleSingleLinkedList;

public class CircleSingleLinkedList {
	//创建�?个first结点，当前没有编�?
	private Boy first = null;
	
	//添加小孩结点，构造成�?个环形的链表
	public void addBoy(int nums){
		//nums做一个数据校�?
		if(nums < 1){
			System.out.println("nums的�?�不合法�?");
			return;
		}
		Boy curBoy = null;//辅助指针，帮助构建环形链�?
		//使用for来创建我们的环形链表
		for(int i=1; i<=nums; i++){
			//根据编号，创建小孩结�?
			Boy boy = new Boy(i);
			//如果是第�?个小�?,自己成环
			if(i == 1){
				first = boy;
				first.setNext(first);
				curBoy = first;
			}else{
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}
	//遍历当前的环形链�?
	public void showBoy(){
		//判断链表是否为空
		if(first == null){
			System.out.println("没有任何小孩~~~");
			return;
		}
		//因为first不能动，因此我们仍然使用�?个辅助指针完成遍�?
		Boy curBoy = first;
		while(true){
			System.out.printf("小孩的编号为:%d\n", curBoy.getNo());
			if(curBoy.getNext() == first){
				break;
			}
			curBoy = curBoy.getNext();//curBoy后移
		}
	}
	/**
	 * 根据用户输入，计算小孩出圈的顺序
	 * @param startNo	表示第几个小孩开始数�?
	 * @param countNum	表示数几�?
	 * @param nums	表示�?初有几个小孩在圈�?
	 */
	public void countBoy(int startNo, int countNum, int nums){
		//先对数据进行校验
		if(first == null || startNo < 1 || startNo > nums){
			System.out.println("参数输入有误，请重新输入�?");
			return;
		}
		//创建�?个辅助指针，帮助完成小孩出圈
		Boy helper = first;
		//�?要创建一个辅助指针（变量）helper,事先应该指向环形链表的最后这个节�?
		while(true){
			if(helper.getNext() == first){//说明helper指向�?后小孩结�?
				break;
			}
			helper = helper.getNext();
		}
		//小孩报数前，先让first和helper移动k-1�?
		for(int j=0; j<startNo - 1; j++){
			first = first.getNext();
			helper = helper.getNext();
		}
		//当小孩报数时，让first和helper指针同时移动m-1次，然后出圈
		//这里是一个循环操作，知道圈中只有�?个结�?
		while(true){
			if(helper == first){//说明圈中只有�?个结�?
				break;
			}
			//让first和helper指针同时的移动countNum - 1
			for(int j=0; j<countNum - 1; j++){
				first = first.getNext();
				helper = helper.getNext();
			}
			//这时first指向的结点，就是要出圈的小孩结点
			System.out.printf("小孩%d 出圈\n", first.getNo());
			//这时将first指向的小孩结点出�?
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("�?后留在圈中的小孩编号%d", first.getNo());
	}
}

class Boy{
	private int no;//编号
	private Boy next;//指向下一个结点，默认为空
	
	public Boy(int no){
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
	
	
}
