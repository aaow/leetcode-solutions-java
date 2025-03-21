import java.util.Random;

/*
* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
* */
/**
 * @Author: chz
 * @Date: 2025/3/21 13:50
 * @Description: TODO
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers s = new AddTwoNumbers();
        ListNode a = new ListNode(0);
        ListNode x = a;
        for (int i = 0; i < (int) (Math.random()*10); i++) {
            x.next = new ListNode((int) (Math.random()*10));
            x = x.next;
        }
        System.out.print("a : ");
        s.print(a);
        ListNode b = new ListNode(5);
        x = b;
        for (int i = 0; i < (int) (Math.random()*10); i++) {
            x.next = new ListNode((int) (Math.random()*10));
            x = x.next;
        }
        System.out.print("b : ");
        s.print(b);
        ListNode listNode = s.addTwoNumbers(a, b);
        System.out.print("r : ");
        s.print(listNode);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
//            System.out.println(curr.next.val);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
//            System.out.println(curr.next.val);
        }
        return dummyHead.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

    }
    public void print(ListNode head) {
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.val + " ");
                break;
            }
            System.out.print(head.val + "->" );
            head = head.next;
        }
        System.out.println();
    }
}

