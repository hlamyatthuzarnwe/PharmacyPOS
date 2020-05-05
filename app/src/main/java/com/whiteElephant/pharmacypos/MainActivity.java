package com.whiteElephant.pharmacypos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.TextView;

import com.whiteElephant.pharmacypos.activity.LoginActivity;
import com.whiteElephant.pharmacypos.activity.RegisterActivity;
import com.whiteElephant.pharmacypos.activity.SplashActivity;
import com.whiteElephant.pharmacypos.helper.SharepreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static int LOCATE_ACTIVITY = 0;
    SharepreferenceHelper share;
    private Handler handler;

    @BindView(R.id.tvSingIn)
    TextView singIn;

    @BindView(R.id.tvSingUp)
    TextView singUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        init();

    }

    private void init(){

        share = new SharepreferenceHelper();
        singIn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        singUp.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home){
            goToSplashActivity();
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToSplashActivity(){
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        goToSplashActivity();
        // super.onBackPressed();
    }
}
