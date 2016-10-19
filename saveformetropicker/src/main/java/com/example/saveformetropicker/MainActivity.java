package com.example.saveformetropicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final short STATION_SELECT = 1;
    private int mSelectedRadioButton = 0;

    Storage mStorage;
    RadioGroup mRadioGroup;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        mStorage = new Storage (this);

        mRadioGroup = (RadioGroup) findViewById (R.id.radio_button_group);
    }

    public void ButtonSelectTheStation (View view) {
        Intent intent = new Intent (this, StationList.class);
        if ( mSelectedRadioButton == R.id.rbutton_holodnogorskaya
                || mSelectedRadioButton == 0 )
            intent.putExtra ("RQ", 1);

        if ( mSelectedRadioButton == R.id.rbutton_alekseevskaya )
            intent.putExtra ("RQ", 2);

        if ( mSelectedRadioButton == R.id.rbutton_saltovskaya )
            intent.putExtra ("RQ", 3);

        if ( intent.resolveActivity (getPackageManager ()) != null )
            startActivityForResult (intent, STATION_SELECT);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if ( resultCode == RESULT_OK ) {
            String stationNameResult = data.getStringExtra ("ResultIntent");
            ( (TextView) findViewById (R.id.selected_station_text_show) )
                    .setText (stationNameResult);

            mStorage.savePrefs (data);
        } else {
            super.onActivityResult (requestCode, resultCode, data);
            Toast.makeText (this, "Station is not selected", Toast.LENGTH_SHORT).show ();

            mStorage.savePrefs (null);
        }
    }

    public void ButtonLastStationLoad (View view) {
        TextView fieldWithSelectedStation = (TextView) findViewById (R.id.selected_station_text_show);
        mStorage.loadStationField (fieldWithSelectedStation);
        mStorage.loadRadioButton (mRadioGroup);
    }

    public void onRButtonClicked (View view) {
        RadioButton radioButton = (RadioButton) view;
        mSelectedRadioButton = radioButton.getId ();
        Toast.makeText (this, radioButton.getText (), Toast.LENGTH_SHORT).show ();

        // save part
        mStorage.saveRadioButton (mRadioGroup.indexOfChild (radioButton));
    }

    @Override
    protected void onDestroy () {
        super.onDestroy ();
        Toast.makeText (this, "onDestroy", Toast.LENGTH_SHORT).show ();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        super.onCreateOptionsMenu (menu);
        MenuInflater inflater = getMenuInflater ();
        inflater.inflate (R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch ( item.getItemId () ) {
            case R.id.item_clear:
                ((TextView) findViewById (R.id.selected_station_text_show))
                        .setText (R.string.selected_station_text_show);
                return true;

            case R.id.item_exit:
                finish ();
                return true;
        }
        return super.onOptionsItemSelected (item); // возвращаем если сами не сможем обработать
    }
}