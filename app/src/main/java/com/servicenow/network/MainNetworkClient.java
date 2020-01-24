package com.servicenow.network;

import android.util.Log;

import com.servicenow.model.Review;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class MainNetworkClient {
    private static final String TAG = "MainNetworkClient";

    private final MainApi mainApi;

    @Inject
    public MainNetworkClient(MainApi mainApi) {
        this.mainApi = mainApi;
    }

    public Single<List<Review>> requestReviews() {
        Log.d(TAG, "requestReviews: about to make api request");
        return mainApi.getReviews();
    }
}
