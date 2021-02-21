package com.example.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

public class my_data extends AppCompatActivity {
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_data);
        progressDialog.dismiss();
        Intent intent=new Intent(my_data.this,Homepage.class);
        startActivity(intent);
        finish();
    }
}