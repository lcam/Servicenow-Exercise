package com.servicenow.exercise_java;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.servicenow.ReviewAdapter;
import com.servicenow.coffee.Review;
import com.servicenow.coffee.CoffeeShopReviews;
import com.servicenow.exercise.R;

import java.util.Arrays;

public class ReviewListActivity extends AppCompatActivity {

    public static final Review[] coffeeShopReviews = CoffeeShopReviews.INSTANCE.getList();
    private RecyclerView recyclerView;
    private ReviewAdapter reviewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        initRecyclerView();
    }

    private void initRecyclerView(){
        reviewAdapter = new ReviewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(reviewAdapter);
        reviewAdapter.setReviews(Arrays.asList(coffeeShopReviews));
    }
}
