/*
 * Copyright © 2014-2016 Lightbend, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Lightbend, Inc.
 */

package com.lightbend.k8s.cli

import utest._

object MainTest extends TestSuite {
  val tests = this{
    "just a placeholder" - {
      assert(Main.test == "Hey")
    }
  }
}
