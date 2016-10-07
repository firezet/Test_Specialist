package com.example.saveformetropicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int SELECT_STATION_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ButtonSelectTheStation(View view) {
        Intent intent = new Intent(this, HolodnogorskayaActivity.class);

        startActivityForResult(intent, SELECT_STATION_REQUEST);
    }
}
