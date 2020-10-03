package me.olegthelilfix.mykata

import me.olegthelilfix.mykata.five.interpret
import org.junit.Test

import org.junit.Assert.*

class SimpleAssemblerInterpreterKtTest {
    @Test
    fun simple1() {
        assertEquals(
                mapOf("a" to 1),
                interpret(arrayOf("mov a 5", "inc a", "dec a", "dec a", "jnz a -1", "inc a"))
        )
    }

    @Test
    fun simple2() {
        assertEquals(
                mapOf("a" to 0, "b" to -20),
                interpret(arrayOf("mov a -10", "mov b a", "inc a", "dec b", "jnz a -2"))
        )
    }
}
