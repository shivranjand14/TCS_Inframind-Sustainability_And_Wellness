package com.example.healthmonitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;

public class ShowData extends AppCompatActivity implements View.OnClickListener{

    TableLayout tableLayout;
    List<MyModel> modelList;
    private ProgressDialog progressDialog;
    private static final String DATA_URL = "https://ecssofttech.com/api/health_monitor/show_all_data.php";
    private TableRow tableRow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        tableLayout = findViewById(R.id.tbl_layout);
        modelList = new ArrayList<>();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.setCanceledOnTouchOutside(false);
        getAllData();

    }




    private void addHeaders() {
        TableLayout tl = findViewById(R.id.tbl_layout);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());

        //tr.addView(getTextView(0, "Auditor id", Color.WHITE, Typeface.BOLD, R.color.colorAccent));
        tr.addView(getTextView(0,"Name",Color.WHITE,Typeface.BOLD,R.color.colorAccent));
        tr.addView(getTextView(0, "BodyTemprature", Color.WHITE, Typeface.BOLD, R.color.colorAccent ));
        tr.addView(getTextView(0, "BloodPressure", Color.WHITE, Typeface.BOLD,R.color.colorAccent ));
        tr.addView(getTextView(0, "Respiratoryrate", Color.WHITE, Typeface.BOLD,R.color.colorAccent ));
        tr.addView(getTextView(0, "Glucose",Color.WHITE, Typeface.BOLD, R.color.colorAccent ));
        tr.addView(getTextView(0, "HeartRate", Color.WHITE, Typeface.BOLD, R.color.colorAccent ));
        tr.addView(getTextView(0, "Oxygensaturation", Color.WHITE, Typeface.BOLD,R.color.colorAccent ));
        tr.addView(getTextView(0, "Electrocardiogram", Color.WHITE, Typeface.BOLD,R.color.colorAccent ));
        tr.addView(getTextView(0, "Bloodsugar",Color.WHITE, Typeface.BOLD, R.color.colorAccent ));
        tr.addView(getTextView(0,"Date",Color.WHITE,Typeface.BOLD,R.color.colorAccent));

        tl.addView(tr, getTblLayoutParams());

    }

    private void getAllData() {
        progressDialog.show();
        addHeaders();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        OkHttpClient client = new OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url("https://ecssofttech.com/api/health_monitor/show_all_data.php")  //send parameteres to php script
                .build();
        try {
            okhttp3.Response response1 = client.newCall(request).execute();
            String responseString = response1.body().string();
            System.out.println(responseString);
            JSONArray contacts = new JSONArray(responseString);
            for (int i = 0; i < contacts.length(); i++) {
                JSONObject c = contacts.getJSONObject(i);
                MyModel u =new MyModel();

                u.setname(c.getString("name"));
                u.setbodytemprature(c.getString("bodytemprature"));
                u.setbloodpressure(c.getString("bloodpressure"));
                u.setrespiratoryrate(c.getString("respiratoryrate"));
                u.setglucose(c.getString("glucose"));
                u.setheartrate(c.getString("heartrate"));
                u.setoxygensaturation(c.getString("oxygensaturation"));
                u.setelectrocardiogram(c.getString("electrocardiogram"));
                u.setbloodsugar(c.getString("bloodsugar"));
                u.setDate(c.getString("date"));


                modelList.add(u);
            }
            setData();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void setData() {
        for (int i = 0; i < modelList.size(); i++) {
            TableRow tr = new TableRow(ShowData.this);
            tr.setLayoutParams(getLayoutParams());

            tr.addView(getRowsTextView(0, modelList.get(i).getname(), Color.BLACK, Typeface.BOLD ,R.drawable.cell_shape ));
            tr.addView(getRowsTextView(0, modelList.get(i).getbodytemprature(), Color.BLACK, Typeface.BOLD ,R.drawable.cell_shape ));
            tr.addView(getRowsTextView(0, modelList.get(i).getbloodpressure(), Color.BLACK, Typeface.BOLD ,R.drawable.cell_shape ));
            tr.addView(getRowsTextView(0, modelList.get(i).getrespiratoryrate(), Color.BLACK, Typeface.BOLD ,R.drawable.cell_shape ));
            tr.addView(getRowsTextView(0, modelList.get(i).getglucose(), Color.BLACK, Typeface.BOLD ,R.drawable.cell_shape ));
            tr.addView(getRowsTextView(0, modelList.get(i).getheartrate(), Color.BLACK, Typeface.BOLD ,R.drawable.cell_shape ));
            tr.addView(getRowsTextView(0, modelList.get(i).getoxygensaturation(), Color.BLACK, Typeface.BOLD ,R.drawable.cell_shape ));
            tr.addView(getRowsTextView(0, modelList.get(i).getoxygensaturation(), Color.BLACK, Typeface.BOLD ,R.drawable.cell_shape ));
            tr.addView(getRowsTextView(0, modelList.get(i).getbloodsugar(), Color.BLACK, Typeface.BOLD ,R.drawable.cell_shape ));
            tableLayout.addView(tr, getTblLayoutParams());

        }

        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                progressDialog.dismiss();
            }
        };

        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 3000);
    }




















    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(ShowData.this, Homepage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {

    }

    private TextView getTextView(int id, String title, int color, int typeface, int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title.toUpperCase());
        tv.setTextColor(color);
        tv.setPadding(10, 10, 10, 10);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundColor(bgColor);
        tv.setBackgroundResource(bgColor);
        tv.setLayoutParams(getLayoutParams());
        tv.setOnClickListener(this);
        return tv;
    }

    @NonNull
    private TableRow.LayoutParams getLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(1, 1, 1, 1);
        params.weight = 1;
        return params;
    }

    @NonNull
    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
    }



    private TextView getRowsTextView(int id, String title, int color, int typeface,int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title);
        tv.setTextColor(color);
        tv.setPadding(10, 10, 10, 10);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundResource(bgColor);
        tv.setLayoutParams(getLayoutParams());
        tv.setOnClickListener(this);
        return tv;
    }

}