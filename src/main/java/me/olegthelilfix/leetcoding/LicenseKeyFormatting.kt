package me.olegthelilfix.leetcoding

fun licenseKeyFormatting(s: String, k: Int): String {
    var result = ""
    var lettersInGroup = 0
    for(i in s.length - 1 downTo 0) {
        val char = s[i]
        if (char == '-') {
            continue
        }

        if(lettersInGroup >= k) {
            result = "-$result"
            lettersInGroup = 0
        }

        lettersInGroup++

        result = char.toUpperCase() + result
    }
    return result
}

fun main() {
    println(licenseKeyFormatting("5F3Z-2e-9-w", 4))
}
