package me.olegthelilfix.leetcoding

class ListNode(var `val`: Int, var next: ListNode? = null) {

}

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return addTwoNumbers(l1, l2, 0)
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, inc: Int): ListNode? {
        if(l1 == null && l2 == null) {
            if(inc > 0) {
                return ListNode(1)
            }
            return null
        }

        val v1 = l1?.`val` ?: 0
        val v2 = l2?.`val` ?: 0

        var newVal = v1 + v2 + inc
        var newInc = 0

        if (newVal > 9) {
            newVal -= 10
            newInc = 1
        }

        val node = ListNode(newVal)

        node.next = addTwoNumbers(l1?.next, l2?.next, newInc)

        return node
    }

}

fun main() {
    val n1 = ListNode(9)
    val n2 = ListNode(1, n1)
    val n3 = ListNode(1, n2)

    val q1 = ListNode(9)
    val q2 = ListNode(1, q1)
    val q3 = ListNode(1, q2)

    val r = AddTwoNumbers().addTwoNumbers(n3, q3)

    print(r)
}