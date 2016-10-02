package com.example.relativelayoutsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText editTextBox = (EditText) findViewById(R.id.edit_text_box);
        switch (view.getId()) {
            case R.id.ok_button:
                String text = editTextBox.getText().toString().trim();
                if (text.length() > 0)
                    Toast.makeText(this, "Hello, " + text, Toast.LENGTH_SHORT).show();
                editTextBox.setText(null);
                break;

            case R.id.cancel_button:
                editTextBox.setText(null);
                break;

            default:
                Toast.makeText(this, "OOPS, something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

}
