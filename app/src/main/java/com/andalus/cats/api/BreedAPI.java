package com.andalus.cats.api;

import com.andalus.cats.myclasses.Breed;
import com.andalus.cats.myclasses.BreedImage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This is the interface of the Retrofit
 * We use it to load the Breeds and search in them
 */
public interface BreedAPI {

       String BASE_URL="https://api.thecatapi.com/v1/" ;


    /**
     * Load all The Breeds
     * @param key
     * @param x
     * @return
     */
    @GET("breeds/")
    Call<List<Breed>> listBreeds(@Query("api_key") String key , @Query("attach_breed")int x ) ;


    /**
     * Here we get the image of the breed
     * @param key
     * @param breedID
     * @return
     */
    @GET("images/search/")
    Call<List<BreedImage>> listImages(@Query("api_key") String key , @Query("breed_id") String breedID);


}
