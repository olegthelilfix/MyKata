package me.olegthelilfix.leetcoding

/**
 * The function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */

private fun longestPrefix(first: String, second: String): String {
    val minLen = if (first.length > second.length) second.length else first.length

    var longestPrefix = ""

    for (i in 0 until  minLen) {
        if (first[i] == second [i]) {
            longestPrefix += first[i]
        }
        else {
            break
        }
    }

    return longestPrefix
}
