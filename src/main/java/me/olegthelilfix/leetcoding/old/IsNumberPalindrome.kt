package me.olegthelilfix.leetcoding.old

fun isPalindrome(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    val s = toList(x)

    for (i in 0 .. s.size/2) {
        if(s[i] != s[s.size-i-1]) {
            return false
        }
    }

    return true
}

private fun toList(value: Int): List<Int> {
    var copy = value
    val result = mutableListOf<Int>()

    while (copy > 0) {
        result.add(copy % 10)
        copy /= 10
    }

    return result
}

fun main() {
    print(isPalindrome(1234321))
}
