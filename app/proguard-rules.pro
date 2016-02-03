-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*


-keepattributes Signature, SourceFile, LineNumberTable
-keepattributes *Annotation*

-keep class android.support.v4.** {*;}
-keep interface android.support.v4.** {*;}
-keep class android.support.v7.** {*;}
-keep interface android.support.v7.** {*;}
###############################友盟混淆
-keepclassmembers class * {
   public <init>(org.json.JSONObject);
}
-keep public class com.paxw.game2048.R$*{
    public static final int *;
}
-keep public class com.umeng.fb.ui.ThreadView {
}
-libraryjars libs/umeng-sdk.jar
-keep public class * extends com.umeng.**
-keep class com.umeng.** { *; }

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#######友盟自动更新混淆结束




-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment




-dontskipnonpubliclibraryclassmembers
