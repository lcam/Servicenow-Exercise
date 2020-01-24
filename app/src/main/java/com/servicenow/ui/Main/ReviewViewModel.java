package com.servicenow.ui.Main;

import androidx.lifecycle.ViewModel;

import com.servicenow.model.Review;
import com.servicenow.network.RequestContent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


public class ReviewViewModel extends ViewModel {

    private RequestContent requestContent;
    private Observable<Resource<List<Review>>> reviews;

    @Inject
    public ReviewViewModel(RequestContent requestContent) {
        this.requestContent = requestContent;
    }

    public Observable<Resource<List<Review>>> getReviews() {
        if(reviews == null)
            reviews = requestContent.queryReviews();

        return reviews;
    }
}
