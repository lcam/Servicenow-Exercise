package com.servicenow.ui.Details;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.servicenow.exercise.R;
import com.servicenow.model.Review;
import com.servicenow.ui.Main.Resource;
import com.servicenow.viewmodelfactory.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;

public class DetailsActivity extends DaggerAppCompatActivity {
    private static final String TAG = "DetailsActivity";

    private DetailsViewModel viewModel;
    TextView ratingText;
    TextView locationText;
    TextView reviewText;
    int shopPosition;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(DetailsViewModel.class);
        ratingText = findViewById(R.id.rating_details);
        locationText = findViewById(R.id.location_details);
        reviewText = findViewById(R.id.review_details);
        shopPosition = getIntent().getIntExtra("shopPosition", 0);

        subscribeObservers();
    }

    private void setTextViews(Review review){
        ratingText.setText(String.format("Rating: %d", review.getRating()));
        locationText.setText(review.getLocation());
        reviewText.setText(review.getReview());
    }

    private void subscribeObservers() {
        Log.d(TAG, "subscribeObservers: starting");
        disposables.add(viewModel.getReviews().subscribe(
                reviewResource -> observeReviews(reviewResource),
                throwable -> Log.e(TAG, "subscribeObservers: onError", throwable)
        ));
    }

    private void observeReviews(Resource<List<Review>> listResource) {
        Log.d(TAG, "observeReviews: starting");

        if(listResource != null) {
            switch (listResource.status) {
                case SUCCESS:{
                    Log.d(TAG, "observeReviews: got reviews!");
                    setTextViews(listResource.data.get(shopPosition));
                    break;
                }
                case ERROR:{
                    Log.e(TAG, "observeReviews: ERROR! " + listResource.message);
                    Toast.makeText(this, listResource.message, Toast.LENGTH_LONG).show();
                    break;
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }
}
