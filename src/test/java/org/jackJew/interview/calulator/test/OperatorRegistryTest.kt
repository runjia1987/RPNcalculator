package org.jackJew.interview.calulator.test

import org.jackJew.interview.calulator.Add
import org.jackJew.interview.calulator.Dummy
import org.jackJew.interview.calulator.OperatorRegistry
import org.jackJew.interview.calulator.Sqrt
import org.jackJew.interview.calulator.Undo
import org.testng.Assert
import org.testng.annotations.Test

@Test
class OperatorRegistryTest {

  fun testGet() {
    var oper = OperatorRegistry["1"]
    Assert.assertTrue(oper is Dummy)

    oper = OperatorRegistry["undo"]
    Assert.assertTrue(oper is Undo)

    oper = OperatorRegistry["+"]
    Assert.assertTrue(oper is Add)

    oper = OperatorRegistry["sqrt"]
    Assert.assertTrue(oper is Sqrt)

    oper = OperatorRegistry["a"]
    Assert.assertNull(oper)
  }
}