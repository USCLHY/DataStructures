package com.yc.linkedStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(7);
		l1.next.next = new ListNode(5);
		l1.next.next.next = new ListNode(1);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(2);
		l1.next.next.next.next.next.next = new ListNode(5);
		l1.next.next.next.next.next.next.next = new ListNode(1);
		ListNode h = s.oddEvenList(l1);
		while(h != null){
			System.out.println(h.val);
			h = h.next;
		}
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
        ListNode temp = head;
        ListNode cur01 = l1;
        ListNode cur02 = l2;
        if(l1 == null){
        	return l2;
        }
        if(l2 == null){
        	return l1;
        }
        while(cur01 != null && cur02 != null){
        	if(cur01.val > cur02.val){
        		temp.next = cur02;
        		temp = temp.next;
        		cur02 = cur02.next;
        	}else{
        		temp.next = cur01;
        		temp = temp.next;
        		cur01 = cur01.next;
        	}  	
        }
        while(cur01 != null){
        	temp.next = cur01;
        	temp = temp.next;
        	cur01 = cur01.next;
        }
        while(cur02 != null){
        	temp.next = cur02;
        	temp = temp.next;
        	cur02 = cur02.next;
        }
        head = head.next;
        return head;
    }
	public int kthToLast(ListNode head, int k) {
       ListNode cur = head;
       if(head == null){
    	   throw new RuntimeException("链表为空");
       }
       int length = 0;
       while(cur != null){
    	   cur = cur.next;
    	   length++;
       }
       if(k > length || k <= 0){
    	   throw new RuntimeException("参数非法");
       }
       cur = head;
       int step = length - k;
       for(int i=0; i<step; i++){
    	   cur = cur.next;
       }
       return cur.val;
    }
	public boolean hasCycle(ListNode head) {
	    //设置快慢指针判断链表是否成环,速度差为1，距离最小为1
		if(head == null || head.next == null){
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != fast){
			if(fast == null || fast.next == null){
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
	//反转链表
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next==null){
			return head;
		}
		ListNode newHead = new ListNode();
		ListNode next = null;
		//每次去head.next插入newHead.next
		while(head != null){
			next = head.next;
			head.next = newHead.next;
			newHead.next = head;
			head = next;
		}
		return newHead.next;
    }
	//返回链表的中间节�?,快慢指针�?
	public ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
	public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode newNode=new ListNode(0);
        newNode.next=head;
        ListNode p=newNode;
        while(newNode.next!=null){
            if(newNode.next.val==val){
                newNode.next=newNode.next.next;
            }else{
                newNode=newNode.next;
            }
        }
        return p.next;
    }
	public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }        

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode removeDuplicateNodes(ListNode head) {
    	Set<Integer> set = new HashSet<Integer>();
    	if(head == null || head.next == null)
    		return head;
    	ListNode temp = head;
    	set.add(head.val);
    	while(temp.next != null){	
    		if(set.contains(temp.next.val)){
    			temp.next = temp.next.next;
    		}else{
    			temp = temp.next;
    			set.add(temp.val);
    		}	
    	}
    	return head;
    }
    public ListNode deleteNode(ListNode head, int val) {
    	ListNode preHead = new ListNode(-1);
    	preHead.next = head;
    	ListNode temp = preHead;
    	while(temp.next != null){
    		if(temp.next.val == val){
    			temp.next = temp.next.next;
    			break;
    		}else{
    			temp = temp.next;
    		}	
    	}
    	return preHead.next;
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
    	if(head == null){
    		return null;
    	}
    	ListNode temp = head;
    	int len = 0;
    	while(temp != null){
    		len++;
    		temp = temp.next;
    	}
    	len -= k;
    	temp = head;
    	for(int i=0; i<len; i++){
    		temp = temp.next;
    	}
    	return temp;
    }
    public ListNode swapPairs(ListNode head) {
//    	if(head == null || head.next == null){
//    		return head;
//    	}
//    	ListNode dummy = new ListNode(-1);
//    	dummy.next = head;
//    	ListNode pre = dummy;
//    	while(pre.next != null && pre.next.next != null){
//    		ListNode first = pre.next;
//    		ListNode second = first.next;
//    		pre.next = second;
//    		first.next = second.next;
//    		second.next = first;
//    		pre = first;
//    	}
//    	return dummy.next;
    	
    	//递归�?
    	if(head == null || head.next == null)
    		return head;
    	//这里默认后面的已经排好了，我们返回下�?个part的first
    	ListNode nextPair = swapPairs(head.next.next);
    	ListNode first = head;
        ListNode second = head.next;
        first.next = nextPair;
        second.next = first;
        return second;
     }
    
    public ListNode partition(ListNode head, int x) {
    	if(head == null || head.next == null){
    		return head;
    	}
    	//双链表实现链表分�?
    	ListNode before = new ListNode(-1);
    	ListNode after = new ListNode(-1);
    	ListNode cur1 = before, cur2 = after;
    	while(head != null){
    		if(head.val < x){
    			cur1.next = head;
    			cur1 = cur1.next;
    		}else{
    			cur2.next = head;
    			cur2 = cur2.next;
    		}
    		head = head.next;
    	}
    	//这一步很重要
    	cur2.next = null;
    	//将两个链表拼�?
    	cur1.next = after.next;
    	return before.next;
    }
    //第一反应想到的是单调�?
    public int[] nextLargerNodes(ListNode head) {
//    	if(head == null){
//    		return null;
//    	}
//    	int len = 0;
//    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//    	ListNode cur = head;
//    	while(cur != null){
//    		map.put(len, cur.val);
//    		len++;
//    		cur = cur.next;
//    	}
//    	int[] arr = new int[len];
//    	int i = 0;
//    	Stack<Integer> stack = new Stack<Integer>();
//    	cur = head;
//    	while(cur != null){
//    			while(!stack.isEmpty() && map.get(stack.peek()) < cur.val){
//    				map.put(stack.pop(), cur.val);
//    			}
//    		stack.push(i++);
//    		cur = cur.next;
//    	}
//    	while(!stack.isEmpty()){
//    		map.put(stack.pop(), 0);
//    	}
//    	for(i=0; i<len; i++){
//    		arr[i] = map.get(i);
//    	}
//    	return arr;
    	Stack stack = new Stack();
        ArrayList<Integer> data = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        int index = 0;
        while(head != null) {
            res.add(0);
            data.add(head.val);
            while (!stack.empty() && head.val > data.get((Integer)stack.peek())) {
                res.set((Integer)stack.pop(), head.val);
            }
            stack.push(index);
            index++;
            head = head.next;
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    //采用原地算法
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
       ListNode odd = head,  evenHead = head.next, even = evenHead; 
       while(even != null && even.next != null){
    	   odd.next = even.next;
    	   even.next = even.next.next;
    	   odd = odd.next;    	  
    	   even = even.next;
       }
       odd.next = evenHead;
       return head;
}
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode con = prev, tail = cur;
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }
    public int fib(int n) {
    	if(n == 0){
    		return 0;
    	}
    	if(n == 1)
    		return 1;
    	else
    		return (int) ((fib(n-1) + fib(n-2)) % (1e9+7));
    }
}
//[1, 1, 1, 1, 2]
