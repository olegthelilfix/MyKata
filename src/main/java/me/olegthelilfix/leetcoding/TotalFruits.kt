package me.olegthelilfix.leetcoding

fun totalFruit(fruits: IntArray): Int {
    val maxFruit = 0
    val firsFruit = -1
    val secondFruit = -1
    for (i in fruits.indices) {
//        if
        for (j in i + 1 until fruits.size) {
            println(fruits[j])
        }
    }

    return 0
}
fun main() {
    totalFruit(intArrayOf(1,3,4))
}
