package com.eylem.instaclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    EditText emailText,passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth=FirebaseAuth.getInstance();
        emailText=findViewById(R.id.emailText);
        passwordText=findViewById(R.id.passwordText);

        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user!=null){
            Intent intent=new Intent(LoginActivity.this,FeedActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void signinClicked(View view){
        String email=emailText.getText().toString();
        String password=passwordText.getText().toString();

        if(email.matches("")){
            Toast.makeText(LoginActivity.this,"Email boş bırakılamaz!",Toast.LENGTH_LONG).show();
            //email boş bırakılmışsa hata mesajı göster
        }
        else if(password.matches("")){
            Toast.makeText(LoginActivity.this,"Password boş bırakılamaz!",Toast.LENGTH_LONG).show();
            //password boş bırakılmışsa hata mesajı göster
        }

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent=new Intent(LoginActivity.this,FeedActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    public void signupClicked(View view){
        String email=emailText.getText().toString();
        String password=passwordText.getText().toString();

        if(email.matches("")){
            Toast.makeText(LoginActivity.this,"Email boş bırakılamaz!",Toast.LENGTH_LONG).show();
            //email boş bırakılmışsa hata mesajı göster
        }
        else if(password.matches("")){
            Toast.makeText(LoginActivity.this,"Password boş bırakılamaz!",Toast.LENGTH_LONG).show();
            //password boş bırakılmışsa hata mesajı göster
        }

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this,"User Created Successfully!",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(LoginActivity.this,FeedActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
