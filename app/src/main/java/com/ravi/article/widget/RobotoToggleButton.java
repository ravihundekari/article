package com.ravi.article.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

import com.ravi.article.R;
import com.ravi.article.util.FontUtil;


public class RobotoToggleButton extends ToggleButton {

    public RobotoToggleButton(Context context) {
        super(context);
    }

    public RobotoToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        FontUtil.setCustomFont(this, context, attrs,
                R.styleable.RobotoText,
                R.styleable.RobotoText_font_name);
    }

    public RobotoToggleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        FontUtil.setCustomFont(this, context, attrs,
                R.styleable.RobotoText,
                R.styleable.RobotoText_font_name);
    }
}