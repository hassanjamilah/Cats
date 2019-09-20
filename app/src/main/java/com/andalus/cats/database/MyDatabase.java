package com.andalus.cats.database;

import android.content.Context;
import android.util.Log;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.andalus.cats.myclasses.Breed;

/**
 * This is the room database class
 */
@Database(entities = {Breed.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    //This var used to synchorize the database creation
    private static final Object lock = new Object();

    private static final String DATABASE_NAME = "drugs.db";
    private static MyDatabase mInstance;

    /**
     * We try to get instance of the room datase if exist
     * if not exists we create a new database
     *
     */
    public static MyDatabase getDatabaseInstance(Context context) {
        Log.i("hassan", "Will get databaase instance");
        if (mInstance == null) {
            synchronized (lock) {

                mInstance = Room.databaseBuilder(context, MyDatabase.class, DATABASE_NAME).build();
                Log.i("hassan", "The database created successfully");
            }
        }
        return mInstance;
    }

    public abstract MyDao breedsDao();


}