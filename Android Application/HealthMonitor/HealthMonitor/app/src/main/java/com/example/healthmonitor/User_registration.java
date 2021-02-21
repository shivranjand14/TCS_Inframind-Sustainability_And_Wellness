package com.example.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;


public class User_registration extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private EditText firstname, lastname, mobile, username, password, confirmpassword;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing in, Please Wait.....");
        progressDialog.setCanceledOnTouchOutside(false);
        firstname = findViewById(R.id.fname);
        lastname = findViewById(R.id.lname);
        mobile = findViewById(R.id.mobile);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmpassword);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty() || firstname.getText().toString().isEmpty() || lastname.getText().toString().isEmpty() || mobile.getText().toString().isEmpty() || confirmpassword.getText().toString().isEmpty()) {
                    Toast.makeText(User_registration.this, "Fields Cannot be Empty", Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.show();
                    if(password.getText().toString().equals(confirmpassword.getText().toString()))
                    {
                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                        StrictMode.setThreadPolicy(policy);
                        getregistration(firstname.getText().toString(),lastname.getText().toString(),mobile.getText().toString(),username.getText().toString(), password.getText().toString(), confirmpassword.getText().toString());
                        Toast.makeText(User_registration.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        Intent intent=new Intent(User_registration.this,Homepage.class);
                        startActivity(intent);
                        finish();
                    }

                    else {
                        progressDialog.dismiss();
                        Toast.makeText(User_registration.this, "Password not matched", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
    }

    private void getregistration(String firstname, String lastname, String mobile, String username, String password,String confirmpassword)
    {

        OkHttpClient client = new OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url("http://ecssofttech.com/api/health_monitor/reg.php?firstName="+firstname+"&lastName="+lastname+"&mobile="+mobile+"" +
                        "&username="+username+"&password="+password)  //send parameteres to php script
                .build();
        try {
            Response response = client.newCall(request).execute();
            String responseString = response.body().string();
            System.out.println(responseString);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


