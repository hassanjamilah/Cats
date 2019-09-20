package com.andalus.cats.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andalus.cats.myclasses.Breed;
import com.andalus.cats.R;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyListViewHolder> {
    //This is the list of data of the recycler view
    private List<Breed> myData = new ArrayList<>();

    /* This is an instance of item click hanler it will be used by the list
        item to handle clicks on it.
    */
    private final MyListClickHandler  mListHandler;

    /**
     * This interface is for handling the recycler view clicks
     */
    public interface MyListClickHandler {
        void onClick(Breed m);
    }


    /**
     * This is the constructer of the adapter
     *
     * @param handler the handler of item click
     */
    public MyListAdapter(MyListClickHandler handler) {

        this.mListHandler = handler;
    }



    @NonNull
    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.search_list_item;
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
        final Breed m = myData.get(position);
        item.description_TextView.setText(m.getDescription());
        item.origin_TextView.setText(m.getOrigin());
        item.title_TextView.setText(m.getName());
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    /**
     * This class is defining our recycler view list items layout and behaviour
     */
    class MyListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView title_TextView;
        final TextView description_TextView;
        final TextView origin_TextView;

        private MyListViewHolder(View itemView) {
            super(itemView);
            title_TextView = itemView.findViewById(R.id.search_list_item_title_textview);
            description_TextView = itemView.findViewById(R.id.search_list_item_description_textview);
            origin_TextView = itemView.findViewById(R.id.search_list_item_origin_textview);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            Breed x = myData.get(pos);
            mListHandler.onClick(x);
        }
    }

    // used to set the data to the adapter for example when changing the method of
    // obtaining the movies from popular to top rated
    public void setData(List<Breed> data) {
        this.myData = data;
        notifyDataSetChanged();
    }
}
