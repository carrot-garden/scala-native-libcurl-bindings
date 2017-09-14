/*
 * Copyright © 2014-2016 Lightbend, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Lightbend, Inc.
 */

package com.lightbend.scalanative.curl

object Main {
  val test = "Hey"

  def main(args: Array[String]): Unit = {

    //    println("curl_global_init")
    //    libcurl.curl_global_init(libcurl.CURL_GLOBAL_DEFAULT)

    println("curl_easy_init")
    val curl = libcurl.curl_easy_init()

    println(s"curl: ${curl}")
    //
    //    if (curl != null) {
    //      println(s"got curl object ${curl}")
    //
    //      println("curl_easy_cleanup")
    //      libcurl.curl_easy_cleanup(curl)
    //
    //    }
    println("done")

  }
}
