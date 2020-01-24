package com.servicenow.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.servicenow.model.Review;
import com.servicenow.model.CoffeeShopReviews;
import com.servicenow.exercise.R;
import com.servicenow.viewmodelfactory.ViewModelProviderFactory;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.disposables.CompositeDisposable;

public class ReviewListActivity extends DaggerAppCompatActivity {
    private static final String TAG = "ReviewListActivity";

    public static final Review[] coffeeShopReviews = CoffeeShopReviews.INSTANCE.getList();
    private ReviewViewModel viewModel;
    private RecyclerView recyclerView;

    @Inject
    ReviewAdapter reviewAdapter;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(ReviewViewModel.class);

        recyclerView = findViewById(R.id.recyclerView);
        initRecyclerView();
        subscribeObservers();
    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(reviewAdapter);
        //reviewAdapter.setReviews(Arrays.asList(coffeeShopReviews));
    }

    private void subscribeObservers() {
        Log.d(TAG, "subscribeObservers: starting");
        disposables.add(viewModel.getReviews().subscribe(
                reviewResource -> observePosts(reviewResource),
                throwable -> Log.e(TAG, "subscribeObservers: onError", throwable)
        ));
    }

    private void observePosts(Resource<List<Review>> listResource) {
        Log.d(TAG, "observePosts: starting");

        if(listResource != null) {
            switch (listResource.status) {
                case SUCCESS:{
                    Log.d(TAG, "observePosts: got employees!");
                    reviewAdapter.setReviews(listResource.data);
                    break;
                }
                case ERROR:{
                    Log.e(TAG, "observePosts: ERROR! " + listResource.message);
                    Toast.makeText(this, listResource.message, Toast.LENGTH_LONG).show();
                    break;
                }
            }
        }
    }
}
