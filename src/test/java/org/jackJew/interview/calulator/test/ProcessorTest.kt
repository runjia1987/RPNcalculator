package org.jackJew.interview.calulator.test

import org.jackJew.interview.calulator.Processor
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.Test

@Test
class ProcessorTest {
  private val processor = Processor()

  fun testInterprete1() {
    val res = processor.interprete("5 2")
    Assert.assertEquals(res, "5 2")
  }

  fun testInterprete2() {
    var res = processor.interprete("2 sqrt")
    Assert.assertEquals(res.length, 12)

    res = processor.interprete("clear 9 sqrt")
    Assert.assertEquals(res, "3")
  }

  fun testInterprete3() {
    var res = processor.interprete("5 2 -")
    Assert.assertEquals(res, "3")

    res = processor.interprete("3 -")
    Assert.assertEquals(res, "0")
  }

  fun testInterprete4() {
    var res = processor.interprete("5 4 3 2")
    Assert.assertEquals(res, "5 4 3 2")

    res = processor.interprete("undo undo *")
    Assert.assertEquals(res, "20")

    res = processor.interprete("5 *")
    Assert.assertEquals(res, "100")

    res = processor.interprete("undo")
    Assert.assertEquals(res, "20 5")
  }

  fun testInterprete5() {
    var res = processor.interprete("7 12 2 /")
    Assert.assertEquals(res, "7 6")

    res = processor.interprete("*")
    Assert.assertEquals(res, "42")

    res = processor.interprete("4 /")
    Assert.assertEquals(res, "10.5")
  }

  fun testInterprete6() {
    processor.interprete("1 2 3 4 5")

    var res = processor.interprete("*")
    Assert.assertEquals(res, "1 2 3 20")

    res = processor.interprete("clear 3 4 -")
    Assert.assertEquals(res, "-1")
  }

  fun testInterprete7() {
    processor.interprete("1 2 3 4 5")

    val res = processor.interprete("* * * *")
    Assert.assertEquals(res, "120")
  }

  /**
   * Should be "position: 14", not 15.
   */
  fun testInterprete8() {
    val res = processor.interprete("1 2 3 * 5 + * * 6 5")
    Assert.assertTrue(res.contains("operator * (position: 14): insufficient parameters"))
    Assert.assertTrue(res.endsWith("11"))
  }

  @AfterMethod
  fun clean() {
    processor.interprete("clear")
  }

}