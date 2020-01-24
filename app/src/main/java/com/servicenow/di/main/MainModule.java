package com.servicenow.di.main;

import com.servicenow.network.MainApi;
import com.servicenow.network.MainNetworkClient;
import com.servicenow.network.RequestContent;
import com.servicenow.ui.ReviewAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @Provides
    static ReviewAdapter provideReviewAdapter() {
        return new ReviewAdapter();
    }

    @Provides
    static MainApi provideMainApi(Retrofit retrofit) {
        return retrofit.create(MainApi.class);
    }

    @Provides
    static MainNetworkClient provideMainNetworkClient(MainApi mainApi) {
        return new MainNetworkClient(mainApi);
    }

    @Provides
    static RequestContent provideRequestContent(MainNetworkClient client) {
        return new RequestContent(client);
    }
}
