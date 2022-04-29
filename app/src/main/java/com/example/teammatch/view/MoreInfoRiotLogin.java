package com.example.teammatch.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.teammatch.R;

import androidx.appcompat.app.AppCompatActivity;

public class MoreInfoRiotLogin extends AppCompatActivity {
    ImageButton next_btn;
    Button finish_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_more_info_n_riot_login);
        next_btn = findViewById(R.id.back_minrl_btn);
        finish_btn = findViewById(R.id.finish_btn);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreInfoRiotLogin.this, AddProfilePic.class);
                startActivity(intent);
            }
        });

        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreInfoRiotLogin.this, HomePage.class);
                startActivity(intent);
            }
        });

    }
}
