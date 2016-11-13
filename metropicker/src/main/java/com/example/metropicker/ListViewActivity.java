package com.example.metropicker;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private static final String EXTRA_SELECTED_STATION = "SELECTED_STATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources resources = getResources();
        String [] arrayStations = resources.getStringArray(R.array.stations);

        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<>(this,
                R.layout.list_item, arrayStations);

        getListView().setAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);

        Intent intent = getIntent();
        Toast.makeText(this, intent.getAction(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intentResult = new Intent();
        intentResult.putExtra(EXTRA_SELECTED_STATION, ((TextView) view).getText().toString());

        setResult(RESULT_OK, intentResult);
        finish();
    }

}
