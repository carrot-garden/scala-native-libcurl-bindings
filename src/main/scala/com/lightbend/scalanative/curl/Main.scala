/*
 * Copyright © 2014-2016 Lightbend, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Lightbend, Inc.
 */

package com.lightbend.scalanative.curl

object Main {
  val test = "Hey"

  def main(args: Array[String]): Unit = {

    println("curl_easy_init")
    val curl = libcurl.curl_easy_init()

    if (curl != null) {
      println("got curl handle")

      println("curl_easy_cleanup")
      libcurl.curl_easy_cleanup(curl)
    }
    println("done")

  }
}
