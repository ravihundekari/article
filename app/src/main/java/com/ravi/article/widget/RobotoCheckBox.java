package com.ravi.article.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

import com.ravi.article.R;
import com.ravi.article.util.FontUtil;

public class RobotoCheckBox extends AppCompatCheckBox {

    public RobotoCheckBox(Context context) {
        super(context);
    }

    public RobotoCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        FontUtil.setCustomFont(this, context, attrs,
                R.styleable.RobotoText,
                R.styleable.RobotoText_font_name);
    }

    public RobotoCheckBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        FontUtil.setCustomFont(this, context, attrs,
                R.styleable.RobotoText,
                R.styleable.RobotoText_font_name);
    }
}