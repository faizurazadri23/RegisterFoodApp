package com.faizurazadri.registerfoodapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.faizurazadri.registerfoodapp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding homeBinding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(homeBinding.getRoot());


        user = getIntent().getParcelableExtra("DATA");

        homeBinding.firstName.setText(user.getFirst_name());
        homeBinding.lastName.setText(user.getLast_name());
        homeBinding.email.setText(user.getEmail());
        homeBinding.password.setText(user.getPassword());
        homeBinding.hp.setText(user.getHp());
        homeBinding.gender.setText(user.getGender());
        homeBinding.address.setText(user.getAddress());

    }
}