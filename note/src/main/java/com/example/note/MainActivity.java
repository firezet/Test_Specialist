package com.example.note;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String[] FIELDS = {"_id", DBOpenHelper.COLUMN_NOTE,};
    private static final String[] FROM = {DBOpenHelper.COLUMN_NOTE,};
    private static final int[] TO = {R.id.noteTextView,};
    private static final java.lang.String ORDER = "_id DESC";


    EditText mInputField;
    ListView mNotesList;

    DBOpenHelper mDBOpenHelper = new DBOpenHelper (this);
    SQLiteDatabase mDB;

    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        mInputField = (EditText) findViewById (R.id.inputField);
        mNotesList = (ListView) findViewById (R.id.notesList);
        mAdapter = new SimpleCursorAdapter (this, R.layout.note,
                null, FROM, TO, 0);
        mNotesList.setAdapter (mAdapter);
    }

    @Override
    protected void onResume () {
        super.onResume ();
        mDB = mDBOpenHelper.getWritableDatabase ();
        Cursor cursor = mDB.query (mDBOpenHelper.DB_TABLE,
                FIELDS,
                null, null, null, null,
                ORDER);
        mAdapter.swapCursor (cursor);
    }

    public void onButtonClick (View view) {
    }
}
