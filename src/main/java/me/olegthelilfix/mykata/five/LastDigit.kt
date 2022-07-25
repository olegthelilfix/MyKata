package me.olegthelilfix.mykata.five

import junit.framework.TestCase.assertEquals
import java.math.BigInteger
import kotlin.math.pow

fun lastDigit(base: BigInteger, exponent: BigInteger): Int {
    val lastDigit = base.mod(BigInteger.TEN).toInt()
    if (exponent <= BigInteger.ONE){
        return lastDigit.toDouble().pow(exponent.toInt()).toInt()
    }
    val pow = when(exponent.mod(BigInteger("4")).toInt()) {
        1 -> 1
        2 -> 2
        3 -> 3
        0 -> 4
        else -> 0
    }
    return (lastDigit.toDouble().pow(pow.toDouble()) % 10).toInt()
}

fun main() {
//    print(lastDigit(BigInteger("2"), BigInteger("100")))
    assertEquals(4, lastDigit(BigInteger("4"), BigInteger("1")))
    assertEquals(6, lastDigit(BigInteger("4"), BigInteger("2")))
    assertEquals(9, lastDigit(BigInteger("9"), BigInteger("7")))
    assertEquals(0, lastDigit(BigInteger("10"), BigInteger("10000000000")))
    assertEquals(1, lastDigit(BigInteger("10"), BigInteger("0")))
    assertEquals(1, lastDigit(BigInteger("9435756757744477447576867898089079079808908347583277453475"), BigInteger("0")))
    assertEquals(6, lastDigit(BigInteger("1606938044258990275541962092341162602522202993782792835301376"), BigInteger("2037035976334486086268445688409378161051468393665936250636140449354381299763336706183397376")))
    assertEquals(7, lastDigit(BigInteger("3715290469715693021198967285016729344580685479654510946723"), BigInteger("68819615221552997273737174557165657483427362207517952651")))
}
