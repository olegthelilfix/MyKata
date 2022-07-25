package me.olegthelilfix.leetcoding

data class ListNode(var `val`: Int, var next: ListNode? = null)

// find the distance between two nodes in a linked list
fun getDistance(head: ListNode?, target: ListNode?): Int {
    var distance = 0
    var current = head
    while (current != null) {
        if (current == target) {
            return distance
        }
        current = current.next
        distance++
    }

    return distance
}

fun main() {
    listOf<String>().joinToString()
}
