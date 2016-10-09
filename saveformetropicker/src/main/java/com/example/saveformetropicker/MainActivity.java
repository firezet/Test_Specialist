package com.example.saveformetropicker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final short STATION_SELECT = 1;
    private int mSelectedRadioButton = 0;

    private static final String PREFS = "PREFS";
    static final String KEY_STATION = "selectedStation";

    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ButtonSelectTheStation(View view) {
        Intent intent = new Intent(this, StationList.class);
        if ( mSelectedRadioButton == R.id.rbutton_holodnogorskaya
                || mSelectedRadioButton == 0)
            intent.putExtra("RQ", 1);

        if ( mSelectedRadioButton == R.id.rbutton_alekseevskaya )
            intent.putExtra("RQ", 2);

        if ( mSelectedRadioButton == R.id.rbutton_saltovskaya )
            intent.putExtra("RQ", 3);

        if ( intent.resolveActivity(getPackageManager()) != null )
            startActivityForResult(intent, STATION_SELECT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        SharedPreferences.Editor editor = prefs.edit();

        if ( resultCode == RESULT_OK) {
            String stationNameResult = data.getStringExtra("ResultIntent");
            ((TextView) findViewById(R.id.selected_station_text_show))
                .setText(stationNameResult);

            prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
            editor.putString(KEY_STATION,stationNameResult);
            editor.apply();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
            Toast.makeText(this, "Station is not selected", Toast.LENGTH_SHORT).show();
            editor.remove(KEY_STATION);
            editor.apply();
        }
    }

    public void ButtonLastStationLoad (View view) {
        prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        String selectedStation = prefs.getString(KEY_STATION, null);
        if ( selectedStation != null ) {
            ((TextView) findViewById(R.id.selected_station_text_show))
                    .setText(selectedStation);
            Toast.makeText(this, "restored from prefs", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, selectedStation, Toast.LENGTH_SHORT).show();
        } else {
            ((TextView) findViewById(R.id.selected_station_text_show))
                    .setText("no saved stations");
        }
    }

    public void onRButtonClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        mSelectedRadioButton = radioButton.getId();
        Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}
