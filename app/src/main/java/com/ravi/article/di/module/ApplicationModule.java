package com.ravi.article.di.module;

import android.app.Application;
import android.content.Context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ravi.article.data.DataManager;
import com.ravi.article.data.remote.ArticleApiService;
import com.ravi.article.data.remote.RetrofitFactory;
import com.ravi.article.di.scope.ApplicationContext;
import com.ravi.article.util.RxHelper;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(Cache cache) {
        return RetrofitFactory.getOkHttpClient(cache);
    }

    @Singleton
    @Provides
    ObjectMapper provideObjectMapper() {
        return RetrofitFactory.getObjectMapper();
    }

    @Singleton
    @Provides
    Cache provideCache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000);
    }

    @Singleton
    @Provides
    public File file(@ApplicationContext Context context) {
        File file = new File(context.getCacheDir(), "HttpCache");
        file.mkdirs();
        return file;
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient, ObjectMapper objectMapper) {
        return RetrofitFactory.getRetrofit(okHttpClient, objectMapper);
    }

    @Singleton
    @Provides
    ArticleApiService provideMapApiService(Retrofit retrofit) {
        return retrofit.create(ArticleApiService.class);
    }

    @Singleton
    @Provides
    RxHelper provideDataManager(DataManager dataManager) {
        return new RxHelper(dataManager);
    }

}
