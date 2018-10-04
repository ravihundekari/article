package com.ravi.article.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.ravi.article.R;
import com.ravi.article.util.FontUtil;


public class RobotoButton extends AppCompatButton {

    public RobotoButton(Context context) {
        super(context);
    }

    public RobotoButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        FontUtil.setCustomFont(this, context, attrs,
                R.styleable.RobotoText,
                R.styleable.RobotoText_font_name);
    }

    public RobotoButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        FontUtil.setCustomFont(this, context, attrs,
                R.styleable.RobotoText,
                R.styleable.RobotoText_font_name);
    }
}