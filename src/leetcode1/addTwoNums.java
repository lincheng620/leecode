package leetcode1;

import java.util.Stack;

public class addTwoNums {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        System.out.println();
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args){
        Stack<ListNode> st = new Stack<>();
        ListNode ln = addTwoNumbers(new ListNode(29), new ListNode(32));
        while(ln != null){
            st.push(ln);
            ln = ln.next;
        }
        while(!st.empty()){
            System.out.print(st.pop().val);
        }

    }
}
