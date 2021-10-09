package com.example.androidfragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class ListFragment extends androidx.fragment.app.ListFragment {

    ItemSelected activity;
    boolean dualPane;

    public interface ItemSelected {
        void onItemSelected(int index);
    }

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (ItemSelected) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ArrayList<String> data = new ArrayList<>();
//        data.add("1. This is item 1");
//        data.add("2. This is item 2");
//        data.add("3. This is item 3");
        String [] pieces = getResources().getStringArray(R.array.pieces);
//        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, pieces));

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            activity.onItemSelected(0);
        }

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        activity.onItemSelected(position);
    }
}