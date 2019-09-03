package com.fedukova.testtask.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fedukova.testtask.R;
import com.fedukova.testtask.ui.CatsFragment;
import com.fedukova.testtask.ui.DogsFragment;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {


    private TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        mTabLayout = findViewById(R.id.tablayout);

        initTabs();
    }

    private void initTabs(){
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_1));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.tab_2));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1: getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CatsFragment()).commit();
                    break;
                    case 2: getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DogsFragment()).commit();
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

    }
}
