package com.ravi.article.di.component;


import com.ravi.article.ui.article.ArticleActivity;
import com.ravi.article.di.module.ActivityModule;
import com.ravi.article.di.scope.PerAcitivty;

import dagger.Component;

@PerAcitivty
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(ArticleActivity articleActivity);

}
