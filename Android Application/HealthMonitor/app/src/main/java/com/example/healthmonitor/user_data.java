package com.example.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.Response;

public class user_data extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private EditText bodytemprature, bloodpressure, respiratoryrate, glucose, heartrate, oxygensaturation, electrocardiogram,bloodsugar,name;
    private Button register;
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_data);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Submiting report, Please Wait.....");
        progressDialog.setCanceledOnTouchOutside(false);

        date=findViewById(R.id.date);
        name=findViewById(R.id.name);
        bodytemprature = findViewById(R.id.bodytemprature);
        bloodpressure = findViewById(R.id.bloodpressure);
        respiratoryrate = findViewById(R.id.respiratoryrate);
        glucose = findViewById(R.id.glucose);
        heartrate = findViewById(R.id.heartrate);
        oxygensaturation = findViewById(R.id.oxygensaturation);
        electrocardiogram = findViewById(R.id.electrocardiogram);
        bloodsugar = findViewById(R.id.bloodsugar);
        register = findViewById(R.id.register);

        //access current date and time
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String currentDateandTime = sdf.format(new Date());
        date.setText(currentDateandTime);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || bodytemprature.getText().toString().isEmpty() || bloodpressure.getText().toString().isEmpty() || respiratoryrate.getText().toString().isEmpty() || glucose.getText().toString().isEmpty() || heartrate.getText().toString().isEmpty() || oxygensaturation.getText().toString().isEmpty() || electrocardiogram.getText().toString().isEmpty() || bloodsugar.getText().toString().isEmpty())
                {
                    Toast.makeText(user_data.this, "Fields Cannot be Empty", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                        StrictMode.setThreadPolicy(policy);
                        getregistration(bodytemprature.getText().toString(), bloodpressure.getText().toString(), respiratoryrate.getText().toString(), glucose.getText().toString(), heartrate.getText().toString(), oxygensaturation.getText().toString(),
                                electrocardiogram.getText().toString(), bloodsugar.getText().toString(),name.getText().toString(),date.getText().toString());

                    progressDialog.dismiss();
                    Intent intent = new Intent(user_data.this, ShowData.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

        private void getregistration(String bodytemprature, String bloodpressure, String respiratoryrate, String glucose, String heartrate,String oxygensaturation,String electrocardiogram,String bloodsugar,String name,String date)
        {
            Date c = Calendar.getInstance().getTime();
            System.out.println("Current time => " + c);

            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
            String formattedDate = df.format(c);
            OkHttpClient client = new OkHttpClient();
            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url("https://ecssofttech.com/api/health_monitor/health_monitor_data.php?bodytemprature="+bodytemprature+
                            "&bloodpressure="+bloodpressure+"&respiratoryrate="+respiratoryrate+"&glucose="
                            +glucose+ "&heartrate="+heartrate+"&oxygensaturation="
                            +oxygensaturation+ "&electrocardiogram="+electrocardiogram+ "&bloodsugar="+bloodsugar+"&name="+name+"&date="+date)  //send parameteres to php script
                    .build();
            try {
                Response response = client.newCall(request).execute();
                String responseString = response.body().string();
                Toast.makeText(user_data.this, responseString, Toast.LENGTH_SHORT).show();
                System.out.println(responseString);


            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }

