package com.example.twoactivitys;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent myIntent = getIntent();

        String userName = myIntent.getStringExtra(MainActivity.EXTRA_USER_NAME);

        userName = (userName == null) ? "Unknown" : userName;

        ((TextView) findViewById(R.id.greeting))
                .setText(getText(R.string.hello_text) + " " + userName + "!");
    }

    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:(066)680-82-64"));
        // test is device not table
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "no sim found", Toast.LENGTH_SHORT).show();
        }
    }
}
