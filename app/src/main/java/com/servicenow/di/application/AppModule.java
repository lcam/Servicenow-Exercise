package com.servicenow.di.application;

import com.servicenow.network.MainApi;
import com.servicenow.network.MainNetworkClient;
import com.servicenow.network.RequestContent;
import com.servicenow.util.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static MainApi provideMainApi(Retrofit retrofit) {
        return retrofit.create(MainApi.class);
    }

    @Singleton
    @Provides
    static MainNetworkClient provideMainNetworkClient(MainApi mainApi) {
        return new MainNetworkClient(mainApi);
    }

    @Singleton
    @Provides
    static RequestContent provideRequestContent(MainNetworkClient client) {
        return new RequestContent(client);
    }
}
