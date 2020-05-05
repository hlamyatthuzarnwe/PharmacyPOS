package com.whiteElephant.pharmacypos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.whiteElephant.pharmacypos.MainActivity;
import com.whiteElephant.pharmacypos.R;
import com.whiteElephant.pharmacypos.helper.SharepreferenceHelper;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";
    private SharepreferenceHelper sharepreferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        sharepreferenceHelper = SharepreferenceHelper.getHelper(this);
        new Handler().postDelayed(this::initProcess, 1500);

    }

    private void initProcess(){

        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

//        if (sharepreferenceHelper.isLogIn()){
//            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }else {
//            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
//            startActivity(intent);
//            finish();
//        }
    }
}
