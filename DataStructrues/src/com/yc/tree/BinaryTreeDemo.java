package com.yc.tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		HeroNode node1 = new HeroNode(1, "宋江");
		HeroNode node2 = new HeroNode(2, "卢俊义");
		HeroNode node3 = new HeroNode(3, "吴用");
		HeroNode node4 = new HeroNode(4, "公孙胜");
		HeroNode node5 = new HeroNode(5, "武松");
		node1.setLeftNode(node2);
		node1.setRightNode(node3);
		node3.setLeftNode(node5);
		node3.setRightNode(node4);
		BinaryTree bTree = new BinaryTree();
		bTree.setRoot(node1);
		System.out.println("前序遍历————————");
		bTree.preOrder();
		System.out.println("中序遍历————————");
		bTree.infixOrder();
		System.out.println("后序遍历————————");
		bTree.postOrder();
		System.out.println("前序遍历查找————————");
		bTree.preOrderSearch(5);
		System.out.println("中序遍历查找————————");
		bTree.infixOrderSearch(5);
		System.out.println("后序遍历查找————————");
		bTree.postOrderSearch(2);
	}
}
class HeroNode{
	private int no;
	private String name;
	private HeroNode leftNode;
	private HeroNode rightNode;
	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the leftNode
	 */
	public HeroNode getLeftNode() {
		return leftNode;
	}
	/**
	 * @param leftNode the leftNode to set
	 */
	public void setLeftNode(HeroNode leftNode) {
		this.leftNode = leftNode;
	}
	/**
	 * @return the rightNode
	 */
	public HeroNode getRightNode() {
		return rightNode;
	}
	/**
	 * @param rightNode the rightNode to set
	 */
	public void setRightNode(HeroNode rightNode) {
		this.rightNode = rightNode;
	}
	//前序遍历
	public void preOrder() {
		System.out.println(this);
		if(this.leftNode != null) {
			this.leftNode.preOrder();
		}
		if(this.rightNode != null) {
			this.rightNode.preOrder();
		}
	}
	//中序遍历
	public void infixOrder() {
		if(this.leftNode != null) {
			this.leftNode.infixOrder();
		}
		System.out.println(this);
		if(this.rightNode != null) {
			this.rightNode.infixOrder();
		}
	}
	//后序遍历
	public void postOrder() {
		if(this.leftNode != null) {
			this.leftNode.postOrder();
		}
		if(this.rightNode != null) {
			this.rightNode.postOrder();
		}
		System.out.println(this);
	}
	//前序遍历查找
	public HeroNode preOrderSearch(int no) {
		System.out.println("前序查找");
		if(this.no == no) {
			return this;
		}
		HeroNode resNode = null;
		if(this.leftNode != null) {
			resNode = this.leftNode.preOrderSearch(no);
		}
		if(resNode != null) {
			return resNode;
		}
		if(this.rightNode != null) {
			resNode = this.rightNode.preOrderSearch(no);
		}
		return resNode;
	}
	//中序遍历查找
	public HeroNode infixOrderSearch(int no) {
		HeroNode resNode = null;
		if(this.leftNode != null) {
			resNode = this.leftNode.infixOrderSearch(no);
		}
		if(resNode != null) {
			return resNode;
		}
		System.out.println("进入中序查找");
		if(this.no == no) {
			return this;
		}
		if(this.rightNode != null) {
			resNode = this.rightNode.infixOrderSearch(no);
		}
		return resNode;
	}
	//后序遍历查找
	public HeroNode postOrderSearch(int no) {
		HeroNode resNode = null;
		if(this.leftNode != null) {
			resNode = this.leftNode.postOrderSearch(no);
		}
		if(resNode != null) {
			return resNode;
		}
		if(this.rightNode != null) {
			resNode = this.rightNode.postOrderSearch(no);
		}
		if(resNode != null) {
			return resNode;
		}
		System.out.println("进入后序查找");
		if(this.no == no) {
			return this;
		}
		return resNode;
	}
}

class BinaryTree{
	HeroNode root;
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	public void preOrder() {
		if(root != null) {
			this.root.preOrder();
		}
	}
	public void infixOrder() {
		if(root != null) {
			this.root.infixOrder();
		}
	}
	public void postOrder() {
		if(root != null) {
			this.root.postOrder();
		}
	}
	public void preOrderSearch(int no) {
		HeroNode resNode;
		if(root != null) {
			resNode = root.preOrderSearch(no);
			if(resNode != null) {
				System.out.println("前序遍历查找成功：结点id：" + no + "，结点姓名：" + resNode.getName() );
			}else {
				System.out.println("无该英雄结点");
			}
		}
	}
	public void infixOrderSearch(int no) {
		HeroNode resNode;
		if(root != null) {
			resNode = root.infixOrderSearch(no);
			if(resNode != null) {
				System.out.println("中序遍历查找成功：结点id：" + no + "，结点姓名：" + resNode.getName());
			}else {
				System.out.println("无该英雄结点");
			}
		}
	}
	public void postOrderSearch(int no) {
		HeroNode resNode;
		if(root != null) {
			resNode = root.postOrderSearch(no);
			if(resNode != null) {
				System.out.println("后序遍历查找成功：结点id：" + no + "，结点姓名：" + resNode.getName());
			}else {
				System.out.println("无该英雄结点");
			}
		}
	}
}