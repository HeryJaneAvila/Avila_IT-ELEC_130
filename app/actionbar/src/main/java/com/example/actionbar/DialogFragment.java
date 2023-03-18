package com.example.actionbar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DialogFragment extends androidx.fragment.app.DialogFragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }
}