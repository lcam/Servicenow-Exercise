package com.servicenow.network;

import com.servicenow.model.Review;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface MainApi {

    //https://jsonblob.com/api/jsonBlob/c1a89a37-371e-11ea-a549-6f3544633231
    @GET("c1a89a37-371e-11ea-a549-6f3544633231")
    Single<List<Review>> getReviews();
}
