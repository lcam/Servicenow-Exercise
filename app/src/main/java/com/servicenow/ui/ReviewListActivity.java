package com.servicenow.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.servicenow.model.Review;
import com.servicenow.model.CoffeeShopReviews;
import com.servicenow.exercise.R;

import java.util.Arrays;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class ReviewListActivity extends DaggerAppCompatActivity {

    public static final Review[] coffeeShopReviews = CoffeeShopReviews.INSTANCE.getList();
    private RecyclerView recyclerView;

    @Inject
    ReviewAdapter reviewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        initRecyclerView();
    }

    private void initRecyclerView(){
        //reviewAdapter = new ReviewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(reviewAdapter);
        reviewAdapter.setReviews(Arrays.asList(coffeeShopReviews));
    }
}
