package com.example.teammatch.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.teammatch.R;

import androidx.appcompat.app.AppCompatActivity;

public class AddProfilePicPlayer extends AppCompatActivity {
    ImageButton next_btn, prev_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_add_profile_picture);
        next_btn = findViewById(R.id.forward_add_pic_btn);
        prev_btn = findViewById(R.id.back_add_pic_btn);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddProfilePicPlayer.this, MoreInfoRiotLoginPlayer.class);
                startActivity(intent);
            }
        });

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddProfilePicPlayer.this, UserTypeChoosing.class);
                startActivity(intent);
            }
        });
    }
}
