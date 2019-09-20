package com.andalus.cats.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.test.espresso.idling.CountingIdlingResource;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import com.andalus.cats.api.Controller;
import com.andalus.cats.adapters.MyListAdapter;
import com.andalus.cats.adapters.MyListAdapter.MyListClickHandler;
import com.andalus.cats.database.MyDatabase;
import com.andalus.cats.myclasses.Breed;
import com.andalus.cats.R;
import com.andalus.cats.viewmodels.MainViewModel;
import com.andalus.cats.databinding.ActivityMainBinding;

import java.util.List;

/**
 * This is our Main Activity Class
 */
public class MainActivity extends AppCompatActivity {

    //This the adapter of the recyclerview
    private MyListAdapter mAdapter  ;

    /*
    This is count idling resource We use it to delay the Espresso Tests
    until the items loaded to the RecyclerView
     */
    private CountingIdlingResource mCountingIdlingResource ;


    //This is the View Model of this activity
    private MainViewModel model ;

    //This is the Data Binding which is used to get the views of the activity
    private ActivityMainBinding mBinding;

    //We use This constant as the key used in the bundle that will store the details
    public static final String BUNDLE_DETAILS = "details";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);

        //Init the count idling resource and increase it by one
        mCountingIdlingResource = new CountingIdlingResource("hassan001") ;
        mCountingIdlingResource.increment();


        //Get instance of the room database
        final MyDatabase database= MyDatabase.getDatabaseInstance(this) ;

        //Start the controller which use retrofit to get breeds data
        Controller cont = new Controller(database , this) ;
        cont.start(cont);


        //Init the views
        initViews();


        //Init the view model
       model=new ViewModelProvider(this , new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MainViewModel.class) ;

       //We put the data to the recycler view
        model.getmBreeds().observe(this, new Observer<List<Breed>>() {
            @Override
            public void onChanged(List<Breed> breeds) {
                mAdapter.setData(breeds);
                if (mCountingIdlingResource != null){

                    try{
                        mCountingIdlingResource.decrement() ;
                    }catch (IllegalStateException e){
                        Log.i("hassan" , "The counting idling state is incorrect" ) ;
                    }
                }
            }
        });



        /*
        Here we init the search of the Seach view
         */
        final LifecycleOwner owner =this ;
        mBinding.mainActivitySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
             model.getBreedsBySearch(s).observe(owner, new Observer<List<Breed>>() {
                    @Override
                    public void onChanged(List<Breed> breeds) {
                        mAdapter.setData(breeds);

                    }
                });
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        /*
        We load all the breeds when the user closes the SearchView
         */
        mBinding.mainActivitySearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Log.i("hassan" ,"Search view clossed") ;
                model.getAllBreeds().observe(owner, new Observer<List<Breed>>() {
                    @Override
                    public void onChanged(List<Breed> breeds) {
                        mAdapter.setData(breeds);
                    }
                });
                return false;
            }
        });

    }

    /**
     * We prepare our views here and attach the recycler view to the adapter
     */
    private void initViews() {
        final Intent intent = new Intent(this, DetailsActivity.class) ;
        LinearLayoutManager manager  = new LinearLayoutManager(this) ;
        mAdapter = new MyListAdapter(new MyListClickHandler() {
            @Override
            public void onClick(Breed m) {
                Bundle bundle = new Bundle( );
                bundle.putParcelable(BUNDLE_DETAILS , m);
                intent.putExtras(bundle) ;
                startActivity(intent);

            }
        }) ;

        mBinding.mainActivitySearchRecyclerView.setLayoutManager(manager);
        mBinding.mainActivitySearchRecyclerView.setAdapter(mAdapter);
    }



    public CountingIdlingResource getCountingIdlingResource() {
        return mCountingIdlingResource;
    }

}
