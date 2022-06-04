package com.example.teammatch.view;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.teammatch.R;
import com.example.teammatch.view.Fragment.ChatFragment;
import com.example.teammatch.view.Fragment.SoloFragment;
import com.example.teammatch.view.Fragment.TeamsFragment;
import com.example.teammatch.view.Fragment.TournamentFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class HomePage extends AppCompatActivity {

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_solo:
                    selectedFragment = new SoloFragment();
                    break;
                case R.id.nav_team:
                    selectedFragment = new TeamsFragment();
                    break;
                case R.id.nav_tournament:
                    selectedFragment = new TournamentFragment();
                    break;
                case R.id.nav_chat:
                    selectedFragment = new ChatFragment();
                    break;

                default:
                    selectedFragment = new SoloFragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        BottomNavigationView bottomnav = findViewById(R.id.bottom_nav);
        bottomnav.setOnNavigationItemSelectedListener(navListener);

        //para establecer un fragmento como pantalla principal (o por defecto)
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SoloFragment()).commit();
    }


}