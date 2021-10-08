package com.example.androidfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemSelected(int index) {
        DetailFragment detailFragment = DetailFragment.newInstance(index);
      getSupportFragmentManager().beginTransaction().replace(R.id.detailFragment, detailFragment)
               .commit();
    }
}