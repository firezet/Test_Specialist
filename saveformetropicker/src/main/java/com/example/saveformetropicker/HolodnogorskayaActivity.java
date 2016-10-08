package com.example.saveformetropicker;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class HolodnogorskayaActivity extends ListActivity
        implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String [] arrayHolodnogorskaya = getResources().getStringArray(R.array.holodnogorskaya);

        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<>(this
                ,R.layout.station_list_view, arrayHolodnogorskaya);

        getListView().setAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int stringNumber, long l) {
        Toast.makeText(this, stringNumber, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("Station", ( ((TextView) view).getText()).toString() );
        setResult(RESULT_OK, intent);
        finish();
    }
}
