package org.jackJew.interview.calulator.test

import org.jackJew.interview.calulator.Add
import org.jackJew.interview.calulator.Clear
import org.jackJew.interview.calulator.DecimalCalculations
import org.jackJew.interview.calulator.Divide
import org.jackJew.interview.calulator.Multiply
import org.jackJew.interview.calulator.Sqrt
import org.jackJew.interview.calulator.Subtract
import org.jackJew.interview.calulator.Undo
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.Test
import java.math.BigDecimal
import java.util.Stack

@Test
class OperatorTest {

  private val stack = Stack<BigDecimal>()

  fun testAdd() {
    val res = Add().calc(arrayOf(BigDecimal(1), BigDecimal(2)))
    Assert.assertTrue(res == BigDecimal(3))
  }

  fun testSubtract() {
    val res = Subtract().calc(arrayOf(BigDecimal(1), BigDecimal(2)))
    Assert.assertTrue(res == BigDecimal(-1))
  }

  fun testMultiply() {
    val res = Multiply().calc(arrayOf(BigDecimal(2), BigDecimal(3)))
    Assert.assertTrue(res == BigDecimal(6))
  }

  fun testDivide() {
    val res = Divide().calc(arrayOf(BigDecimal(6), BigDecimal(2)))
    Assert.assertTrue(res == BigDecimal(3))
  }

  fun testSqrt() {
    val res = Sqrt().calc(arrayOf(BigDecimal(2)))
    Assert.assertTrue(DecimalCalculations.toString(res).length == 12)
  }

  fun testClear() {
    stack.push(BigDecimal(100))
    Clear().calc(stack)
  }

  @AfterMethod
  fun testUndo() {
    stack.push(BigDecimal.ONE)
    Undo().calc(stack)
  }

}