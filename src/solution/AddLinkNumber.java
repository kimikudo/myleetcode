package solution;

import defined.ListNode;

public class AddLinkNumber {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int res = 0;
        ListNode root = new ListNode(99);
        ListNode result = null;
        int index = 0;
        while (l1 != null && l2 != null) {
            res = l1.val + l2.val;
if (root != null) {
                root.next = new ListNode(res % 10 + carry);
            } else {
                root = new ListNode(res % 10 + carry);
                result = root;
            }

            root.next = new ListNode((res + carry) % 10);
            if (index == 0) {
                result = root;
            }

            carry = (res + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
            root = root.next;
            index++;
        }
        if (l1 != null) {
            root.next = l1;
        } else if (l2 != null) {
            root.next = l2;
        }
        nodeAddNumber(root, carry);
        return result.next;
    }

    /**
     * 一个链表数字,加一个数,用于对进位进行处理
     *
     * @param node
     * @param n
     * @return
     */
    public void nodeAddNumber(ListNode node, int n) {
        int res = 0;
        //ListNode point = node;
        while (n != 0) {
            if (node.next != null) {
                res = node.next.val + n;
                node.next.val = res % 10;
                n = res / 10;
            } else {
                node.next = new ListNode(n);
                n /= 10;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);
        //l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(2);
        //l2.next.next = new ListNode(8);
        //l2.next.next.next = new ListNode(5);

        AddLinkNumber addLinkNumber = new AddLinkNumber();
        ListNode result = addLinkNumber.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
