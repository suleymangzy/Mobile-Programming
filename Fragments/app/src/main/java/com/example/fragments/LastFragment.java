package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragments.databinding.FragmentLastBinding;

public class LastFragment extends Fragment {

    private FragmentLastBinding b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        b = FragmentLastBinding.inflate(inflater,container,false);

        // Inflate the layout for this fragment
        return b.getRoot();
    }
}