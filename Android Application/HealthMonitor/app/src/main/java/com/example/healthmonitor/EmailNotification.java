package com.example.healthmonitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.StrictMode;
import org.json.JSONArray;
import org.json.JSONObject;
import okhttp3.OkHttpClient;


public class EmailNotification extends AppCompatActivity {

    EditText editTextTo,editTextSubject,editTextMessage;
    Button send;

    TableLayout tableLayout;
    private View layoutProgress;

    List<MyModel> modelList;
    private ProgressDialog progressDialog;
    private static final String DATA_URL = "https://ecssofttech.com/api/health_monitor/show_all_data.php";
    private TableRow tableRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_notification);

        editTextTo=(EditText)findViewById(R.id.editText1);
        editTextSubject=(EditText)findViewById(R.id.editText2);
        editTextMessage=(EditText)findViewById(R.id.editText3);

        send=(Button)findViewById(R.id.button1);

        tableLayout = findViewById(R.id.tbl_layout);
        modelList = new ArrayList<>();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.setCanceledOnTouchOutside(false);


        send.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                getAllData();

            }
        });
    }

    private void getAllData() {
        progressDialog.show();
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
            for (int i = 0; i < contacts.length(); i++){
                JSONObject c = contacts.getJSONObject(i);
                MyModel u =new MyModel();


                String name=c.getString("name");
                Integer bodytemprature=Integer.parseInt(c.getString("bodytemprature"));
                Integer bloodpressure=Integer.parseInt(c.getString("bloodpressure"));
                Integer respiratoryrate=Integer.parseInt(c.getString("respiratoryrate"));
                Integer glucose=Integer.parseInt(c.getString("glucose"));
                Integer heartrate=Integer.parseInt(c.getString("heartrate"));
                Integer oxygensaturation=Integer.parseInt(c.getString("oxygensaturation"));
                Integer electrocardiogram=Integer.parseInt(c.getString("electrocardiogram"));
                Integer bloodsugar=Integer.parseInt(c.getString("bloodsugar"));
                String date=c.getString("date");



                if ((bodytemprature < 97 || bodytemprature > 99) || (bloodpressure >120) ||  (respiratoryrate < 12 || respiratoryrate >16)
                || (glucose>140) || (heartrate <60 || heartrate >100 || (oxygensaturation <95 || oxygensaturation >100)
                ) || (electrocardiogram < 120 || electrocardiogram>200) || (bloodsugar >140)){

                    String to=editTextTo.getText().toString();
                    String subject=editTextSubject.getText().toString();
                    String msg=editTextMessage.getText().toString();


                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                    email.putExtra(Intent.EXTRA_SUBJECT, subject);

                     msg="Name="+name+" Body Temprature="+bodytemprature+" Blood Pressure="+bloodpressure+
                            " Respiratory Rate="+respiratoryrate+" Glucose="+glucose+" Heart Rate="+heartrate+
                            " Oxygen Saturation="+oxygensaturation+" Electrocardiogram="+electrocardiogram
                            +" Blood Sugar="+bloodsugar;
                    email.putExtra(Intent.EXTRA_TEXT, msg);



                    
                    //need this to prompts email client only
                    email.setType("message/rfc822");
                    startActivity(Intent.createChooser(email, "Choose an Email client :"));

                }

                modelList.add(u);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}

