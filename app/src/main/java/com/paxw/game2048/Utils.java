package com.paxw.game2048;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by lichuang on 2016/2/2.
 */
public class Utils {
    public static final String SPNAME = "SPNAME";
    public static final String SCORE = "SCORE";
    public static final String BSCORE = "BSCORE";


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    /**
     * 获得屏幕高度
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static void setScore(Context context,int score){
        SharedPreferences sharedPreferences= context.getSharedPreferences(SPNAME, context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(BSCORE,score);
        edit.commit();
    }
    public static void clearBestScore(Context context){
        SharedPreferences sharedPreferences= context.getSharedPreferences(SPNAME, context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
    }

    public static int getBestScore(Context context){
        SharedPreferences sharedPreferences= context.getSharedPreferences(SPNAME, context.MODE_PRIVATE);
       return sharedPreferences.getInt(BSCORE,0);
    }
}
