package com.ravi.article.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ravi.article.ArticleApplication;
import com.ravi.article.di.component.ActivityComponent;
import com.ravi.article.di.component.DaggerActivityComponent;
import com.ravi.article.di.module.ActivityModule;


public class BaseActivity extends AppCompatActivity {
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(ArticleApplication.get(this).getApplicationComponent())
                    .build();
        }
        return activityComponent;
    }
}
