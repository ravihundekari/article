package com.ravi.article.data;

import android.content.Context;

import com.ravi.article.data.model.Article;
import com.ravi.article.data.remote.ArticleApiService;
import com.ravi.article.di.scope.ApplicationContext;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DataManager {
    private ArticleApiService articleApiService;

    @Inject
    DataManager(@ApplicationContext Context context, ArticleApiService articleApiService) {
        this.articleApiService = articleApiService;
    }

    public Observable<Article> getListOfArticles() {
        return articleApiService.getListOfArticlesApi();
    }
}
