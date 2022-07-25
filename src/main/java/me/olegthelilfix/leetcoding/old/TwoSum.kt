package me.olegthelilfix.leetcoding.old

class TwoSum {
    fun twoSum(numbers: IntArray, target: Int): Pair<Int,Int> {
        if (numbers.size < 2) {
            return Pair(0,0)
        }
        for (i in numbers.indices) {
            for (j in i + 1 until numbers.size) {
                if ((numbers[i] + numbers[j]) == target) {
                    return Pair(i,j)
                }
            }
        }

        return Pair(0,0)
    }
}

fun main() {
//    val arr = IntArray(10)
    print(TwoSum().twoSum(listOf<Int>(1, 2, 4, 5, 6).toIntArray(), 11).toList())
}
