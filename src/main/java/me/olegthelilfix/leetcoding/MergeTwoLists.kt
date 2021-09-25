package me.olegthelilfix.leetcoding

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 == null) {
        return null
    }

    var n1 = l1
    var n2 = l2

    var next: ListNode?  = null

//    if ((l1?.`val` ?: 0) > (l2?.`val` ?: 0)) {
//        next = l1
//    }
    var head: ListNode? = null

    while (n1 != null || n2 != null) {

        if (n1 != null && n2 != null) {
            if (n1.`val` > n2.`val`) {

                if (head == null) {

                }
            }
        }

        if (n1 != null) {
            n1 = n1.next
        }

        if (n2 != null) {
            n2 = n2.next
        }
    }
}