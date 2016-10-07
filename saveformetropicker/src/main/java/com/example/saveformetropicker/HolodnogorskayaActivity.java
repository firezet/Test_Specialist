package com.example.saveformetropicker;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
