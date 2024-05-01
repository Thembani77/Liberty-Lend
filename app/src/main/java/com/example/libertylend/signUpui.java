package com.example.libertylend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import io.github.muddz.styleabletoast.StyleableToast;

public class signUpui extends AppCompatActivity {

    EditText editTextemail, editTextpassword;
    Button buttonReg;
    FirebaseAuth mAuth;



    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){

         //   Intent intent = new Intent(getApplicationContext(), Balanceuui.class);
         //   startActivity(intent);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_startedui);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        editTextemail = findViewById(R.id.email);
        editTextpassword = findViewById(R.id.password);
        buttonReg = findViewById(R.id.signup);
        mAuth = FirebaseAuth.getInstance();


    }
        public void gsuback(View v)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();

    }



    
    public void signup(View v)
    {

        String email, password;
        email = editTextemail.getText().toString();
        password = editTextpassword.getText().toString();

        if (password.isEmpty())
        {
            StyleableToast.makeText(signUpui.this, "Enter Your six digit Code...", Toast.LENGTH_SHORT,R.style.entries).show();
            return;
        }

        if (email.isEmpty())
        {
            StyleableToast.makeText(signUpui.this, "Enter your email...", Toast.LENGTH_SHORT, R.style.entries).show();

            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            StyleableToast.makeText(signUpui.this, "Account Created Successfully...",R.style.successfulToast,
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Balanceuui.class);
                            startActivity(intent);
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            StyleableToast.makeText(signUpui.this,"Oops, Looks like you not connected to the internet...",R.style.inCorrectToast,
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });



    }


}