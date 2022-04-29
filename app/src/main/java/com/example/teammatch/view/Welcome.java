package com.example.teammatch.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.teammatch.R;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Welcome extends AppCompatActivity {
    Button login_button, signup_button;
    private Toolbar wcToolbar;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        login_button = findViewById(R.id.login_btn);
        signup_button = findViewById(R.id.signup_btn);
        wcToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(wcToolbar);
        fAuth = FirebaseAuth.getInstance();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLoginIntent = new Intent(v.getContext(), Login.class);
                startActivity(goToLoginIntent);
            }
        });

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSignUpIntent = new Intent(v.getContext(), Signup.class);
                startActivity(goToSignUpIntent);
            }
        });

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), HomePage.class));
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }


}
