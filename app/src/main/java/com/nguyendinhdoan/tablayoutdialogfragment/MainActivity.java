package com.nguyendinhdoan.tablayoutdialogfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar mainToolbar;
    private TabLayout mainTabLayout;
    private ViewPager mainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupUI();
    }

    private void initViews() {
        mainTabLayout = findViewById(R.id.main_tab_layout);
        mainToolbar = findViewById(R.id.main_toolbar);
        mainViewPager = findViewById(R.id.main_view_pager);
    }

    private void setupUI() {
        setupToolbar();
        setupTabLayout();
    }

    private void setupToolbar() {
        setSupportActionBar(mainToolbar);
    }

    private void setupTabLayout() {
        mainTabLayout.setupWithViewPager(mainViewPager);
        MainAdapter mainAdapter = new MainAdapter(this, getSupportFragmentManager());
        mainViewPager.setAdapter(mainAdapter);
    }
}
