# Scala Native binding for libcurl

**STILL WORK IN PROGRESS - NOT READY FOR USE**

## Setup

Ensure `curl.h` is present in the system.

In macOS, the `curl.h` header file should already be present in the system.

In Ubuntu, install the following package to obtain `curl.h`:

```bash
$ sudo apt-get install libcurl4-gnutls-dev
```

## Problem binding libcurl's CURLOption

The `libcurl`'s `CURLOption` is a `typedef enum` which is generated using C `#define` macro:

https://github.com/curl/curl/blob/master/include/curl/curl.h#L910

At the moment I seem to be having the problem binding the `CURLOption`.

Execute the following command to bind `libcurl`:

```bash
$ sbt nativeLink
```

Running the program above will result in the following error:

```
[error] Undefined symbols for architecture x86_64:
[error]   "_CURLOPT_URL", referenced from:
[error]       _com.lightbend.scalanative.curl.Main$::main_scala.scalanative.runtime.ObjectArray_unit in com.lightbend.scalanative.curl.ll.o
[error] ld: symbol(s) not found for architecture x86_64
```

This error seemed strange as given the following `CURLOption`:

https://github.com/curl/curl/blob/master/include/curl/curl.h#L915 
 

the `#define` macro should generate an enum called `CURLOPT_URL` having `10002` as its value.

This can be confirmed by running the following cut-down `curl.h` snippet:

https://godbolt.org/g/ZDYwbt

which contains the following line:

```
!5 = !DIEnumerator(name: "CURLOPT_URL", value: 10002)
```