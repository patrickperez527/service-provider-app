package com.np.onei.utils;

import android.content.Context;
import android.graphics.Typeface;

public class FontObjectSingleton {

    private static FontObjectSingleton instance;
    private static Typeface objtypeface;
    static  Context cnt;
    private FontObjectSingleton(Context c){
        cnt=c;
    }

   public static Typeface fontGet(Context cn)
   {
       objtypeface = Typeface.createFromAsset(cn.getAssets(), "fonts/avenir-light.ttf");
       return  objtypeface;
   }
}
