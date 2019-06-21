package org.jackJew.interview.calulator.test

import org.jackJew.interview.calulator.DecimalCalculations
import org.testng.Assert
import org.testng.annotations.Test
import java.math.BigDecimal

@Test
class DecimalCalculationsTest {

  fun testToDecimal() {
    val d = DecimalCalculations.toDecimal("66.123456789098765432")
    Assert.assertEquals(d.toPlainString().length, 16)
  }

  fun testToString() {
    val s = DecimalCalculations.toString(BigDecimal("66.123456789098765"))
    Assert.assertEquals(s.length, 13)
  }
}