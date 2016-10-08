package com.example.saveformetropicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int HOLODNOGORSKAYA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ButtonSelectTheStation(View view) {
        //Intent intent = new Intent(this, HolodnogorskayaActivity.class);
        Intent intent = new Intent(this, StationList.class);
        intent.putExtra("RQ", 1);
        if ( intent.resolveActivity(getPackageManager()) != null )
            startActivityForResult(intent, HOLODNOGORSKAYA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
