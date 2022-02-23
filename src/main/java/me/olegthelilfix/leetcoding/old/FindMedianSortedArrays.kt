package me.olegthelilfix.leetcoding.old

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
class FindMedianSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val result = IntArray(nums1.size + nums2.size)

        var i = 0
        var j = 0

        var index = 0

        val s1 = nums1.size
        val s2 = nums2.size

        while (index < result.size) {
            val n1 = if (s1 > i) nums1[i] else Int.MAX_VALUE
            val n2 = if (s2 > j) nums2[j] else Int.MAX_VALUE

            if(n1 < n2) {
                result[index] = nums1[i]
                i++
            }
            else {
                result[index] = nums2[j]
                j++
            }
            index++
        }

        return if ((result.size) % 2 != 0) {
            result[(result.size) / 2].toDouble()
        }
        else {
            (result[result.size/2] +result[result.size/2 - 1])/2.0
        }
    }
}

fun main() {
    println(
        FindMedianSortedArrays().findMedianSortedArrays(
            listOf(1, 2).toIntArray(),
            listOf(3, 4).toIntArray(),
    ))
}
