package com.example.teammatch.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.teammatch.R;
import com.example.teammatch.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button login, signup;
    ImageButton fb;
    EditText txtEmail, txtPassword, txtUsername;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    User usuario;
    String userID;

    // Inicio sesión Google
    private ImageButton googleSignInButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toast.makeText(Signup.this, "Firebase conectado", Toast.LENGTH_LONG).show();
        txtEmail = (EditText) findViewById(R.id.email_txt);
        txtPassword = (EditText) findViewById(R.id.psw_txt);
        txtUsername = (EditText) findViewById(R.id.username_txt);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        login = (Button) findViewById(R.id.login_signup_btn);
        signup = (Button) findViewById(R.id.signup_signup_btn);
        googleSignInButton = (ImageButton) findViewById(R.id.google_signup_btn);
        fb = (ImageButton) findViewById(R.id.fb_signup_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String username = txtUsername.getText().toString().trim();
                //usuario = new User(username, email);

                if (TextUtils.isEmpty(email)) {
                    txtEmail.setError("Es necesario introducir un email.");
                }

                // Mirar si email tiene formato de email
                Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)(\\.[A-Za-z]{2,})$");
                Matcher mEmail = patronEmail.matcher(email.toLowerCase());
                if (!mEmail.find()) {
                    txtEmail.setError("Email no válido.");
                }

                if (TextUtils.isEmpty(password)) {
                    txtPassword.setError("Es necesario introducir un password.");
                }

                // Comprovación contraseña tiene mayúscula, minñuscula y número
                char clave;
                byte contNumero = 0, contLetraMay = 0, contLetraMin = 0;
                for (byte i = 0; i < password.length(); i++) {
                    clave = password.charAt(i);
                    String passValue = String.valueOf(clave);
                    if (passValue.matches("[A-Z]")) {
                        contLetraMay++;
                    } else if (passValue.matches("[a-z]")) {
                        contLetraMin++;
                    } else if (passValue.matches("[0-9]")) {
                        contNumero++;
                    }
                }

                if (password.length() < 8) {
                    txtPassword.setError("Mínimo 8 caracteres.");
                }

                if (contLetraMay < 1 || contLetraMin < 1 || contNumero < 1) {
                    txtPassword.setError("Debe contener una mayúscula, minúscula y número.");
                } else {

                    fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Signup.this, "Usuario creado", Toast.LENGTH_SHORT).show();
                                userID = fAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = fStore.collection("Usuario").document(userID);
                                Map<String, Object> usuario = new HashMap<>();
                                usuario.put("Username", username);
                                usuario.put("Email", email);
                                usuario.put("Password", password);
                                documentReference.set(usuario).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "onSuccess: user profile is created for " + userID);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.d(TAG, "onFailure " + e.toString());
                                    }
                                });
                                System.out.println("new intent");
                                startActivity(new Intent(getApplicationContext(), UserTypeChoosing.class));
                            } else {
                                Toast.makeText(Signup.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        // Google
        googleSignInButton = findViewById(R.id.google_signup_btn);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


    }

}
