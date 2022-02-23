package me.olegthelilfix.leetcoding.old

import me.olegthelilfix.leetcoding.ListNode

// Given the head of a singly linked list and two integers left and right where left <= right,
// reverse the nodes of the list from position left to position right, and return the reversed list.
fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    var current = head
    var prev: ListNode? = null
    var i = 1
    var breakStart: ListNode? = head
//    var breakEnd: ListNode? = null

    var brPlus: ListNode? = null

    while (current != null) {
        if (i == left) {
            if(prev != null) {
                breakStart = prev
            }
        }
        if (i == right + 1) {
            break
        }
        if (i == right) {
            brPlus = prev?.next
        }

        if (i in left .. right) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }
        else {
            current = current.next
        }

        i++
    }

//    if (brPlus == null ){
//        brPlus = prev
//    }

    breakStart?.next = prev
    brPlus?.next = current

    return head
}

fun main() {
//    val n1 = ListNode(6)
    val n2 = ListNode(5)
    val n3 = ListNode(4, n2)
    val n4 = ListNode(3, n3)
    val n5 = ListNode(2, n4)
    val n6 = ListNode(1, n5)

    var r = reverseBetween(n3, 1,2)
    print("dsfdsf")
}
