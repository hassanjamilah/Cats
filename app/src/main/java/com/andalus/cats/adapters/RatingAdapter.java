package com.andalus.cats.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andalus.cats.myclasses.Breed;
import com.andalus.cats.R;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.MyListViewHolder> {
    //This is the list of data of the recycler view
    private Breed myData;

    private final String[] mTitles;

    /**
     * This is the constructer of the adapter
     */
    public RatingAdapter(Breed breed, String[] titles) {
        myData = breed;
        mTitles = titles;
    }


    @NonNull
    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.rating_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new MyListViewHolder(view);
    }


    /**
     * This method is used to fill the data in the views of each
     * item of the recycler view
     */
    @Override
    public void onBindViewHolder(@NonNull MyListViewHolder item, final int position) {
        int ratingValue = 0;
        switch (position) {
            case 0:
                ratingValue = myData.getAdaptability();
                break;
            case 1:
                ratingValue = myData.getAffection_level();
                break;
            case 2:
                ratingValue = myData.getChild_friendly();
                break;
            case 3:
                ratingValue = myData.getDog_friendly();
                break;
            case 4:
                ratingValue = myData.getEnergy_level();
                break;
            case 5:
                ratingValue = myData.getGrooming();
                break;
            case 6:
                ratingValue = myData.getHealth_issues();
                break;
            case 7:
                ratingValue = myData.getIntelligence();
                break;
            case 8:
                ratingValue = myData.getShedding_level();
                break;
            case 9:
                ratingValue = myData.getSocial_needs();
                break;
            case 10:
                ratingValue = myData.getStranger_friendly();
                break;
        }

        item.title_TextView.setText(mTitles[position]);
        item.mRatingBar.setRating(ratingValue);


    }


    @Override
    public int getItemCount() {
        return mTitles.length;
    }


    /**
     * This class is defining our recycler view list items layout and behaviour
     */
    class MyListViewHolder extends RecyclerView.ViewHolder {
        final TextView title_TextView;
        final RatingBar mRatingBar;

        private MyListViewHolder(View itemView) {
            super(itemView);
            title_TextView = itemView.findViewById(R.id.rating_listItem_Title);
            mRatingBar = itemView.findViewById(R.id.rating_item_rating_bar);
        }
    }


}
