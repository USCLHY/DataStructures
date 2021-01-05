package com.yc.tree.threadedtree;


public class ThreadedBinaryTree {
	private HeroNode root;
	private HeroNode pre = null;
	public void threadNodes() {
		threadNodes(root);
	}
	//创建中序线索化二叉树
	private void threadNodes(HeroNode node) {
		if(node == null) {
			return;
		}
		//先处理左子树
		threadNodes(node.getLeftNode());
		//线索化当前节点
		if(node.getLeftNode()==null) {
			node.setLeftNode(pre);
			node.setLeftType(1);
		}
		//处理后继节点，是下一次来处理
		if(pre!=null && pre.getRightNode()==null) {
			pre.setRightNode(node);
			pre.setRightType(1);
		}
		pre = node;
		//最后处理右子树
		threadNodes(node.getRightNode());
	}
	//创建前序线索化二叉树
	private void threadNodes2(HeroNode node) {
		if(node == null) {
			return;
		}
		//先处理本节点
		if(node.getLeftNode() == null) {
			node.setLeftNode(pre);
			node.setLeftType(1);
		}
		//后面进行处理右节点,有点不好理解
		if(pre != null && pre.getRightNode() == null) {
			pre.setRightNode(node);
			pre.setRightType(1);
		}
		pre = node;
		//处理左子树
		if(node.getLeftType() != 1) {
			threadNodes2(node.getLeftNode());
		}
		//处理右子树
		if(node.getRightType() != 1) {
			threadNodes2(node.getRightNode());
		}
	}
	//创建后序线索化二叉树
	private void threadNodes3(HeroNode node) {
		if(node == null) {
			return;
		}
		//先处理左子树
		threadNodes3(node.getLeftNode());
		//处理右子树
		threadNodes3(node.getRightNode());
		//处理本节点
		if(node.getLeftNode() == null) {
			node.setLeftNode(pre);
			node.setLeftType(1);
		}
		//下一步处理右指针
		if(pre != null && pre.getRightNode() == null) {
			pre.setRightNode(node);
			pre.setLeftType(1);
		}
		pre = node;
	}

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
	
	
	//中序线索化遍历二叉树
	public void threadList() {
		HeroNode node = root;
		while(node != null) {
			while(node.getLeftType() == 0) {
				node = node.getLeftNode();
			}
			System.out.println(node);
			while(node.getRightType() == 1) {
				node = node.getRightNode();
				System.out.println(node);
			}
			node = node.getRightNode();
		}
	}
	//前序线索化遍历二叉树
	public void threadList2() {
		HeroNode node = root;
		while(node != null) {
			//如果是非叶子节点，打印
			while(node.getLeftType() == 0) {
				System.out.println(node + ",");
				node = node.getLeftNode();
			}
			System.out.println(node + ",");
			//替换这个遍历的结点
			node = node.getRightNode();
		}	
	}
	//后序线索化遍历二叉树
	public void threadList3() {
		//找到后序遍历开始的结点
		HeroNode node = root;
		while(node != null && node.getLeftType() == 0) {
			node = node.getLeftNode();
		}
		while(node != null) {
			//右节点是线索
			if(node.getRightType() == 1) {
				System.out.println(node + ",");
				pre = node;
				node = node.getRightNode();
			}else {
				//如果上个处理的结点是当前节点的右节点
				if(node.getRightNode() == pre) {
					System.out.println(node + ",");
					if(node == root) {
						return;
					}
					pre = node;
					node = node.getParent();
				}else { //如果从左节点的进入则找到右子树的最左节点
					node = node.getRightNode();
					while(node != null && node.getLeftType() == 0) {
						node = node.getLeftNode();
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		//测试一把中序线索二叉树的功能 以数组｛8, 3, 10, 1, 14, 6｝为例

        /**
         *          1
         *        /   \
         *       3     6
         *      / \   /
         *     8  10 14
         */
		HeroNode root = new HeroNode(1, "java");
        HeroNode node2 = new HeroNode(3, "C#");
        HeroNode node3 = new HeroNode(6, "Python");
        HeroNode node4 = new HeroNode(8, "C++");
        HeroNode node5 = new HeroNode(10, "GO");
        HeroNode node6 = new HeroNode(14, "Dephi");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeftNode(node2);
        root.setRightNode(node3);
        node2.setLeftNode(node4);
        node2.setRightNode(node5);
        node3.setLeftNode(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadNodes();
        threadedBinaryTree.threadList();
	}
}
class HeroNode{
	private int no;
	private String name;
	private HeroNode leftNode;
	private HeroNode rightNode;
	private int leftType;
	private int rightType;
	//父节点的指针，为了后序线索化使用
	private HeroNode parent;
	
	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public HeroNode getParent() {
		return parent;
	}
	/**
	 * @return the leftType
	 */
	public int getLeftType() {
		return leftType;
	}
	/**
	 * @param leftType the leftType to set
	 */
	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}
	/**
	 * @return the rightType
	 */
	public int getRightType() {
		return rightType;
	}
	/**
	 * @param rightType the rightType to set
	 */
	public void setRightType(int rightType) {
		this.rightType = rightType;
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
