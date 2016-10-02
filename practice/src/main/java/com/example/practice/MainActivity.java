package com.example.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserName = (EditText) findViewById(R.id.edit_box_field);
    }

    public void onClick(View view) {
        /*if (view == findViewById(R.id.ok_button))
        {
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        }*/

    }
}
