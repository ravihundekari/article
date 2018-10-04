package com.ravi.article.data.remote;

import com.ravi.article.data.model.Article;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ArticleApiService {

    @GET("interview-question-data/articles/articles.json")
    Observable<Article> getListOfArticlesApi();
}
