package com.example.saveformetropicker;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class StationList extends ListActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int requestCode = 1;
        requestCode = intent.getIntExtra("RQ", requestCode);

        String [] arrayStation;

        switch (requestCode) {
            case 2: arrayStation = getResources().getStringArray(R.array.alekseevskaya);
                    ArrayAdapter <String> arrayAdapterAleks = new ArrayAdapter<>(this,
                            R.layout.station_list_view,
                            arrayStation);

                    getListView().setAdapter(arrayAdapterAleks);
                    getListView().setOnItemClickListener(this);
                    break;

            case 3: arrayStation = getResources().getStringArray(R.array.saltovskaya);
                    ArrayAdapter <String> arrayAdapterSalt = new ArrayAdapter<>(this,
                            R.layout.station_list_view,
                            arrayStation);

                    getListView().setAdapter(arrayAdapterSalt);
                    getListView().setOnItemClickListener(this);
                    break;


            default: arrayStation = getResources().getStringArray(R.array.holodnogorskaya);
                    ArrayAdapter <String> arrayAdapterHol = new ArrayAdapter<>(this,
                            R.layout.station_list_view,
                            arrayStation);

                    getListView().setAdapter(arrayAdapterHol);
                    getListView().setOnItemClickListener(this);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int lineNumber, long l) {
        Toast.makeText(this, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
        Intent backIntent = new Intent();
        backIntent.putExtra("ResultIntent", ((TextView) view).getText());
        setResult(RESULT_OK, backIntent);
        finish();
    }
}
