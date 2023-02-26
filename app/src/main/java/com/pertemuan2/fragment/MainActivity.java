package com.pertemuan2.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnMoar;
    private boolean isDisplayed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoar = findViewById(R.id.btn_readMoar);
        btnMoar.setOnClickListener(view -> {
            if (isDisplayed) {
                displayFragment();
            }
            else {
                closeFragment();
            }
        });
    }

    private void displayFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DynamicFragment dynamicFragment = new DynamicFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.isian_frame2, dynamicFragment).addToBackStack(null).commit();
        isDisplayed = false;
        btnMoar.setText(R.string.button2);
    }

    private void closeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DynamicFragment dynamicFragment = (DynamicFragment) fragmentManager.findFragmentById(R.id.isian_frame2);

        if (dynamicFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(dynamicFragment).commit();
        }

        btnMoar.setText(R.string.button1);
        isDisplayed = true;
    }
}