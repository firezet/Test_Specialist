package com.example.metropicker;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends ListActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources resources = getResources();
        String [] arrayStations = resources.getStringArray(R.array.stations);

        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.list_item, arrayStations);

        getListView().setAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intentResult = new Intent();
        intentResult.putExtra("SelectedStation", ((TextView) view).getText().toString());

        setResult(RESULT_OK, intentResult);
        finish();
    }
}
