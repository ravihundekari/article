package com.ravi.article.ui.article;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ravi.article.R;
import com.ravi.article.data.model.Datum;
import com.ravi.article.ui.base.BaseActivity;
import com.ravi.article.util.DialogUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleActivity extends BaseActivity implements ArticleMvpView {
    @Inject
    ArticlePresenter articlePresenter;
    @Inject
    ArticleAdapter articleAdapter;
    @BindView(R.id.rv_articles)
    RecyclerView rvArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        articlePresenter.attachView(this);
        articlePresenter.callListOfArticlesApi();
        rvArticles.setLayoutManager(new LinearLayoutManager(this));
        rvArticles.setAdapter(articleAdapter);
    }

    @Override
    public void showLoading() {
        DialogUtil.showLoadingDialog(this, getString(R.string.all_please_wait));
    }

    @Override
    public void stopLoadingDialog() {
        DialogUtil.stopLoadingDialog();
    }

    @Override
    public void showErrorDialog(String message) {
        DialogUtil.showErrorDialog(this, message);
    }

    @Override
    public void setArticleListToAdapter(List<Datum> data) {
        articleAdapter.setArticleList(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        articlePresenter.detachView();
        articlePresenter.clearCompositeDisposable();
    }
}
