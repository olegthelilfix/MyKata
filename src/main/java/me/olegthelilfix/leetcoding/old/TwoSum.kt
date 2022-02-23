package me.olegthelilfix.leetcoding.old

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        if (nums.size < 2) {
            return IntArray(0)
        }
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if ((nums[i] + nums[j]) == target) {
                    return listOf(i, j).toIntArray()
                }
            }
        }

        return IntArray(0)
    }
}

fun main() {
//    val arr = IntArray(10)
    print(TwoSum().twoSum(listOf<Int>(1, 2, 4, 5, 6).toIntArray(), 11).toList())
}
