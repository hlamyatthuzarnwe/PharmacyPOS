package com.whiteElephant.pharmacypos.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.whiteElephant.pharmacypos.MainActivity;
import com.whiteElephant.pharmacypos.R;
import com.whiteElephant.pharmacypos.helper.SharepreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private static String TAG = "LoginActivity";

    SharepreferenceHelper share;

    @BindView(R.id.til_userName_login)
    TextInputLayout userNameLogin;

    @BindView(R.id.til_password_login)
    TextInputLayout passwordLogin;

    @BindView(R.id.btn_login)
    Button btnLogin;

    @BindView(R.id.tv_forgotPwd_login)
    TextView forgotPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Login");
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        init();
    }

    private void init(){
        share = new SharepreferenceHelper();

        forgotPwd.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home){
            goToMainActivity();
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToMainActivity(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        goToMainActivity();
        // super.onBackPressed();
    }

}
