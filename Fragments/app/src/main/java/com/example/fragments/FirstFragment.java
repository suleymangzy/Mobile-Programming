package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragments.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        b = FragmentFirstBinding.inflate(inflater,container,false);

        Costumers c1 = new Costumers("Süleyman",20);
        b.btn.setOnClickListener(view->{
            FirstFragmentDirections.First pass = FirstFragmentDirections.first(c1);
            pass.setName("Süleyman");
            pass.setAge(20);
            Navigation.findNavController(view).navigate(pass);
        });

        return b.getRoot();
    }
}