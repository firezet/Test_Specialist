package com.example.note;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    EditText mInputField;
    ListView mNotesList;

    SimpleCursorAdapter mSimpleCursorAdapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        mInputField = (EditText) findViewById (R.id.inputField);
        mNotesList = (ListView) findViewById (R.id.notesList);
    }

    public void onOkButtonClick (View view) {
    }
}
