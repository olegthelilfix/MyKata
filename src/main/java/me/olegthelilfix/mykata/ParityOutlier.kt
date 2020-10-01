package me.olegthelilfix.mykata

fun find(integers: Array<Int>): Int {
    var countOfEvenNumber = 0
    for (i in 0..2) {
        if (isEven(integers[i])) {
            countOfEvenNumber++;
        }
    }

    val condition = if (countOfEvenNumber >= 2) ::isOdd else ::isEven

    for(i in integers) {
        if (condition(i)) {
            return i
        }
    }

    return 0
}

private fun isOdd(n: Int) = n % 2 != 0

private fun isEven(n: Int) = n % 2 == 0
