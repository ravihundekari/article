package com.ravi.article.ui.base;

interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
