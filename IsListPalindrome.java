/*
Given a singly linked list of integers, determine whether or not it's a palindrome.
*/

boolean isListPalindrome(ListNode<Integer> l) {
    if(l == null)
        return true;
    if(l.next == null)
        return true;
    ListNode<Integer> fast = l;
    ListNode<Integer> slow = l;
    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    ListNode<Integer> newList = slow;
    ListNode<Integer> current = l;
    while(current.next != slow) {
        current = current.next;
    }
    current.next = null;
    ListNode<Integer> secondList = reverse(newList);
    return sameElements(l, secondList);
}

boolean sameElements(ListNode<Integer> first, ListNode<Integer> second) {
    while( first != null && second != null) {
        if(first.value.intValue() != second.value.intValue())
            return false;
        first = first.next;
        second = second.next;
    }
    return true;
}

ListNode<Integer> reverse (ListNode<Integer> list) {
    if(list == null)
        return list;
    ListNode<Integer> prev = null;
    ListNode<Integer> current = list;
    ListNode<Integer> next = null;
    while(current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev;
}