package com.example.teammatch.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.teammatch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private FirebaseAuth mAuth;
    private int i = 8; //poner a 0 quandoi se implemente !!!!
    private ImageButton controller, initiator, duelist, centinel, tournament, chat, solo, team;
    private String userRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        controller = findViewById(R.id.controller_btn);
        initiator = findViewById(R.id.initiator_btn);
        duelist = findViewById(R.id.duelist_btn);
        centinel = findViewById(R.id.centinel_btn);


        //checkUsersRole();

        al = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al);

        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(HomePage.this, "Left!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(HomePage.this, "Right!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
            }
        });

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(HomePage.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        controller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //limpiamos del anterior uso i cojemos los usuarios marcardos como controladores
                al.clear();
                arrayAdapter.notifyDataSetChanged();
                getControllerUsers();
            }
        });

        duelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //limpiamos del anterior uso i cojemos los usuarios marcardos como duelistas
                al.clear();
                arrayAdapter.notifyDataSetChanged();
                getDuelistUsers();
            }
        });

        initiator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //limpiamos del anterior uso i cojemos los usuarios marcardos como iniciadores
                al.clear();
                arrayAdapter.notifyDataSetChanged();
                getInitiatorUsers();
            }
        });

        centinel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //limpiamos del anterior uso i cojemos los usuarios marcardos como centinelas
                al.clear();
                arrayAdapter.notifyDataSetChanged();
                getCentinelUsers();
            }
        });
    }

    public void getControllerUsers() {
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://teammatch-4302b-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference controllerDb = db.getReference().child("Users").child("Controller");
        controllerDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if (snapshot.exists()) {
                    al.add(snapshot.child("name").getValue().toString());
                    arrayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void getDuelistUsers() {
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://teammatch-4302b-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference duelistDb = db.getReference().child("Users").child("Duelist");
        duelistDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if (snapshot.exists()) {
                    al.add(snapshot.child("name").getValue().toString());
                    arrayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void getInitiatorUsers() {
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://teammatch-4302b-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference initiatorDb = db.getReference().child("Users").child("Initiator");
        initiatorDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if (snapshot.exists()) {
                    al.add(snapshot.child("name").getValue().toString());
                    arrayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    /*
     * CRE0 QUE LO NECESITARE MAS TARDE PARA QUE NO SALGA UNO MISMO
     * */

    public void getCentinelUsers() {
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://teammatch-4302b-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference centinelDb = db.getReference().child("Users").child("Centinel");
        centinelDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if (snapshot.exists()) {
                    al.add(snapshot.child("name").getValue().toString());
                    arrayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    /*public void checkUsersRole(){
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://teammatch-4302b-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference controllerDb = db.getReference().child("Users").child("Controller");
        controllerDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                if (snapshot.getKey().equals(user.getUid())){
                    userRole = "Controller";
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference duelistDb = db.getReference().child("Users").child("Duelist");
        duelistDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                if (snapshot.getKey().equals(user.getUid())){
                    userRole = "Duelist";
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference centinelDb = db.getReference().child("Users").child("Centinel");
        centinelDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                if (snapshot.getKey().equals(user.getUid())){
                    userRole = "Centinel";
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference initiatorDb = db.getReference().child("Users").child("Initiator");
        initiatorDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                if (snapshot.getKey().equals(user.getUid())){
                    userRole = "Initiator";
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }*/


}