package com.example.meternalcare;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] monthTitles = {R.string.month1, R.string.month2, R.string.month3,
            R.string.month4, R.string.month5, R.string.month6,
            R.string.month7, R.string.month8, R.string.month9,R.string.month10}; // Add more month strings as needed

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        for (int monthTitle : monthTitles) {
            tabLayout.addTab(tabLayout.newTab().setText(getString(monthTitle)));
        }

        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // Return the appropriate fragment for each month
            switch (position) {
                case 0:
                    return new Month1Fragment();
                case 1:
                    return new Month2Fragment();
                case 2:
                    return new Month3Fragment();
                case 3:
                    return new Month4Fragment();
                case 4:
                    return new Month5Fragment();
                case 5:
                    return new Month6Fragment();
                case 6:
                    return new Month7Fragment();
                case 7:
                    return new Month8Fragment();
                case 8:
                    return new Month9Fragment();
                case 9:
                    return new Month10Fragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return monthTitles.length;
        }
    }
}
