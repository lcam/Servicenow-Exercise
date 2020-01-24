package com.servicenow;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.servicenow.coffee.Review;
import com.servicenow.exercise.R;

public class ReviewViewHolder extends RecyclerView.ViewHolder {

    ImageView shopImage;
    TextView shopName;
    TextView shopReview;

    public ReviewViewHolder(@NonNull View itemView) {
        super(itemView);
        shopImage = itemView.findViewById(R.id.image);
        shopName = itemView.findViewById(R.id.text1);
        shopReview = itemView.findViewById(R.id.text2);
    }

    public void bind(Review review){
        shopImage.setImageResource(review.getIconResourceFromName(review.getName()));
        shopName.setText(review.getName());
        shopReview.setText(review.getReview());
    }
}
