package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragments.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding b;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        b = FragmentSecondBinding.inflate(inflater,container,false);
        SecondFragmentArgs take = SecondFragmentArgs.fromBundle(getArguments());

        b.txt2.setText(take.getObject().getName()+" "+take.getObject().getAge()+" "+take.getName()+" "+take.getAge());

        b.btn2.setOnClickListener(view->{
            Navigation.findNavController(view).navigate(R.id.second);
        });


        return b.getRoot();
    }
}