package com.andalus.cats.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.andalus.cats.database.MyDatabase;
import com.andalus.cats.myclasses.Breed;

import java.util.List;

/**
 * This is the viewmodel of the MainActivity
 */
public class MainViewModel extends AndroidViewModel {

    private final MyDatabase myDatabase  ;
    private LiveData<List<Breed>> mBreeds ;
    public MainViewModel(@NonNull Application application) {
        super(application);
        myDatabase = MyDatabase.getDatabaseInstance(this.getApplication()) ;
        mBreeds = myDatabase.breedsDao().getAllBreeds() ;
    }

    public LiveData<List<Breed>> getmBreeds() {
        return mBreeds;
    }

    /**
     * Get breeds by searching in the database
     * @param searchStr
     * @return
     */
    public LiveData<List<Breed>> getBreedsBySearch(String searchStr){
        mBreeds = myDatabase.breedsDao().searchBreed("%" + searchStr  + "%")  ;
        return  mBreeds ;
    }

    /**
     * Get all the breeds
     * @return
     */
    public LiveData<List<Breed>> getAllBreeds(){
        mBreeds = myDatabase.breedsDao().getAllBreeds() ;
        return  mBreeds ;
    }

}
