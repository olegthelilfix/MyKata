package me.olegthelilfix.mykata

import me.olegthelilfix.mykata.four.BlockSequence
import org.junit.Test

import org.junit.Assert.*

class BlockSequenceTest {
    private fun runTest(n:Long,sol:Int) = assertEquals(sol, BlockSequence.solve(n))

    @Test fun `Basic Test Cases`() {
        runTest(1L,1)
        runTest(2L,1)
        runTest(3L,2)
        runTest(100L,1)
        runTest(2100L,2)
        runTest(31000L,2)
        runTest(999999999999999999L,4)
        runTest(1000000000000000000L,1)
        runTest(999999999999999993L,7)
    }
}
