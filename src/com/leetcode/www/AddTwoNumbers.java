package com.leetcode.www;

public class AddTwoNumbers {

    public static void main(String[] args) {
        final AddTwoNumbers obj = new AddTwoNumbers();
        final obj.
        final ListNode l1 = new ListNode(2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode node = root;
        if (l1 == null && l2 == null) {
            return node;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        int carry = 0;
        while (l1 != null || l2 != null) {
            final int first = (l1 != null) ? l1.val : 0;
            final int second = (l2 != null) ? l2.val : 0;
            final int rem = (first + second) % 10;
            if (node == null) {
                root = new ListNode(rem + carry);
                node = root;
                System.out.println(node.val+":here");
            } else {
                if(rem + carry > 9) { 
                    node.next = new ListNode((rem + carry)/10);
                }
                node = node.next;
                System.out.println(node.val+":there");
            }
            carry = (first + second+rem) / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if(carry > 0) {
            node.next = new ListNode(carry);
        }
        return root;
    }

    class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
