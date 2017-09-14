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
  type CURLCode = native.Ptr[native.CInt]

  val CURL_GLOBAL_ALL = native.extern
  val CURL_GLOBAL_SSL = native.extern
  val CURL_GLOBAL_WIN32 = native.extern
  val CURL_GLOBAL_NOTHING = native.extern
  val CURL_GLOBAL_DEFAULT = native.extern
  val CURL_GLOBAL_ACK_EINTR = native.extern

  def curl_global_init(globalFlags: native.CLong): CURLCode = native.extern
  def curl_easy_init(): CURL = native.extern
  def curl_easy_cleanup(curl: CURL): Unit = native.extern
}
