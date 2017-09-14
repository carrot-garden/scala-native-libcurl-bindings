/*
 * Copyright © 2014-2016 Lightbend, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Lightbend, Inc.
 */

package com.lightbend.scalanative.curl

import scala.scalanative.native._

object Main {
  def main(args: Array[String]): Unit = {

    println("curl_easy_init")
    val curl = libcurl.curl_easy_init()

    if (curl != null) {
      println("got curl handle")

      libcurl.curl_easy_setopt(curl, libcurl.CURLOPT_URL, c"http://www.example.org")

      // TODO: curl_easy_perform
      // TODO: extract response code & entity body (as text to begin with)?

      println("curl_easy_cleanup")
      libcurl.curl_easy_cleanup(curl)
    }
    println("done")

  }
}
