package com.example.ecampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class ForgotpasswordActivity extends AppCompatActivity {

    private EditText regEmail;
    private Button btnReset;
    private TextView tvback;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        regEmail = findViewById(R.id.registeredemail);
        btnReset = findViewById(R.id.resetpassword);
        tvback = findViewById(R.id.goback);
        progressBar = findViewById(R.id.progressBar3);
        progressBar.setVisibility(View.GONE);


        tvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotpasswordActivity.this, LoginActivity.class));
                finish();
            }
        });



        }

}
