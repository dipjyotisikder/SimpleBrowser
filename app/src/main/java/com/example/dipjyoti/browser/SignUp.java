package com.example.dipjyoti.browser;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private EditText name,email,password;
    private Button signupButton;
    public DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = (EditText) findViewById(R.id.signupNameBox);
        email = (EditText) findViewById(R.id.signupEmailBox);
        password = (EditText) findViewById(R.id.signupPasswordBox);
        signupButton = (Button) findViewById(R.id.signupBtn);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().isEmpty()|| email.getText().toString().isEmpty()||password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please fill all the fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseHelper = new DatabaseHelper(getApplicationContext(), "userAuthData.db", null,2);
                    SQLiteDatabase db = databaseHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("name", name.getText().toString());
                    values.put("email", email.getText().toString());
                    values.put("password", password.getText().toString());
                    long data = db.insert("userAuth",null, values);
                    Toast.makeText(getApplicationContext(),"You are succesfully registered and database index is : " +data+ " ",Toast.LENGTH_LONG).show();
                    Intent in = new Intent(SignUp.this, MainActivity.class);
                    startActivity(in);
                }
            }
        });
    }
}
