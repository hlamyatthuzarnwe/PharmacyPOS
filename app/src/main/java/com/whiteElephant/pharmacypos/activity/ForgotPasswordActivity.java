package com.whiteElephant.pharmacypos.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.whiteElephant.pharmacypos.R;
import com.whiteElephant.pharmacypos.helper.SharepreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgotPasswordActivity extends AppCompatActivity {

    private static String TAG = "ForgotPasswordActivity";
    SharepreferenceHelper share;

    @BindView(R.id.btn_ok_forgotPwd)
    Button btnOk;

    @BindView(R.id.btn_cancel_forgotPwd)
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ForgotPassword");
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        init();
    }

    private void init(){
        share = new SharepreferenceHelper();

        btnOk.setOnClickListener(v -> {
            Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        btnCancel.setOnClickListener(v -> {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home){
            goToLoginActivity();
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToLoginActivity(){
        Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        goToLoginActivity();
        // super.onBackPressed();
    }
}
