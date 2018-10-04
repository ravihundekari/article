package com.ravi.article.di.component;

import android.app.Application;
import android.content.Context;


import com.ravi.article.ArticleApplication;
import com.ravi.article.data.DataManager;
import com.ravi.article.di.module.ApplicationModule;
import com.ravi.article.di.scope.ApplicationContext;
import com.ravi.article.util.RxHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(ArticleApplication mapApplication);

    @ApplicationContext
    Context context();

    Application application();

    DataManager dataManager();

    RxHelper rxHelperBus();
}
