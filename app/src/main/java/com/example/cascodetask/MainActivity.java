package com.example.cascodetask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView alreadyacc;
    EditText input_username,input_email,input_password,input_re_password;

    MaterialButton regbtn;
    String email_pattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_username= findViewById(R.id.username);
        input_email=findViewById(R.id.email);
        input_password=findViewById(R.id.password);
        input_re_password=findViewById(R.id.repassword);
        alreadyacc=findViewById(R.id.alreadyacc);
        regbtn=findViewById(R.id.signupbtn);
        progressDialog= new ProgressDialog(this);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perForAuth();
            }
        });


    }

    private void perForAuth() {
        String username=input_username.getText().toString();
        String email=input_email.getText().toString();
        String password=input_password.getText().toString();
        String re_password=input_re_password.getText().toString();
        if (!email.matches(email_pattern))
        {
            input_email.setError("Enter Correct Email!");
        }
        else if(password.isEmpty()||password.length()<6)
        {
            input_password.setError("Enter Proper Password");
        } else if(!password.equals(re_password))
        {
            input_re_password.setError("Password not match both field");
        }
        else {
            progressDialog.setMessage("Please wait while Registration.....");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            sendUserToNextActivity();

        }

    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(MainActivity.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }
}