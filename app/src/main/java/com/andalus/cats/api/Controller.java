package com.andalus.cats.api;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;

import com.andalus.cats.database.MyDatabase;
import com.andalus.cats.myclasses.AppExecutors;
import com.andalus.cats.myclasses.Breed;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class is used to control our Retrofit API
 */
public class Controller {

    //Get an instance of the database
    private final MyDatabase mDatabse ;

    //This is my API KEY
    public static final String API_KEY  = "";


    /**
     * The constructor of the class
     * @param mDatabse
     * @param owner
     */
    public Controller(MyDatabase mDatabse ,LifecycleOwner owner) {
        this.mDatabse = mDatabse;

    }

    /**
     * This method is used to load all the breeds
     * @param cont
     */
    public  void start(final Controller cont){
        Retrofit ret = new Retrofit.Builder()
                .baseUrl(BreedAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build() ;
        BreedAPI bb  = ret.create(BreedAPI.class) ;
        Call<List<Breed>> breeds = bb.listBreeds(API_KEY , 0) ;


       Callback<List<Breed>> mm =new Callback<List<Breed>>() {
           @Override
           public void onResponse(Call<List<Breed>> call, Response<List<Breed>> response) {
                if (response.isSuccessful()){
                    Log.i("hassan" , "Success result") ;
                    List<Breed> br = response.body() ;
                    if (br !=null){
                        Log.i("hassan" , "size of result" + br.size()) ;
                        for (Breed b:br){

                            String x = b.getWeight().toString() ;
                            x = x.replace("{" , "") ;
                            x = x.replace("}" , "") ;
                            String[] x1  = x.split(",") ;
                            b.setImperial(x1[0].replace("imperial=" , "") ) ;
                            b.setMetric( x1[1].replace("metric=" , "") );
                            Log.i("hassan" , b.toString()) ;
                        }

                        cont.insertBreedsToDatabase(br);
                    }else {
                        Log.i("hassan" , "size of result is nulll" ) ;

                    }
                }else {
                    Log.i("hassan" , "retrfofit failure result") ;
                }
           }

           @Override
           public void onFailure(Call<List<Breed>> call, Throwable t) {
               Log.i("hassan" , "retrfofit failure") ;
               if (t.getMessage() !=null){

               Log.i("hassan" , t.getMessage()) ;
               }
           }
       } ;

        breeds.enqueue( mm);

    }


    /**
     * We use this method to insert the breeds into the database
     * this method called in each start of the app to update our data
     * @param breeds
     */
    private void insertBreedsToDatabase(List<Breed> breeds){
        for (final Breed b:breeds){
            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    mDatabse.breedsDao().insertBreed(b);
                }
            });
        }
    }
}
