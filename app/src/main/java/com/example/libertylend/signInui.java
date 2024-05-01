package com.example.libertylend;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.auth.FirebaseAuth;

import io.github.muddz.styleabletoast.StyleableToast;

public class signInui extends AppCompatActivity {

    EditText editTextemail, editTextpassword;

    FirebaseAuth mAuth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_inui);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextemail = findViewById(R.id.email);
        editTextpassword = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();


    }

    public void login(View v){

        String email, password;
        email = editTextemail.getText().toString();
        password = editTextpassword.getText().toString();


        if (email.isEmpty()) {
            StyleableToast.makeText(this, "Enter your email...", Toast.LENGTH_SHORT,R.style.entries).show();

            return;
        }

        if (password.isEmpty()) {
            StyleableToast.makeText(this, "Enter Your six digit Code...", Toast.LENGTH_SHORT,R.style.entries).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                      StyleableToast.makeText(getApplicationContext(), "Lets make it happen, Login In Successful...",Toast.LENGTH_SHORT, R.style.successfulToast).show();

                        Intent intent = new Intent(getApplicationContext(), Balanceuui.class);
                        startActivity(intent);
                        finish();

                    } else {
                        // If sign in fails, display a message to the user.

                        StyleableToast.makeText(getApplicationContext(), "Incorrect Pin or Email....",Toast.LENGTH_SHORT, R.style.inCorrectToast).show();


                    }
                });

    }




    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    @SuppressLint("ResourceAsColor")
    public void exitapp (View v){

        myDialog myDialog = new myDialog();
        myDialog.show(getSupportFragmentManager(),"123");

        new StyleableToast
                .Builder(getApplicationContext())
                .backgroundColor(R.color.main)
                .textColor(Color.WHITE)
                .show();

    }

    public void forgotpassword(View v){
        forgotpass forgotpass = new forgotpass();
        forgotpass.show(getSupportFragmentManager(),"123");
    }
}