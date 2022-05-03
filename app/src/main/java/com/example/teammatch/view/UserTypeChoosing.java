package com.example.teammatch.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.teammatch.R;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class UserTypeChoosing extends AppCompatActivity {
   ImageButton next_btn, prev_btn;
   Button host_btn, player_btn;
   FirebaseAuth fAuth;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_signup_profile_type);
       next_btn = findViewById(R.id.forward_profile_choose_btn);
       prev_btn = findViewById(R.id.back_profile_choose_btn);
       fAuth = FirebaseAuth.getInstance();
       /*TODO
        * buscar como puedo pasar un user de una vista a la otra*/
       host_btn = findViewById(R.id.host_btn);
       host_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(UserTypeChoosing.this, AddProfilePicHost.class);
               startActivity(intent);
           }
       });

       player_btn = findViewById(R.id.player_btn);
       player_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(UserTypeChoosing.this, AddProfilePicPlayer.class);
               startActivity(intent);
           }
       });

      prev_btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Intent intent = new Intent(UserTypeChoosing.this, Signup.class);
            startActivity(intent);
            /*TODO
            eliminar los datos del signup si echa para atras
            */
            fAuth.getCurrentUser().delete();

         }
      });

   }
}
