package me.olegthelilfix.leetcoding

class ReverseInteger {
    fun reverse(x: Int): Int {
        return try {
            if (x > 0) {
                x.toString().reversed().toInt()
            }
            else {
                (x * -1).toString().reversed().toInt() * -1
            }
        }
        catch (e: NumberFormatException) {
            0
        }
    }
}
