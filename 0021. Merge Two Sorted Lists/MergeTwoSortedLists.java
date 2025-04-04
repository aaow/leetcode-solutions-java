import java.util.ArrayList;

/**
 * @projectName: leetcode-solutions-java
 * @package: PACKAGE_NAME
 * @className: MergeTwoSortedLists
 * @author: chz
 * @description: TODO
 * @date: 2025/4/4 15:08
 * @version: 1.0
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        Integer[] list1 = new Integer[]{2, 4, 5, 10};
        Integer[] list2 = new Integer[]{3, 7, 8, 13};
        ListNode head1 = null;
        for (int i = list1.length-1; i >= 0; i--) {
            int val = list1[i];
            head1 = new MergeTwoSortedLists().new ListNode(val, head1);
        }
        ListNode head2 = null;
        for (int i = list2.length-1; i >= 0; i--) {
            int val = list2[i];
            head2 = new MergeTwoSortedLists().new ListNode(val, head2);
        }
        ListNode list = new MergeTwoSortedLists().mergeTwoLists(head1, head2);



        ListNode current = list;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

    }

}
