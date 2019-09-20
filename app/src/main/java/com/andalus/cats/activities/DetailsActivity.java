package com.andalus.cats.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.util.Log;
import com.andalus.cats.api.BreedAPI;
import com.andalus.cats.api.Controller;
import com.andalus.cats.adapters.RatingAdapter;
import com.andalus.cats.myclasses.Breed;
import com.andalus.cats.myclasses.BreedImage;
import com.andalus.cats.R;
import com.andalus.cats.databinding.ActivityDetailsBinding;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This is the activity that displays the information of the breed
 */
public class DetailsActivity extends AppCompatActivity {

    // This var stores the breed data
    private Breed mBreed;
    //This field is used to get the activity layout components
    private ActivityDetailsBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        //Here we set the background color of the webview
        mBinding.DetailsActivityWebView.setBackgroundColor(getResources().getColor(R.color.pink_300));


        //Here I'm getting the data of the breed from the original activity
        Bundle bundle;
        if (getIntent().getExtras() != null) {
            bundle = getIntent().getExtras();
            mBreed = bundle.getParcelable(MainActivity.BUNDLE_DETAILS);

            //Here we format the data as html and display it in the WebView
            mBinding.DetailsActivityWebView.loadData(mBreed.getHTML(), "text/html", "UTF-8");

            /* Here we prepare the rating information of the breed
            *by using special recyclerview to display these ratings
            */
            LinearLayoutManager manager = new LinearLayoutManager(this);
            String[] titles = getResources().getStringArray(R.array.ratingbars_titles);
            RatingAdapter adapter = new RatingAdapter(mBreed, titles);
            mBinding.DetailsActivityRatingRecyclerView.setLayoutManager(manager);
            mBinding.DetailsActivityRatingRecyclerView.setAdapter(adapter);

            //Here we load the image of the breed
            loadImages(mBreed);

        }
    }

    /**
     * Getter method for the breed
     * @return
     */
    public Breed getmBreed() {
        return mBreed;
    }

    /**
     * Getter method for the activity binding
     * it's used in our Unit Tests to get the views from the activity
     * @return
     */
    public ActivityDetailsBinding getmBinding() {
        return mBinding;
    }


    /**
     * We use this method to load the image of the breed
     * using the Picasso Library
     * and also get the image url using Retrofit
     * @param breed
     */
    private void loadImages(final Breed breed) {
        Retrofit ret = new Retrofit.Builder()
                .baseUrl(BreedAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();

        BreedAPI api = ret.create(BreedAPI.class);
        final Call<List<BreedImage>> images = api.listImages(Controller.API_KEY, breed.getId());

        images.enqueue(new Callback<List<BreedImage>>() {
            @Override
            public void onResponse(Call<List<BreedImage>> call, Response<List<BreedImage>> response) {
                if (response.isSuccessful()) {
                    Log.i("hassan", "Retrofit success");
                    List<BreedImage> images1 = response.body();

                    if (images1.size() > 0) {
                        breed.setImageURL(images1.get(0).getUrl());
                        Log.i("hassan", "The image from cocntroller is : " + breed.getImageURL());
                        Picasso.get().load(images1.get(0).getUrl()).into(mBinding.detailsImageView);
                    }
                } else {
                    Log.i("hassan", "Retrofit result failed");
                }
            }

            @Override
            public void onFailure(Call<List<BreedImage>> call, Throwable t) {
                Log.i("hassan", "Retrofit failure");
                Log.i("hassan", "Retrofit failure " + t.getMessage());

            }
        });


    }

}
