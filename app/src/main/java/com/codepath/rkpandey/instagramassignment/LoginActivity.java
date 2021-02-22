package com.codepath.rkpandey.instagramassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import java.text.ParseException;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText etusername;
    private EditText etpassword;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ParseUser.getCurrentUser() != null){
            goMainActivity();

        }



        etusername = findViewById(R.id.etusername);
        etpassword = findViewById(R.id.etpassword);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            //String User_name;
            //String Pass_word;


            @Override
            public void onClick(View v) {
                Log.i(TAG, "On click Button");
                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();
                loginUser(username, password);
            }

        });

    }
    private void loginUser(String username, String password) {
        Log.i(TAG, " Attempting to login user" + username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, com.parse.ParseException e) {

                if (e != null) {
                    Log.e(TAG, "Issuse with login", e);
                    Toast.makeText(LoginActivity.this, "Issue with login!!", Toast.LENGTH_SHORT).show();

                    return;
                }
                goMainActivity();
                Toast.makeText(LoginActivity.this, "Success!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void goMainActivity() {
        // private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
     //   finish();
    }
}