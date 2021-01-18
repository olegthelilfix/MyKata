package me.olegthelilfix.mykata

import org.junit.Assert
import org.junit.Test
import me.olegthelilfix.mykata.own.findFirstSubString

class SimpleSubStringSearchKtTest {

    @Test
    fun `Substring longer than string`() {
        Assert.assertNull(findFirstSubString("12345", "123456"))
        Assert.assertNull(findFirstSubString("54321", "123456"))
    }

    @Test
    fun `Empty string`() {
        Assert.assertNull(findFirstSubString("", "123456"))
    }

    @Test
    fun `Empty substring`() {
        Assert.assertNull(findFirstSubString("12323123", ""))
    }

    @Test
    fun `Empty substring and string`() {
        Assert.assertNull(findFirstSubString("", ""))
    }

    @Test
    fun `Correct finding`() {
        Assert.assertEquals(findFirstSubString("12345", "123"), 0)
        Assert.assertEquals(findFirstSubString("54321321", "321"), 2)
        Assert.assertEquals(findFirstSubString("123456789ABCDE123456789", "ABCDE"), 9)
        Assert.assertEquals(findFirstSubString("123456789ABCDE123456789", "A"), 9)
        Assert.assertEquals(findFirstSubString("123456789ABCDE123456789", "a"), null)
        Assert.assertEquals(findFirstSubString("111234", "1234"), 2)
    }
}