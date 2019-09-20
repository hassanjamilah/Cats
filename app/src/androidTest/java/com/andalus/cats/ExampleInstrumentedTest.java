package com.andalus.cats;

import android.util.Log;
import android.widget.RatingBar;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.idling.CountingIdlingResource;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView ;
import static androidx.test.espresso.assertion.ViewAssertions.* ;

import com.andalus.cats.activities.DetailsActivity;
import com.andalus.cats.activities.MainActivity;
import com.andalus.cats.myclasses.Breed;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.Objects;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import static androidx.test.espresso.action.ViewActions.click ;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private CountingIdlingResource mIdlingResource ;

    @Rule
    public final ActivityTestRule<MainActivity> mMainActivityTest = new ActivityTestRule<>(MainActivity.class) ;

    @Rule
    public final ActivityTestRule<DetailsActivity> mmDetails = new ActivityTestRule<>(DetailsActivity.class) ;

    @Test
    public void useAppContext() {




        mIdlingResource = mMainActivityTest.getActivity().getCountingIdlingResource() ;

        Espresso.registerIdlingResources(mIdlingResource) ;

        onView(withRecyclerView(R.id.mainActivity_search_recyclerView)
                .atPositionOnView(0 , R.id.search_list_item_title_textview))
                .check(matches(withText("Abyssinian"))) ;

        onView(withId(R.id.mainActivity_search_recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(0 , click())) ;

        Breed breed = mmDetails.getActivity().getmBreed() ;

        assertRatingPos(0 , breed.getAdaptability()) ;
        assertRatingPos(1 , breed.getAffection_level()) ;
        assertRatingPos(2 , breed.getChild_friendly()) ;
        assertRatingPos( 3, breed.getDog_friendly()) ;
        assertRatingPos( 4, breed.getEnergy_level()) ;
        assertRatingPos( 5, breed.getGrooming()) ;
        assertRatingPos( 6, breed.getHealth_issues()) ;
        assertRatingPos( 7, breed.getIntelligence()) ;
        assertRatingPos( 8, breed.getShedding_level()) ;
        assertRatingPos( 9, breed.getSocial_needs()) ;
        assertRatingPos(10 , breed.getStranger_friendly()) ;


        ssertNotStatement();

    }

    private void ssertNotStatement() {
        Breed breed = new Breed() ;
        String x = breed.getBooleanSytax("hassan"  , 0) ;
        assertEquals(x,"Not hassan");
        x = breed.getBooleanSytax("hassan"  , 1) ;
        assertEquals(x,"hassan");
    }

    public void assertRatingPos(int pos  , int value){



        Log.i("hassan" , pos  + " , " + value ) ;
        RecyclerView rv = mmDetails.getActivity().getmBinding().DetailsActivityRatingRecyclerView ;
        int x = (int)((RatingBar)(Objects.requireNonNull(rv.findViewHolderForAdapterPosition(pos)).itemView.findViewById(R.id.rating_item_rating_bar))).getRating() ;
        assertEquals(value , x);
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

}
