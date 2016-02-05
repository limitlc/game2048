-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference

-keepattributes Signature, SourceFile, LineNumberTable
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }

-keep class android.support.v4.** {*;}
-keep interface android.support.v4.** {*;}

-keep class com.tencent.weibo.sdk.android.** {*;}
-keep interface com.tencent.weibo.sdk.android.** {*;}

-keep class com.kaixin.** {*;}
-keep interface com.kaixin.** {*;}

-keep class com.renren.api.connect.android.** {*;}
-keep interface com.renren.api.connect.android.** {*;}

-keep class com.baidu.** {*;}
-keep interface com.baidu.** {*;}

-keep class org.apache.commons.codec.** {*;}
-keep interface org.apache.commons.codec.** {*;}

-keep class org.apache.commons.httpclient.** {*;}
-keep interface org.apache.commons.httpclient.** {*;}

-keep class org.apache.james.mime4j.** {*;}
-keep interface org.apache.james.mime4j.** {*;}

-keep class com.google.gson.** {*;}
-keep interface com.google.gson.** {*;}

-keep class org.apache.http.entity.mime.** {*;}
-keep interface org.apache.http.entity.mime.** {*;}

-keep class com.tencent.mm.** {*;}
-keep interface com.tencent.mm.** {*;}

-keep class com.amap.api.search.** {*;}
-keep interface com.amap.api.search.** {*;}

-keep class com.iflytek.** {*;}
-keep interface com.iflytek.** {*;}

-keep class com.tencent.** {*;}
-keep interface com.tencent.** {*;}

-keep class android.content.pm.** {*;}
-keep interface android.content.pm.** {*;}

-keep class com.rttstudio.rttapi.** {*;}
-keep interface com.rttstudio.rttapi.** {*;}

-keep class com.autonavi.cvs.lib.tts.** {*;}
-keep interface com.autonavi.cvs.lib.tts.** {*;}

-keep class com.nostra13.universalimageloader.** {*;}
-keep interface com.nostra13.universalimageloader.** {*;}

-keep class com.umeng.** {*;}
-keep interface com.umeng.** {*;}

-keep class android.net.http.** {*;}
-keep interface android.net.http.** {*;}


-keep class com.weibo.sdk.android.** {*;}
-keep interface com.weibo.sdk.android.** {*;}





-keep class vi.com.gdi.bgl.android.** {*;}
-keep interface vi.com.gdi.bgl.android.** {*;}

-keepclasseswithmembernames class * {
native <methods>;
}
-keepclasseswithmembers class * {
public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class * extends android.app.Activity {
public void *(android.view.View);
}

-keep class android.support.v4.** { *; }
-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment

-keepclassmembers enum * {
public static **[] values();
public static ** valueOf(java.lang.String);
}
-keep class * implements android.os.Parcelable {
public static final android.os.Parcelable$Creator *;
}





-keep public class com.j256.** {*;}
-keep public interface com.j256.** {*;}


-dontwarn android.net.http.**
-dontwarn com.sina.**
-dontwarn com.tencent.**
-dontwarn com.umeng.**
-dontwarn org.mortbay.**
-dontwarn org.slf4j.**
-dontwarn org.apache.log4j.**
-dontwarn org.apache.commons.logging.**
-dontwarn org.apache.commons.codec.binary.**
-dontwarn com.baidu.**
-dontskipnonpubliclibraryclassmembers
