package com.ravi.article.ui.article;

import com.ravi.article.data.model.Datum;
import com.ravi.article.ui.base.MvpView;

import java.util.List;

interface ArticleMvpView extends MvpView {

    void showLoading();

    void stopLoadingDialog();

    void showErrorDialog(String message);

    void setArticleListToAdapter(List<Datum> data);
}
