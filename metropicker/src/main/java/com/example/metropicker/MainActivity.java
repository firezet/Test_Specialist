package com.example.metropicker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CHOOSE_STATION = 1;
    public static final String PICK_METRO_STATION =
            "com.example.metropicker.intent.action.PICK_METRO_STATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Create Main", Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        Toast.makeText(this, intent.getAction(), Toast.LENGTH_SHORT).show();
    }

     public void CallTo(View view) {
        Intent callToIntent = new Intent(Intent.ACTION_DIAL
                , Uri.parse("tel: (067) 573 20 05"));
        startActivity(callToIntent);
    }

    public void intentAction(View view) {
        Intent intentByAction = new Intent(PICK_METRO_STATION);
        if ( intentByAction.resolveActivity(getPackageManager()) != null ) {
            startActivityForResult(intentByAction, CHOOSE_STATION);
        } else {
            Toast.makeText(this, "No activity for action", Toast.LENGTH_SHORT).show();
        }
    }

    public void Select_The_Station(View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivityForResult(intent, CHOOSE_STATION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView stationResult = (TextView) findViewById(R.id.selected_station);
        stationResult.setVisibility(View.VISIBLE);

        if ( resultCode == RESULT_OK ) {
            stationResult.setText(data.getStringExtra("SELECTED_STATION"));
        } else {
            Toast.makeText(this, "Not selected station", Toast.LENGTH_SHORT).show();
            stationResult.setText("Not selected station");
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    protected void onStart() {
        Toast.makeText(this, "Start Main", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "Pause Main", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(this, "Restart Main", Toast.LENGTH_SHORT).show();
        super.onRestart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "Stop Main", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "Destroy Main", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
