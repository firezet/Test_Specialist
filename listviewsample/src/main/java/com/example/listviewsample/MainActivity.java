package com.example.listviewsample;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        Resources res = getResources ();
        String[] arrayStations = res.getStringArray (R.array.stations);

        ArrayAdapter <String> arrayAdapter = new ArrayAdapter <> (this,
                R.layout.list_item, arrayStations);

        getListView ().setAdapter (arrayAdapter);
        getListView ().setOnItemClickListener (this);


    }

    @Override
    public void onItemClick (AdapterView <?> adapterView, View view, int position, long l) {
        Toast.makeText (this, ( (TextView) view ).getText () + " p" + String.valueOf (position), Toast.LENGTH_SHORT).show ();
    }
}
