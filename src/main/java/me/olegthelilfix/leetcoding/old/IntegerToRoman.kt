package me.olegthelilfix.leetcoding.old


data class RomanNumber(val letter: String, val value: Int)
val numberOrder : List<RomanNumber> = listOf(
        RomanNumber("M", 1000),
        RomanNumber("CM", 900),
        RomanNumber("D", 500),
        RomanNumber("CD", 400),
        RomanNumber("C", 100),
        RomanNumber("XC", 90),
        RomanNumber("L", 50),
        RomanNumber("XL", 40),
        RomanNumber("X", 10),
        RomanNumber("IX", 9),
        RomanNumber("V", 5),
        RomanNumber("IV", 4),
        RomanNumber("I", 1),
)

fun intToRoman(num: Int): String {
    var result = ""
    var buffer = num
    var letterIndex = 0
    var romanNumber = numberOrder[letterIndex++]

    while (buffer > 0) {
        if((buffer - romanNumber.value) < 0) {
            romanNumber = numberOrder[letterIndex++]
        }
        else {
            buffer -= romanNumber.value
            result += romanNumber.letter
        }
    }

    return result
}

val letters = mapOf(
        "M" to 1000,
        "CM" to 900,
        "D" to 500,
        "CD" to 400,
        "C" to 100,
        "XC" to 90,
        "L" to 50,
        "XL" to 40,
        "X" to 10,
        "IX" to 9,
        "V" to 5,
        "IV" to 4,
        "I" to 1
)

fun romanToInt(s: String): Int {
    var i = 0
    var result = 0

    while (i < s.length) {
        val l1 = letters[s[i].toString()] ?: 0
        var l2 = 0

        if (i < s.length - 1 && letters.containsKey(s[i].toString() + s[i+1].toString())) {
            l2 = letters[s[i].toString() + s[i+1].toString()] ?: 0
            i++
        }

        result += if (l1 > l2) l1 else l2

        i++
    }

    return result
}

fun main() {
    println(romanToInt("IV"))
    for (i in 1 .. 10000) {
        val n = intToRoman(i)
        val n2 = romanToInt(n)

        if (n2 != i) {
            println("$i!=$n2")
        }
    }
}
