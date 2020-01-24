package com.servicenow.ui.Details;

import androidx.lifecycle.ViewModel;

import com.servicenow.model.Review;
import com.servicenow.network.RequestContent;
import com.servicenow.ui.Main.Resource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DetailsViewModel extends ViewModel {

    private RequestContent requestContent;
    private Observable<Resource<List<Review>>> reviews;

    @Inject
    public DetailsViewModel(RequestContent requestContent) {
        this.requestContent = requestContent;
    }

    public Observable<Resource<List<Review>>> getReviews() {
        if(reviews == null)
            reviews = requestContent.queryReviews();

        return reviews;
    }
}
