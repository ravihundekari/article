package com.ravi.article.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.util.Hashtable;

/**
 * Created by ravih on 3/13/2018.
 */

public class FontUtil {
    private static final String TAG = FontUtil.class.getSimpleName();

    public static void setCustomFont(View view, Context ctx, AttributeSet attrs, int[] attributeSet, int fontId) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, attributeSet);
        String customFont = a.getString(fontId);
        setCustomFont(view, ctx, customFont);
        a.recycle();
    }

    public static void setCustomFont(View view, Context ctx, String asset) {
        if (TextUtils.isEmpty(asset)) return;
        Typeface tf;
        try {
            tf = getFont(ctx, asset);
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(tf);
            } else {
                ((Button) view).setTypeface(tf);
            }
        } catch (Exception e) {
            Log.d(TAG, "setCustomFont: " + asset);
        }
    }

    private static final Hashtable<String, SoftReference<Typeface>> fontCache = new Hashtable<String, SoftReference<Typeface>>();

    private static Typeface getFont(Context c, String name) {
        synchronized (fontCache) {
            if (fontCache.get(name) != null) {
                SoftReference<Typeface> ref = fontCache.get(name);
                if (ref.get() != null) return ref.get();
            }

            Typeface typeface = Typeface.createFromAsset(c.getAssets(), "fonts/" + name);
            fontCache.put(name, new SoftReference<>(typeface));

            return typeface;
        }
    }
}
