/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        else if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        int carry = 0;
        ListNode currentl1 = l1;
        ListNode currentl2 = l2;
        ListNode result = new ListNode(0);
        ListNode currentResult = result;
        while(currentl1 != null && currentl2 != null) {
            int valueTotal = currentl1.val + currentl2.val + carry;
            carry = valueTotal/10;
            ListNode nd = new ListNode(valueTotal%10);
            currentResult.next = nd;
            currentResult = nd;
            currentl1 = currentl1.next;
            currentl2 = currentl2.next;
        }

        if (carry == 0) {
            if(currentl1 == null && currentl2 == null) {
                return result.next;
            }
            if(currentl2 == null) {
                 currentResult.next = currentl1;
            }
            else{
                currentResult.next = currentl2;
            }
        }
        if(carry != 0) {
            if(currentl1 == null && currentl2 == null) {
                 ListNode nd = new ListNode(carry);
                 currentResult.next = nd;
                return result.next;
            }
            if(currentl2 == null) {
                while(currentl1 != null) {
                    ListNode nd = new ListNode((currentl1.val + carry)%10);
                    carry = (currentl1.val + carry)/10;
                    currentResult.next = nd;
                    currentResult = nd;
                    currentl1 = currentl1.next;
                }
                if(carry != 0) {
                    ListNode nd = new ListNode(carry);
                    currentResult.next = nd;
                }
            }
            else{
               while(currentl2 != null) {
                    ListNode nd = new ListNode((currentl2.val + carry)%10);
                    carry = (currentl2.val + carry)/10;
                    currentResult.next = nd;
                    currentResult = nd;
                    currentl2 = currentl2.next;
                }
                if(carry != 0) {
                    ListNode nd = new ListNode(carry);
                    currentResult.next = nd;
                }
            }
        }
        return result.next;
    }
}
