package me.olegthelilfix.leetcoding.old

import me.olegthelilfix.leetcoding.ListNode

// Given the head of a singly linked list, reverse the list, and return the reversed list.
fun reverseList(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }

    return reverseList(head, null)
}

fun reverseList(head: ListNode, previous: ListNode?): ListNode {
    if (head.next == null) {
        head.next = previous
        return head
    }

    val next = head.next!!
    head.next = previous

    return reverseList(next, head)
}
