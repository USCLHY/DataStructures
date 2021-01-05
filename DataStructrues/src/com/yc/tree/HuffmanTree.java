package com.yc.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
	public static void main(String[] args) {
		int[] arr = {13, 7, 8, 3, 29, 6, 1};
		Node root = createHuffmanTree(arr);
		preOrder(root);
	}
	
	private static Node createHuffmanTree(int[] arr) {
		/**
		 * 第一步：
		 * 1、遍历arr数组
		 * 2、将arr数组的每个元素构成一个Node
		 * 3、将Node放入到ArrayList中
		 */
		List<Node> nodes = new ArrayList<Node>();
		for(int value : arr) {
			nodes.add(new Node(value));
		}
		while(nodes.size()>1) {
			//排序 从小到大
			Collections.sort(nodes);
			System.out.println("nodes=" + nodes);
			
			//取出根节点权值最小的两棵二叉树
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			//构建一棵新的二叉树
			Node parent = new Node(leftNode.value + rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			//删除最小的两棵二叉树
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//添加新的二叉树
			nodes.add(parent);
		}
		return nodes.get(0);
	}

	public static void preOrder(Node root) {
		if(root != null) {
			root.preOrder();
		}else {
			System.out.println("是空树，不能遍历~");
		}
	}
}
class Node implements Comparable<Node>{
	int value;
	Node left;
	Node right;
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	//前序遍历
	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	public Node(int value) {
		this.value = value;
	}
	@Override
	public int compareTo(Node o) {
		//表示从小到大排序
		return this.value - o.value;
	}
	
}
