package com.example.metropicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final int CHOOSE_STATION = 1;

    public void Select_The_Station(View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivityForResult(intent, CHOOSE_STATION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView stationResult = (TextView) findViewById(R.id.selected_station);
        stationResult.setVisibility(View.VISIBLE);

        if ( resultCode == RESULT_OK ) {
            stationResult.setText(data.getStringExtra("SelectedStation"));
        } else {
            Toast.makeText(this, "Not selected station", Toast.LENGTH_SHORT).show();
            stationResult.setText("Not selected station");
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
