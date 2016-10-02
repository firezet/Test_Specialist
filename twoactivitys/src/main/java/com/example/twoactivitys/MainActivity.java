package com.example.twoactivitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    static final String EXTRA_USER_NAME = "USER_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        EditText input = (EditText) findViewById(R.id.field_for_name);
        String userName = input.getText().toString().trim();

        if (userName.length() > 0) {
            Intent myIntent = new Intent(this, SecondActivity.class);
            myIntent.putExtra(EXTRA_USER_NAME, userName);
            startActivity(myIntent);
        }

        input.setText(null);
    }
}

