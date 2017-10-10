/*Accepted*/
package cn.xiaozhigang.leetcode.easy;
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class MergeTwoLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode ret = null,tail = null;
		if(p1 == null) return p2;
		if(p2 == null) return p1;
		if(p1.val < p2.val) {
			ret = p1;
			p1 = p1.next;
		} else {
			ret = p2;
			p2 = p2.next;
		}
		tail = ret;
		while(p1 != null && p2 != null) {
			if(p1.val < p2.val) {
				tail.next = p1;
				p1 = p1.next;
			} else {
				tail.next = p2;
				p2 = p2.next;
			}
			tail = tail.next;
		}
		tail.next = (p1 == null)?p2:p1;
        return ret;
    }
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(5);
		ListNode l3 = new ListNode(10);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(8);
		ListNode n3 = new ListNode(11);
		l1.next = l2; l2.next = l3; l3.next = null;
		n1.next = null; n2.next = n3; n3.next = null;
		ListNode ret = mergeTwoLists(l1,n1);
		for(ListNode p = ret; p != null; p = p.next) {
			System.out.println(p.val);
		}
	}
}
