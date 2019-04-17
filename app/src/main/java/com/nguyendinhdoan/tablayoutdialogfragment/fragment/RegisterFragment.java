package com.nguyendinhdoan.tablayoutdialogfragment.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nguyendinhdoan.tablayoutdialogfragment.R;

public class RegisterFragment extends Fragment {

    public static final String REGISTER_POSITION_TAG = "REGISTER_POSITION_KEY";

    public static RegisterFragment newIntance(int fragmentPosition) {
        RegisterFragment registerFragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putInt(REGISTER_POSITION_TAG, fragmentPosition);
        registerFragment.setArguments(args);
        return registerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}
