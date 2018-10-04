package com.ravi.article.util;

import com.ravi.article.data.DataManager;
import com.ravi.article.data.model.Article;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RxHelper {
    private DataManager dataManager;
    private CompositeDisposable compositeDisposable;

    @Inject
    public RxHelper(DataManager dataManager) {
        this.dataManager = dataManager;
        this.compositeDisposable = new CompositeDisposable();
    }


    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
    }

    public void getListOfArticles(RxApiCallback<Article> onArticleSuccess, RxApiCallback<Throwable> onError) {
        compositeDisposable.add(dataManager.getListOfArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onArticleSuccess::onProcess, onError::onProcess));
    }

    public interface RxApiCallback<R> {
        void onProcess(R result);
    }
}
