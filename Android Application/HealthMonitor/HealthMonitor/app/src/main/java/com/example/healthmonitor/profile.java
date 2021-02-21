package com.example.healthmonitor;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class profile extends AppCompatActivity {
String un;
String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent i=getIntent();
        un=i.getStringExtra("username");
        pass=i.getStringExtra("password");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        OkHttpClient client = new OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url("https://ecssofttech.com/api/health_monitor/mydata.php?username="+un+"&password="+pass+"")  //send parameteres to php script
                .build();
        try {
            okhttp3.Response response1 = client.newCall(request).execute();
            String responseString = response1.body().string();
            System.out.println(responseString);
            JSONArray contacts = new JSONArray(responseString);
            for (int in = 0; in < contacts.length(); in++) {
                JSONObject c = contacts.getJSONObject(in);


                String firstname = c.getString("firstname");

                OkHttpClient client1 = new OkHttpClient();
                okhttp3.Request request1 = new okhttp3.Request.Builder()
                        .url("https://ecssofttech.com/api/health_monitor/showhealthdata.php?flag="+firstname+"")  //send parameteres to php script
                        .build();

                    okhttp3.Response response2 = client1.newCall(request1).execute();
                    String responseString1 = response2.body().string();
                    System.out.println(responseString1);
                    JSONArray contacts1 = new JSONArray(responseString1);
                    for (int in1 = 0; in1 < contacts1.length(); in1++) {
                        JSONObject c1 = contacts1.getJSONObject(in1);


                        String name = c1.getString("name");
                        String bodytemprature = c1.getString("bodytemprature");
                        String bloodpressure = c1.getString("bloodpressure");
                        String respiratoryrate = c1.getString("respiratoryrate");
                        String glucose = c1.getString("glucose");
                        String heartrate = c1.getString("heartrate");
                        String oxygensaturation = c1.getString("oxygensaturation");
                        String electrocardiogram = c1.getString("electrocardiogram");
                        String bloodsugar = c1.getString("bloodsugar");
                        String date = c1.getString("date");
                    }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}