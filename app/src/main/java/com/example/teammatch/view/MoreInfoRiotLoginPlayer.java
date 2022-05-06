package com.example.teammatch.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.teammatch.R;
import com.example.teammatch.model.Player;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.appcompat.app.AppCompatActivity;

public class MoreInfoRiotLoginPlayer extends AppCompatActivity {
    ImageButton prev_btn, riotLoginBtn;
    Button finish_btn;
    Player player;
    EditText main, description;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_more_info_n_riot_login);
        prev_btn = findViewById(R.id.back_minrl_btn);
        finish_btn = findViewById(R.id.finish_btn);
        riotLoginBtn = findViewById(R.id.riot_login_button);
        description = findViewById(R.id.description_txt);
        main = findViewById(R.id.mainAgent);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        player = new Player(fAuth.getCurrentUser().getDisplayName(), fAuth.getCurrentUser().getEmail(), fAuth.getCurrentUser().getUid());

        if (main != null) {
            player.setMain(main.getText().toString());
        } else {
            main.setError("El main Agent no puede estar vacio");
        }

        if (description != null) {
            player.setDescription(description.getText().toString());
        }


        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreInfoRiotLoginPlayer.this, AddProfilePicPlayer.class);
                startActivity(intent);
            }
        });

        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreInfoRiotLoginPlayer.this, HomePage.class);
                startActivity(intent);
            }
        });

    }
}
