package com.ravi.article.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.ravi.article.R;
import com.ravi.article.util.FontUtil;

public class RobotoTextView extends AppCompatTextView {

    public RobotoTextView(Context context, String font) {
        super(context);
        setCustomFont(context, font);
    }

    public RobotoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        FontUtil.setCustomFont(this, context, attrs,
                R.styleable.RobotoText,
                R.styleable.RobotoText_font_name);
    }

    public RobotoTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        FontUtil.setCustomFont(this, context, attrs,
                R.styleable.RobotoText,
                R.styleable.RobotoText_font_name);
    }

    private void setCustomFont(Context context, String font) {
        FontUtil.setCustomFont(this, context, font);
    }
}