package com.example.libertylend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import io.github.muddz.styleabletoast.StyleableToast;

public class Balanceuui extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_balanceuui);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void bell(View v){

        StyleableToast.makeText(this, "You currently have no new notifications", Toast.LENGTH_SHORT,R.style.notificationbell).show();

    }

    public void backtohome(View v)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void addcard_balanceui(View v){
        Intent intent = new Intent(getApplicationContext(), addnewcard.class);
        startActivity(intent);
        finish();
    }

    public void profile_balanceui(View v){
        StyleableToast.makeText(this, "Profile Viewing is coming Soon.", Toast.LENGTH_SHORT,R.style.Comingsoon).show();
    }
}