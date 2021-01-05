package com.yc.tree;

public class ArrayBinaryTree {
	private int[] arr;
	public ArrayBinaryTree(int[] arr) {
		this.arr = arr;
	}
	//将数组按照二叉树前序遍历
	public void preOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空，无法按照二叉树前序遍历");
			return;
		}
		System.out.println(arr[index]);
		if(index * 2 + 1 < arr.length) {
			preOrder(index*2+1);
		}
		if(index * 2 + 2 < arr.length) {
			preOrder(index*2+2);
		}
	}
	//中序遍历
	public void infixOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空，无法按照二叉树前序遍历");
			return;
		}
		if(index * 2 + 1 < arr.length) {
			infixOrder(index*2+1);
		}
		System.out.println(arr[index]);
		if(index * 2 + 2 < arr.length) {
			infixOrder(index*2+2);
		}
	}
	//后序遍历
	public void postOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空，无法按照二叉树前序遍历");
			return;
		}
		if(index * 2 + 1 < arr.length) {
			postOrder(index*2+1);
		}
		if(index * 2 + 2 < arr.length) {
			postOrder(index*2+2);
		}
		System.out.println(arr[index]);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		ArrayBinaryTree bTree = new ArrayBinaryTree(arr);
		bTree.preOrder(0);
		System.out.println("-----");
		bTree.infixOrder(0);
		System.out.println("------");
		bTree.postOrder(0);
	}
}
