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
        switch (view.getId())
        {
            case R.id.ok_button:
                String text = mUserName.getText().toString().trim();
                if (text.length() > 0)
                    Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
                mUserName.setText(null);
                break;
            case R.id.cancel_button:
                mUserName.setText(null);
                break;
            default:
                Toast.makeText(this, "unknown command", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
