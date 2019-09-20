package com.andalus.cats.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.andalus.cats.myclasses.Breed;

import java.util.List;

/**
 * This class is used to handle the database
 * update, insert, delete, query our database
 */
@Dao
public interface MyDao {

    @Insert (onConflict =  OnConflictStrategy.IGNORE)
     void insertBreed(Breed breed) ;

    @Update(onConflict = OnConflictStrategy.REPLACE)
     void updateBreed(Breed breed) ;

    @SuppressWarnings("unused")
    @Delete()
     void deleteBreed(Breed breed);

    @Query("select * from Breed where name like :breed")
     LiveData<List<Breed>> searchBreed(String breed) ;

    @Query("select * from Breed ")
     LiveData<List<Breed>> getAllBreeds() ;

}
