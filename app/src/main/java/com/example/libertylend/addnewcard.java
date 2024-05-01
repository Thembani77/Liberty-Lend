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

public class addnewcard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addnewcard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void backtohome_addcard(View v){
        Intent intent = new Intent(getApplicationContext(), Balanceuui.class);
        startActivity(intent);
        finish();

    }

    public void addCrd(View v){

        StyleableToast.makeText(getApplicationContext(),"Card Added Successfully", Toast.LENGTH_SHORT,R.style.successfulToast).show();

    }
}