package com.nguyendinhdoan.tablayoutdialogfragment.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.nguyendinhdoan.tablayoutdialogfragment.R;


public class LoginFragment extends Fragment implements View.OnClickListener, EditNameDialogFragment.EditNameDialogListener {

    public static final String LOGIN_POSITION_KEY = "LOGIN_POSITION_KEY";
    public static final String EDIT_NAME_DIALOG_TAG = "EDIT_NAME_DIALOG_TAG";
    public static final int LOGIN_FRAGMENT_REQUEST_CODE = 1;

    private Button showDialogButton;

    public static LoginFragment newInstance(int fragmentPosition) {
        LoginFragment loginFragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putInt(LOGIN_POSITION_KEY, fragmentPosition);
        loginFragment.setArguments(args);
        return loginFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // reference view from fragment_login
        initViews(view);
        addEvents();
    }

    private void initViews(View view) {
        showDialogButton = view.findViewById(R.id.show_dialog_button);
    }

    private void addEvents() {
        showDialogButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.show_dialog_button) {
            showAlertDialog();
        }
    }

    private void showAlertDialog() {
        String dialogTitle = getString(R.string.dialog_title);
        EditNameDialogFragment editNameDialogFragment = EditNameDialogFragment.newInstance(dialogTitle);
        editNameDialogFragment.setTargetFragment(LoginFragment.this, LOGIN_FRAGMENT_REQUEST_CODE);
        if (getFragmentManager() != null) {
            editNameDialogFragment.show(getFragmentManager(), EDIT_NAME_DIALOG_TAG);
        }
    }

    @Override
    public void onEditNameListener(String yourName) {
        Toast.makeText(getActivity(), "name: " + yourName, Toast.LENGTH_SHORT).show();
    }
}
