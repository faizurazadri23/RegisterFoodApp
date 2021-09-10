package com.faizurazadri.registerfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.faizurazadri.registerfoodapp.databinding.ActivityMainBinding;
import com.faizurazadri.registerfoodapp.databinding.ToolbarBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private String first_name,last_name,email,password,hp,gender, address;
    private String list_gender[] = {"Laki-Laki", "Perempuan"};
    private ToolbarBinding toolbarBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        toolbarBinding = mainBinding.toolbar;
        setContentView(mainBinding.getRoot());

        setToolbarBinding();

        ArrayAdapter<String> arrayAdapterGender = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list_gender);

        mainBinding.gender.setAdapter(arrayAdapterGender);


        mainBinding.btnRegister.setOnClickListener(view -> {
            if (mainBinding.edtFirstName.getText().toString().isEmpty()){
                mainBinding.edtFirstName.setError(getResources().getString(R.string.txt_required));
                mainBinding.edtFirstName.requestFocus();
                return;
            }

            if (mainBinding.edtLastName.getText().toString().isEmpty()){
                mainBinding.edtLastName.setError(getResources().getString(R.string.txt_required));
                mainBinding.edtLastName.requestFocus();
                return;
            }

            if (mainBinding.edtEmail.getText().toString().isEmpty()){
                mainBinding.edtEmail.setError(getResources().getString(R.string.txt_required));
                mainBinding.edtEmail.requestFocus();
                return;
            }

            if (mainBinding.edtPassword.getText().toString().isEmpty()){
                mainBinding.edtPassword.setError(getResources().getString(R.string.txt_required));
                mainBinding.edtPassword.requestFocus();
                return;
            }

            if (mainBinding.edtHp.getText().toString().isEmpty()){
                mainBinding.edtHp.setError(getResources().getString(R.string.txt_required));
                mainBinding.edtHp.requestFocus();
                return;
            }

            if (mainBinding.edtAddress.getText().toString().isEmpty()){
                mainBinding.edtAddress.setError(getResources().getString(R.string.txt_required));
                mainBinding.edtAddress.requestFocus();
                return;
            }

            first_name = mainBinding.edtFirstName.getText().toString();
            last_name = mainBinding.edtLastName.getText().toString();
            email = mainBinding.edtEmail.getText().toString();
            password = mainBinding.edtPassword.getText().toString();
            hp = mainBinding.edtHp.getText().toString();
            gender = mainBinding.gender.getText().toString();
            address = mainBinding.edtAddress.getText().toString();

            User user = new User();
            user.setFirst_name(first_name);
            user.setLast_name(last_name);
            user.setEmail(email);
            user.setPassword(password);
            user.setHp(hp);
            user.setGender(gender);
            user.setAddress(address);

            Intent toRegister = new Intent(MainActivity.this, HomeActivity.class);
            toRegister.putExtra("DATA", user);
            startActivity(toRegister);
        });
    }

    private void setToolbarBinding(){
        Toolbar toolbar = toolbarBinding.toolbar;
        setSupportActionBar(toolbar);
        toolbarBinding.tvTitle.setText(getResources().getString(R.string.txt_register));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }
}