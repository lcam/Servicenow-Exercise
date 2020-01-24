package com.servicenow.ui.Main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.servicenow.model.Review;
import com.servicenow.exercise.R;

public class ReviewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private ImageView shopImage;
    private TextView shopName;
    private TextView shopReview;

    private MyViewHolderClicks listener;

    public ReviewViewHolder(@NonNull View itemView) {
        super(itemView);
        shopImage = itemView.findViewById(R.id.image);
        shopName = itemView.findViewById(R.id.text1);
        shopReview = itemView.findViewById(R.id.text2);
    }

    public void bind(int position, Review review, final ReviewAdapter.OnItemClickListener listener){
        shopImage.setImageResource(review.getIconResourceFromName(review.getName()));
        shopName.setText(review.getName());
        shopReview.setText(review.getReview());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position, review);
            }
        });
    }

    @Override
    public void onClick(View view) {
        listener.onItemClick(this.getLayoutPosition(), view);
    }

    public interface MyViewHolderClicks {
        void onItemClick(int position, View item);
    }
}
