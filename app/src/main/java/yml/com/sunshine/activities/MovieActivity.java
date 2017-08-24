package yml.com.sunshine.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yml.com.sunshine.R;
import yml.com.sunshine.fragments.NowPlayingFragment;
import yml.com.sunshine.fragments.MovieFragment;
import yml.com.sunshine.fragments.TopRatedMovieFragment;

/**
 * Created by sagar on 21/8/17.
 */

public class MovieActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar myToolBar;

    @BindView(R.id.viewpager)
    ViewPager myViewPager;

    @BindView(R.id.tabs)
    TabLayout myTabLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);

        //set the toolbar
        myToolBar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        myToolBar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolBar);

        //set the view pager
        setUpViewPagerForFragments(myViewPager);

        //set the tabLayout
        myTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        myTabLayout.setupWithViewPager(myViewPager);


    }

    private void setUpViewPagerForFragments(ViewPager myViewPager) {

        viewPagerAdapter pagerAdapter = new viewPagerAdapter(getSupportFragmentManager());

        pagerAdapter.addFragment(new MovieFragment(), "PopMovies");
        pagerAdapter.addFragment(new NowPlayingFragment(), "NowPlaying");
        pagerAdapter.addFragment(new TopRatedMovieFragment(), "TopMovies");

        /*Here we set the fragments list and titles to the adapter*/
        myViewPager.setAdapter(pagerAdapter);


    }

    //Use the adapter to attach the fragments and tab list

    class viewPagerAdapter extends FragmentPagerAdapter {

        //create two lists which can hold fragments  list and fragment titles
        List<Fragment> fragmentsList = new ArrayList<>();
        List<String> fragmentsTitleList = new ArrayList<>();


        public viewPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        /*Here we will get the position of the fragments attached*/
        @Override
        public Fragment getItem(int position) {
            return fragmentsList.get(position);
        }


        /*Here we will get the size of the fragment*/
        @Override
        public int getCount() {
            return fragmentsList.size();
        }

        void addFragment(Fragment fragment, String title) {


            fragmentsList.add(fragment);
            fragmentsTitleList.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentsTitleList.get(position);
        }
    }


}
