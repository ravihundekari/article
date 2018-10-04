package com.ravi.article;

import android.app.Application;
import android.content.Context;

import com.ravi.article.di.component.ApplicationComponent;
import com.ravi.article.di.component.DaggerApplicationComponent;
import com.ravi.article.di.module.ApplicationModule;

public class ArticleApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    public static ArticleApplication get(Context context) {
        return (ArticleApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
            mApplicationComponent.inject(this);
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
