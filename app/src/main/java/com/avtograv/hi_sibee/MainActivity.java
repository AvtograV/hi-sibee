package com.avtograv.hi_sibee;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 pager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        FragmentStateAdapter pageAdapter = new MyAdapter(this);
        pager.setAdapter(pageAdapter);

        TabLayoutMediator tabLayoutMediator =
                new TabLayoutMediator(tabLayout, pager, (tab, position) -> {
                    if (position == 0)
                        tab.setText("главная");
                    else if (position == 1)
                        tab.setText("цоколь\nэтаж");
                    else if (position == 2)
                        tab.setText("первый\nэтаж");
                    else if (position == 3)
                        tab.setText("второй\nэтаж");
                });
        tabLayoutMediator.attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
            case R.id.open_settings:
            case R.id.save_settings:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {

        switch (item.getItemId()) {
            case R.id.page_1:
            case R.id.page_2:
            case R.id.page_3:

                return true;
        }
        return false;
    };
}