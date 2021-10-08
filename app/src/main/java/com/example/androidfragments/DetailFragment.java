package com.example.androidfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailFragment extends Fragment {

    TextView tvDescription;
//    ArrayList<String> descriptions;
    String [] descriptions;

    int index;

    private static final String INDEX = "index";

    public static DetailFragment newInstance(int index){
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvDescription = view.findViewById(R.id.tvDescription);

//        descriptions = new ArrayList<>();
//        descriptions.add("Description for item 1");
//        descriptions.add("Description for item 2");
//        descriptions.add("Description for item 3");
        descriptions = getResources().getStringArray(R.array.descriptions);

        if (getArguments() != null) {
            index = getArguments().getInt(INDEX);
        }
//        tvDescription.setText(descriptions.get(index));
        tvDescription.setText(descriptions[index]);
    }
}