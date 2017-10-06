package com.lightbend.scalanative.curl

import scala.scalanative.native

@native.link("curl")
@native.extern
object libcurl {
  type CURL = native.Ptr[_]
  type CURLcode = native.Ptr[_]

  def curl_easy_init(): CURL = native.extern

  /*
   These 2 lines is supposed to represent the following inside curl/curl.h

   #define CURLOPTTYPE_STRINGPOINT   10000

   #define CINIT(na,t,nu) CURLOPT_ ## na = CURLOPTTYPE_ ## t + nu

   typedef enum {
     /* The full URL to get/put */
     CINIT(URL, STRINGPOINT, 2),

     // more enum declarations (like 260+ enums) not shown
   } CURLoption;

   The macro above should generate a typedef enum called CURLOPT_URL with the value of 10002.

   I've ran a quick check with https://godbolt.org/g/ZDYwbt and the above seems to be the case.

   Possibly related?: https://github.com/scala-native/scala-native/issues/205

   */
  class CURLoption(val value: native.CInt) extends AnyVal
  val CURLOPT_URL: CURLoption = native.extern

  /*
   Is this how do we represent this method, particularly the parameter which can be a long, function pointer, object pointer, or curl_off_t?

   From https://curl.haxx.se/libcurl/c/curl_easy_setopt.html

   All options are set with an option followed by a parameter. That parameter can be a long, a function pointer, an object pointer or a curl_off_t, depending on what the specific option expects.
   */
  def curl_easy_setopt(curl: CURL, curlOption: CURLoption, parameter: native.Ptr[_]): CURLcode = native.extern

  def curl_easy_cleanup(curl: CURL): Unit = native.extern

}
