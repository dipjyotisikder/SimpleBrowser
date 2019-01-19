package com.example.dipjyoti.browser;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText emailText,passwordText;
    private Button signinButton,signupButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailText = (EditText) findViewById(R.id.emailBox);
        passwordText = (EditText) findViewById(R.id.passwordBox);
        signinButton = (Button) findViewById(R.id.signinbtn);
        signupButton = (Button) findViewById(R.id.signupbtn);



        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = "";
                String email = "";
                String password="";

                DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext(), "userAuthData.db", null,2);
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String[] columns = {"name","email","password"};
                Cursor c = db.query("userAuth", columns, null, null, null, null, null);
                while(c.moveToNext())
                {
                    username = c.getString(0);
                    email = c.getString(1);
                    password=c.getString(2);
                }

                if (email.toString().isEmpty()||password.toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "You are not Registered yet." , Toast.LENGTH_SHORT).show();

                }
                else if (emailText.getText().toString().toLowerCase().equals(email) && passwordText.getText().toString().equals(password)){
                    Toast.makeText(getApplicationContext(),"Welcome! You are logged in!",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, BrowserActivityHomePage.class);
                    startActivity(i);
                }

                else if(!email.toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Username And Password Error!",Toast.LENGTH_SHORT).show();
                }

//                else if(!email.toString().isEmpty()){
//
//                    if (!email.toString().equals(email) ){
//                        Toast.makeText(getApplicationContext(),"Username does not exist!",Toast.LENGTH_SHORT).show();
//                    }
//
//                    else if (email.toString().equals(email)  &&  !(password.toString().equals(password)) ){
//                        Toast.makeText(getApplicationContext(),"Password does not match!",Toast.LENGTH_SHORT).show();
//                    }
//
//                }

            }
        });


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
            }
        });

    }

}