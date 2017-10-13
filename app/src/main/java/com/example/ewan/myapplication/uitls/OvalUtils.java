package com.example.ewan.myapplication.uitls;

import android.content.Context;
import android.util.DisplayMetrics;

import java.util.Random;

/**
 * Created by Administrator on 2017/10/9.
 */

public class OvalUtils {
    private static Random mRandom;

    static {
        mRandom = new Random();
    }

    public OvalUtils() {

    }

    public static int[] getScreenSize(Context context) {
        int[] size = new int[2];
        DisplayMetrics mDisplayMetrics = context.getResources().getDisplayMetrics();
        size[0] = mDisplayMetrics.widthPixels;
        size[1] = mDisplayMetrics.heightPixels;
        return size;
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height","dimen","android");
        if (resourceId>0){
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    public static String getRandomColorStr(){
        String r = Integer.toHexString(mRandom.nextInt(256)).toUpperCase();
        String g = Integer.toHexString(mRandom.nextInt(256)).toUpperCase();
        String b= Integer.toHexString(mRandom.nextInt(256)).toUpperCase();
        r = r.length() == 1 ? "0" + r : r;
        g = g.length() == 1 ? "0" + g : g;
        b = r.length() == 1 ? "0" + b : b;
        return "#" + r + g + b;
    }
    public static int getRandomColorInt(){
        return mRandom.nextInt(0xffffff);
    }
}
