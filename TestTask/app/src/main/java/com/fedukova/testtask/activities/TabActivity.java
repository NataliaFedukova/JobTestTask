package com.fedukova.testtask.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fedukova.testtask.R;
import com.fedukova.testtask.ui.AnimalFragment;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {

    public final static String CAT = "cat";
    public final static String DOG = "dog";

    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        mTabLayout = findViewById(R.id.tablayout);

        initTabs();
    }

    private void initTabs(){
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position){
                    case 0: getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AnimalFragment(CAT)).commit();
                    break;
                    case 1: getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AnimalFragment(DOG)).commit();
                    break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_1));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_2));
    }
}
