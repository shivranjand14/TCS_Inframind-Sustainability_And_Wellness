package com.example.healthmonitor;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Set;

public class Bluetooth extends AppCompatActivity {

    private Set<BluetoothDevice> pairedDevices;
    ListView lv;
    private Build.VERSION_CODES Android;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        Button btntOn = (Button)findViewById(R.id.btnOn);
        Button btntOff = (Button)findViewById(R.id.btnOFF);
        //Button btnVisible = (Button)findViewById(R.id.btnVisible);
       // Button btnPair = (Button)findViewById(R.id.btnPair);
      //  lv = findViewById(R.id.listView);
        final BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();

      btntOn.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View v) {
              if(bAdapter == null)
              {
                  Toast.makeText(getApplicationContext(),"Bluetooth Not Supported",Toast.LENGTH_SHORT).show();
              }
              else{
                  if(!bAdapter.isEnabled()){
                      startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE),1);
                      Toast.makeText(getApplicationContext(),"Bluetooth Turned ON",Toast.LENGTH_SHORT).show();
                  }
              }
          }

      });

        btntOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bAdapter.disable();
                Toast.makeText(getApplicationContext(),"Bluetooth Turned OFF", Toast.LENGTH_SHORT).show();
            }
        });

       /* btnVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(getVisible, 0);
            }
        });

        btnPair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pairedDevices= bAdapter.getBondedDevices();

                ArrayList list = new ArrayList();

                for(BluetoothDevice bt : pairedDevices) list.add(bt.getName());
                Toast.makeText(getApplicationContext(), "Showing Paired Devices",Toast.LENGTH_SHORT).show();

                final ArrayAdapter adapter = new  ArrayAdapter(this,Android.R.layout.activity_list_item, list);


                lv.setAdapter(adapter);

            }
        });*/


    }
}