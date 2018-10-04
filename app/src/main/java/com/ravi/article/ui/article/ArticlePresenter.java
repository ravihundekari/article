package com.ravi.article.ui.article;

import com.ravi.article.data.model.Article;
import com.ravi.article.ui.base.BasePresenter;
import com.ravi.article.util.RxHelper;

import javax.inject.Inject;

class ArticlePresenter extends BasePresenter<ArticleMvpView> {
    private RxHelper rxHelper;

    @Inject
    ArticlePresenter(RxHelper rxHelper) {
        this.rxHelper = rxHelper;
    }

    void callListOfArticlesApi() {
        getMvpView().showLoading();
        rxHelper.getListOfArticles(this::onArticleSuccess, this::onError);
    }

    private void onArticleSuccess(Article article) {
        if (isViewAttached()) {
            getMvpView().stopLoadingDialog();
            if (article != null) {
                getMvpView().setArticleListToAdapter(article.getData());
            }
        }
    }

    private void onError(Throwable throwable) {
        if (isViewAttached()) {
            getMvpView().stopLoadingDialog();
            getMvpView().showErrorDialog(throwable.getMessage());
        }
    }

    void clearCompositeDisposable() {
        rxHelper.dispose();
    }
}
