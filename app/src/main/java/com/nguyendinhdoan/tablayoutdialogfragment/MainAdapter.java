package com.nguyendinhdoan.tablayoutdialogfragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nguyendinhdoan.tablayoutdialogfragment.fragment.LoginFragment;
import com.nguyendinhdoan.tablayoutdialogfragment.fragment.RegisterFragment;

public class MainAdapter extends FragmentPagerAdapter {

    public static final int FRAGMENT_PAGER_TOTAL = 2;
    private Context context;

    public MainAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return LoginFragment.newInstance(position);
            case 1:
                return RegisterFragment.newIntance(position);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return FRAGMENT_PAGER_TOTAL;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.tab_login);
            case 1:
                return context.getString(R.string.tab_register);
            default:
                return null;
        }
    }
}
