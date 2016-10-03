# OkHttp
-keepattributes Signature
-keepattributes *Annotation*
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }

-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn com.squareup.**

-keep class com.squareup.** { *; }