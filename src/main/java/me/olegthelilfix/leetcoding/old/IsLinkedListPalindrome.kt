package me.olegthelilfix.leetcoding.old

import me.olegthelilfix.leetcoding.ListNode

fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) {
        return false
    }

    val reversed = reverse(clone(head), null)
    var n1 = reversed.next
    var n2 = head.next

    while (n1 != null && n2 != null) {
        if (n1.`val` != n2.`val`) {
            return false
        }
        n1 = n1.next
        n2 = n2.next
    }

    return true
}

fun clone(head: ListNode): ListNode {
    if (head.next == null) {
        return ListNode(head.`val`)
    }

    val clone = ListNode(head.`val`)

    clone.next = clone(head.next!!)

    return clone

}

fun reverse(head: ListNode, previous: ListNode? = null): ListNode {
    if (head.next == null) {
        head.next = previous
        return head
    }

    val next = head.next!!
    head.next = previous

    return reverse(next, head)
}

fun main() {
    val n1 = ListNode(1)
    val n2 = ListNode(4, n1)
    val n3 = ListNode(1, n2)

//    val q1 = ListNode(9)
//    val q2 = ListNode(1, q1)
//    val q3 = ListNode(1, q2)

    print(isPalindrome(n3))
}
