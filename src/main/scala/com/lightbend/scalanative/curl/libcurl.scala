/*
 * Copyright © 2014-2016 Lightbend, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Lightbend, Inc.
 */

package com.lightbend.scalanative.curl

import scala.scalanative.native

@native.link("curl")
@native.extern
object libcurl {
  type CURL = native.Ptr[Unit]

  def curl_easy_init(): CURL = native.extern
  def curl_easy_cleanup(curl: CURL): Unit = native.extern

}
