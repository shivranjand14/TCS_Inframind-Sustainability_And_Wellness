package com.example.healthmonitor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Homepage extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private SharedPreferences sharedPreferences;
    private ImageButton imgBtn;
public String un;
public String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Intent i=getIntent();
        un=i.getStringExtra("username");
        pass=i.getStringExtra("password");
        imgBtn=findViewById(R.id.bluetoothBtn);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Homepage.this,Bluetooth.class);
                startActivity(intent);
                setContentView(R.layout.activity_bluetooth);
            }
        });




        mMainNav=(BottomNavigationView)findViewById(R.id.bootom_navigation_bar);
        mMainNav.setSelectedItemId(R.id.home);
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        //Toast.makeText(Sender_home_page.this,"You Click Home",Toast.LENGTH_LONG).show();
                        return true;

                    case R.id.search:
                        Toast.makeText(Homepage.this,"You Click Homepage",Toast.LENGTH_LONG).show();
                        //Intent i=new Intent(getApplicationContext(),Show_all_product.class);
                        // overridePendingTransition(0,0);
                        // finish();
                        // startActivity(i);
                        return true;

                    case R.id.profile:
                        //Toast.makeText(Sender_home_page.this,"You Click Profile",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),profile.class);
                        intent.putExtra("username",un);
                        intent.putExtra("password",pass);
                        overridePendingTransition(0,0);
                        finish();
                        startActivity(intent);
                        return true;

                    case R.id.share:
                        Intent in=new Intent(getApplicationContext(),user_data.class);
                        overridePendingTransition(0,0);
                        finish();
                        startActivity(in);
                        //Toast.makeText(Homepage.this, "You Click Share", Toast.LENGTH_SHORT).show();
                        return true;




                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator=getMenuInflater();
        inflator.inflate(R.menu.home_logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.show_all_location:
                //Intent intent1 = new Intent(Homepage.this,Show_all_product.class);
                //intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
              //  startActivity(intent1);
                //finish();
                return true;

            case R.id.email_notification:
                Intent intent = new Intent(Homepage.this,EmailNotification.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;



            case R.id.logout:

                Intent intent1 = new Intent(Homepage.this,Login.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}