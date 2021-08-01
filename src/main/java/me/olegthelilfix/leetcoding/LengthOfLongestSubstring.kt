package me.olegthelilfix.leetcoding

class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.isEmpty()) {
            return 0
        }
        if(s.length == 1) {
            return 1
        }
        var length = 0
        var subString: MutableList<Char> = mutableListOf()

        for (i in 0..s.length - 2) {
            subString = mutableListOf(s[i])

            for (j in i + 1 until s.length) {
                if (!subString.contains(s[j])) {
                    subString.add(s[j])
                } else {
                    break
                }
            }
            if (subString.size > length) {
                length = subString.size
            }
        }

        if (subString.size > length) {
            length = subString.size
        }

        return length
    }
}

fun main() {
    print(LengthOfLongestSubstring().lengthOfLongestSubstring(""))
}