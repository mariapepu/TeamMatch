package com.example.teammatch.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.teammatch.R;
import com.example.teammatch.model.TournamentHost;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.appcompat.app.AppCompatActivity;

public class MoreInfoRiotLoginHost extends AppCompatActivity {
    ImageButton prev_btn, riotLoginBtn;
    Button finish_btn;
    TournamentHost host;
    EditText description;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_more_info_host);
        prev_btn = findViewById(R.id.back_minrl_btnH);
        finish_btn = findViewById(R.id.finish_btnH);
        riotLoginBtn = findViewById(R.id.riot_login_buttonH);
        description = findViewById(R.id.description_txtH);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        host = new TournamentHost(fAuth.getCurrentUser().getDisplayName(), fAuth.getCurrentUser().getEmail(), fAuth.getCurrentUser().getUid());

        if (description != null) {
            host.setDescription(description.getText().toString());
        }

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreInfoRiotLoginHost.this, AddProfilePicHost.class);
                startActivity(intent);
            }
        });

        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreInfoRiotLoginHost.this, HomePage.class);
                startActivity(intent);
            }
        });

    }
}
