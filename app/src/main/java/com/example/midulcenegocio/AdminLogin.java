package com.example.midulcenegocio;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
//Admin login with email, password and admin code
public class AdminLogin extends AppCompatActivity {

    private Button btnAdmLogin;
    private Button btnAdmRegister;
    private EditText edtAdmEmail;
    private EditText edtAdmPassword;
    private EditText edtAdmCode;
    private FirebaseAuth fAuth;
    private String role="Admin";
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        btnAdmLogin = (Button) findViewById(R.id.btnAdmLogin);
        btnAdmRegister = (Button) findViewById(R.id.btnAdmRegister);
        edtAdmEmail = (EditText) findViewById(R.id.edtAdmEmail);
        edtAdmPassword = (EditText) findViewById(R.id.edtAdmPassword);
        edtAdmCode = (EditText) findViewById(R.id.edtAdmCode);
        fAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getInstance().getReference("Admin");

        btnAdmLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAdmin(edtAdmEmail.getText().toString(), edtAdmPassword.getText().toString(), edtAdmCode.getText().toString());
            }
        });

        btnAdmRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAdmin(edtAdmEmail.getText().toString(), edtAdmPassword.getText().toString(), edtAdmCode.getText().toString());
            }
        });
    }

    private void loginAdmin(String email, String password, String code) {
        int value=0;
        if (!"".equals(code)) {
            value = Integer.parseInt(code);
        }
        if (value == 5963) {
                fAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("TAG", "signInWithEmail:success");
                                    FirebaseUser user = fAuth.getCurrentUser();
                                    Toast.makeText(AdminLogin.this, "Login success", Toast.LENGTH_SHORT).show();

                                    openMenuActivity();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("TAG", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
            else {
                Toast.makeText(getApplicationContext(), "Wrong Code",
                        Toast.LENGTH_SHORT).show();
            }
        }

    private void addAdmin(String email, String password, String code) {
        int value=0;
        if (!"".equals(code)) {
            value = Integer.parseInt(code);
        }
        if (value == 5963) {
            fAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("TAG", "createUserWithEmail:success");

                                String useridd = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                databaseReference = FirebaseDatabase.getInstance().getReference("User").child(useridd);
                                final HashMap<String , String> hashMap = new HashMap<>();
                                hashMap.put("Role",role);
                                databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        HashMap<String, String> hashMap1 = new HashMap<>();
                                        hashMap1.put("Email", email);
                                        hashMap1.put("Password", password);
                                    }
                                });
                                //FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(AdminLogin.this, "New account created with success", Toast.LENGTH_SHORT).show();

                                openMenuActivity();

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(getApplicationContext(), "Wrong Code",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }
        else {
            // If sign in fails, display a message to the user.
            Toast.makeText(getApplicationContext(), "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    private void openMenuActivity() {

        Intent intent = new Intent(getApplicationContext(), AdminMenu.class);
        startActivity(intent);
        finish();
    }
}