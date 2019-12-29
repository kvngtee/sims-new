package com.example.ecampus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class AdminChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_chat);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AdminChatActivity.this, HomescreenActivity.class);
        startActivity(intent);

    }
}


