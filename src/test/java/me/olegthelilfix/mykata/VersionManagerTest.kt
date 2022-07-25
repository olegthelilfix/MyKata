package me.olegthelilfix.mykata

import me.olegthelilfix.mykata.six.VersionManager
import org.junit.Assert
import org.junit.Test

internal class VersionManagerTest {
    @Test
    fun initializationTests() {
        try {
            Assert.assertEquals("0.0.1", VersionManager("1.0.0.aaa").release())
            Assert.assertEquals("7.17.53", VersionManager("7.17.53").release())
            Assert.assertEquals("0.0.1", VersionManager("").release())
            Assert.assertEquals("1.2.3", VersionManager("1.2.3").release())
            Assert.assertEquals("1.2.3", VersionManager("1.2.3.4").release())
            Assert.assertEquals("1.2.3", VersionManager("1.2.3.d").release())
            Assert.assertEquals("1.0.0", VersionManager("1").release())
            Assert.assertEquals("1.1.0", VersionManager("1.1").release())
        } catch (e: Exception) {
            Assert.fail()
        }
    }

    @Test
    fun majorReleasesTests() {
        try {
            Assert.assertEquals("1.0.0", VersionManager().major().release())
            Assert.assertEquals("2.0.0", VersionManager("1.2.3").major().release())
            Assert.assertEquals("3.0.0", VersionManager("1.2.3").major().major().release())
        } catch (e: Exception) {
            Assert.fail()
        }
    }

    @Test
    fun minorReleasesTests() {
        try {
            Assert.assertEquals("0.1.0", VersionManager().minor().release())
            Assert.assertEquals("1.3.0", VersionManager("1.2.3").minor().release())
            Assert.assertEquals("1.1.0", VersionManager("1").minor().release())
            Assert.assertEquals("4.2.0", VersionManager("4").minor().minor().release())
        } catch (e: Exception) {
            Assert.fail()
        }
    }

    @Test
    fun patchReleasesTests() {
        try {
            Assert.assertEquals("0.0.2", VersionManager().patch().release())
            Assert.assertEquals("1.2.4", VersionManager("1.2.3").patch().release())
            Assert.assertEquals("4.0.2", VersionManager("4").patch().patch().release())
        } catch (e: Exception) {
            Assert.fail()
        }
    }

    @Test
    fun rollbacksTests() {
        try {
            Assert.assertEquals("0.0.1", VersionManager().major().rollback().release())
            Assert.assertEquals("0.0.1", VersionManager().minor().rollback().release())
            Assert.assertEquals("0.0.1", VersionManager().patch().rollback().release())
            Assert.assertEquals("1.0.0", VersionManager().major().patch().rollback().release())
            Assert.assertEquals("1.0.0", VersionManager().major().patch().rollback().major().rollback().release())
        } catch (e: Exception) {
            Assert.fail()
        }
    }

    @Test
    fun seperatedCallsTests() {
        try {
            val m = VersionManager("1.2.3")
            m.major()
            m.minor()
            Assert.assertEquals("2.1.0", m.release())
        } catch (e: Exception) {
            Assert.fail()
        }
    }

    @Test
    fun exceptionsTests() {
        try {
            val m = VersionManager("a.b.c")
            Assert.fail("Expected an Exception to be thrown")
        } catch (e: Exception) {
            Assert.assertEquals("Error occured while parsing version!", e.message)
        }
        try {
            val m = VersionManager().rollback()
            Assert.fail("Expected an Exception to be thrown")
        } catch (e: Exception) {
            Assert.assertEquals("Cannot rollback!", e.message)
        }
    }
}
