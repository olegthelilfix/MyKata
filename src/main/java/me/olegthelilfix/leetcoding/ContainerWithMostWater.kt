package me.olegthelilfix.leetcoding

fun maxArea(height: IntArray): Int {
    var max = 0
    for (i in height.indices) {
        for (j  in i + 1 until height.size) {
            val y = if (height[i] > height[j]) height[j] else height[i]
            val x = j - i

            val s = x * y

            if (s > max) {
                max = s
            }
        }
    }

    return max
}

fun main() {
    println(maxArea(listOf(1,8,6,2,5,4,8,3,7).toIntArray()))
}