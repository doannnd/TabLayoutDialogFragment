package com.nguyendinhdoan.tablayoutdialogfragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.nguyendinhdoan.tablayoutdialogfragment.R;

public class EditNameDialogFragment extends DialogFragment implements TextView.OnEditorActionListener {

    public static final String TITLE_KEY = "TITLE_KEY";

    private EditText yourNameEditText;

    private EditNameDialogListener listener;

    public static EditNameDialogFragment newInstance(String dialogTitle) {
        EditNameDialogFragment editNameDialogFragment = new EditNameDialogFragment();
        Bundle args = new Bundle();
        args.putString(TITLE_KEY, dialogTitle);
        editNameDialogFragment.setArguments(args);
        return editNameDialogFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (EditNameDialogListener) getTargetFragment();
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement EditNameDialogListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_dialog_edit_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        yourNameEditText = view.findViewById(R.id.your_name_edit_text);

        setupUI();
        addEvents();
    }

    private void setupUI() {
        // get title and set for edit name dialog
        if (getArguments() != null) {
            String dialogTitle = getArguments().getString(TITLE_KEY);
            getDialog().setTitle(dialogTitle);
            setCancelable(false);

            // re....
            yourNameEditText.requestFocus();
            if (getDialog().getWindow() != null) {
                getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            }
        }
    }

    private void addEvents() {
        yourNameEditText.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            String yourName = yourNameEditText.getText().toString();
            listener.onEditNameListener(yourName);
            // close the dialog and back to the parent fragment
            dismiss();
            return true;
        }
        return false;
    }

    public interface EditNameDialogListener {
        void onEditNameListener(String yourName);
    }
}
