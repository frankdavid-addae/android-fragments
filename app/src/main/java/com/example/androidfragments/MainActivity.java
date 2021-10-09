package com.example.androidfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemSelected {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment detailFragment = fragmentManager.findFragmentById(R.id.detailFragment);
        Fragment listFragment = fragmentManager.findFragmentById(R.id.listFragment);

        // Check if the phone is in portrait mode
//        if (findViewById(R.id.layout_portrait) != null) {
//            fragmentTransaction.hide(detailFragment);
//            fragmentTransaction.show(listFragment);
//            fragmentTransaction.commit();
//        }

        // Check if the phone is in landscape mode
//        if (findViewById(R.id.layout_landscape) != null) {
//            fragmentTransaction.show(detailFragment);
//            fragmentTransaction.show(listFragment);
//            fragmentTransaction.commit();
//        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentTransaction.show(detailFragment);
            fragmentTransaction.show(listFragment);
            fragmentTransaction.commit();
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragmentTransaction.hide(detailFragment);
            fragmentTransaction.show(listFragment);
            fragmentTransaction.commit();
        }


    }

    @Override
    public void onItemSelected(int index) {
        DetailFragment detailFragment = DetailFragment.newInstance(index);
        getSupportFragmentManager().beginTransaction().replace(R.id.detailFragment, detailFragment)
               .commit();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment detailFrag = fragmentManager.findFragmentById(R.id.detailFragment);
        Fragment listFragment = fragmentManager.findFragmentById(R.id.listFragment);

        // Check if the phone is in portrait mode
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragmentTransaction.show(detailFragment);
            fragmentTransaction.hide(listFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}