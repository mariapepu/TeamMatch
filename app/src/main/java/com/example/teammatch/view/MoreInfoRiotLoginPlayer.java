package com.example.teammatch.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.teammatch.R;
import com.example.teammatch.model.Player;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.appcompat.app.AppCompatActivity;

public class MoreInfoRiotLoginPlayer extends AppCompatActivity {
    ImageButton prev_btn, riotLoginBtn;
    Button finish_btn;
    Player player;
    EditText description, username;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    Spinner mainSel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_more_info_n_riot_login);

        prev_btn = findViewById(R.id.back_minrl_btn);
        finish_btn = findViewById(R.id.finish_btn);
        riotLoginBtn = findViewById(R.id.riot_login_button);
        description = findViewById(R.id.description_txt);
        username = findViewById(R.id.username);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        //SPINNER
        mainSel = findViewById(R.id.mainSelection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.mainSelection, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mainSel.setAdapter(adapter);

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
                //creating player
                if (!TextUtils.isEmpty(username.getText().toString())) {
                    player = new Player(username.toString(), mAuth.getCurrentUser().getEmail(), mAuth.getCurrentUser().getUid());
                    //SETTING PLAYER ROLE
                    if (mainSel.getSelectedItemPosition() > 0) {
                        player.setMain(mainSel.getSelectedItem().toString());
                        player.setRole();
                        System.out.println(player.getRole());
                        String userId = mAuth.getCurrentUser().getUid();
                        FirebaseDatabase db = FirebaseDatabase.getInstance("https://teammatch-4302b-default-rtdb.europe-west1.firebasedatabase.app");
                        DatabaseReference currentUserDb = db.getReference().child("Users").child(player.getRole()).child(userId).child("name");
                        currentUserDb.setValue(username.getText().toString());
                        Toast.makeText(MoreInfoRiotLoginPlayer.this, player.getRole(), Toast.LENGTH_SHORT).show();
                    }
                    //SHOWING ERROR IN SPINNER
                    /*else {
                    TextView errorText = (TextView) findViewById(R.id.mainSelection);
                    errorText.setError("");
                    errorText.setTextColor(Color.RED);
                    errorText.setText("Debes seleccionar un Agente");
                    }*/

                    //SETTING DESCRIPTION
                    if (description != null) {
                        player.setDescription(description.getText().toString());
                    }

                    Intent intent = new Intent(MoreInfoRiotLoginPlayer.this, HomePage.class);
                    startActivity(intent);
                } else {
                    username.setError("Debes poner un nombre de usuario vàlido");
                }


            }
        });

    }
}
