package com.example.maksym.specialist;

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

    public void Clear_EditText_box(View view) {
        ((EditText) findViewById(R.id.edit_box)).setText(null);
        Toast.makeText(this, "field is cleared", Toast.LENGTH_SHORT).show();
    }

    public void Show_text_from_EditText(View view) {
        Toast.makeText(this, ((EditText)view).getText(), Toast.LENGTH_SHORT).show();
    }

    public void Show_and_Clear_EditText(View view) {
        Toast.makeText(this, ((EditText)view).getText(), Toast.LENGTH_SHORT).show();
        ((EditText) findViewById(R.id.edit_box)).setText(null);
    }
}
