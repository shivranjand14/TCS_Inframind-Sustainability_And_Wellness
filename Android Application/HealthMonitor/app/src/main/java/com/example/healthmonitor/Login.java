package com.example.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.HttpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login<HttpPost, HttpClient> extends AppCompatActivity {

    private EditText username,password;
    private Button register,signup;
    private ProgressDialog progressDialog;

    private static final String LOGIN_URL = "http://ecssofttech.com/api/health_monitor/login1.php";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Signing in, Please Wait.....");
        progressDialog.setCanceledOnTouchOutside(false);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        signup=findViewById(R.id.signup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                {
                    Toast.makeText(Login.this, "Username and Password Cannot Empty", Toast.LENGTH_SHORT).show();
                }

                else {


                    progressDialog.show();
                    getlogin(username.getText().toString(),password.getText().toString());
                    Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,User_registration.class);
                startActivity(intent);
            }
        });
    }



    public void getlogin(String username,String password)
    {
        Call<List<ModelClass>> modelClass=BloggerAPI.getServices().getModelList(username,password);
        modelClass.enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
                Log.d("This activity ==== ","response.raw().request().url();"+response.raw().request().url());
                Log.d("This activity ==== ","Success=========> "+response.body());
                //Toast.makeText(Show_All_Product.this, "Success"+response.body(), Toast.LENGTH_SHORT).show();
                // ModelClass u=new ModelClass();
                //list.add(u);
                //List<ModelClass> list= response.body();
                progressDialog.dismiss();
                Intent intent=new Intent(Login.this,Homepage.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {
                Log.d("This activity ==== ","response.raw().request().url();"+call.request().url());
                //Toast.makeText(Login.this, "Failed"+t, Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                Toast.makeText(Login.this, "Invalid Username and Password", Toast.LENGTH_SHORT).show();
            }
        });
    }

}