package com.javainuse;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	static class node{
		int data;
		node left,right;
		node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	static boolean searchTree(node head, int data) {
		if(head==null)
			return false;
		if(head.data==data)
			return true;
		
		boolean left=false,right=false;
			left= searchTree(head.left,data);
			right=searchTree(head.right,data);
		return left||right;
		
	}
	static node createTree(int arr[]){
		node head= new node(arr[0]);
		Queue<node> q= new LinkedList<>();
		q.add(head);
		for(int i=1;i<arr.length;i=i+2) {
			node temp=q.peek();
			if(arr[i]!=-1) {
				temp.left= new node(arr[i]);
				q.add(temp.left);
			}
			
			if(i+1<arr.length) {
				if(arr[i+1]!=-1) {
					temp.right=new node(arr[i+1]);
					q.add(temp.right);
				}
			}
			q.remove();
		}
		return head;
		
	}
	public static void main(String args[]) {
		int arr[]= {2,7,5,2,6,-1,9,-1,-1,5,11,4,-1};
		node head=createTree(arr);
		int search =0;
		boolean t=searchTree(head,search);
		System.out.print(t);
		System.out.println(head.data);
		System.out.println(head.left.data);
		System.out.println(head.right.data);
		System.out.println(head.left.left.data);
		System.out.println(head.left.right.data);
		System.out.println(head.right.right.data);
	}
}
