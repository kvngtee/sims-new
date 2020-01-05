package com.example.ecampus.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecampus.R;

public class AdminChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_chat);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomescreenActivity.class);
        startActivity(intent);

    }
}


