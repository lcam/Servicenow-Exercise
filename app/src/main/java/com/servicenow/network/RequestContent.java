package com.servicenow.network;

import android.util.Log;

import com.servicenow.model.Review;
import com.servicenow.ui.Main.Resource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RequestContent {
    private static final String TAG = "RequestContent";

    private MainNetworkClient mainNetworkClient;

    @Inject
    public RequestContent(MainNetworkClient mainNetworkClient) {
        this.mainNetworkClient = mainNetworkClient;
    }

    public Observable<Resource<List<Review>>> queryReviews() {
        Single<List<Review>> source = mainNetworkClient.requestReviews();

        return source.toObservable()
                .onErrorReturn(throwable -> defaultReviewList(throwable))
                .map(reviews -> mapToResource(reviews))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private List<Review> defaultReviewList(Throwable throwable) {
        Log.e(TAG, "defaultReviewList: Error " + throwable.getLocalizedMessage());
        return new ArrayList<>();
    }

    private Resource<List<Review>> mapToResource(List<Review> reviews) {
        if(reviews.size() == 0)
            return Resource.error("Could not retrieve reviews", (List<Review>)null);

        Log.d(TAG, "mapToResource: Success");
        return Resource.success(reviews);
    }
}
