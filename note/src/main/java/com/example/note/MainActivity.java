package com.example.note;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String[] FIELDS = {"_id", DBOpenHelper.COLUMN_NOTE,};//fields to show
    private static final String[] FROM = {DBOpenHelper.COLUMN_NOTE,};//name of field
    private static final int[] TO = {R.id.noteTextView,};
    private static final java.lang.String ORDER = "_id DESC";

    EditText mInputField;
    ListView mNotesList;

    DBOpenHelper mDBOpenHelper = new DBOpenHelper (this);
    SQLiteDatabase mSQLiteDb;

    SimpleCursorAdapter mSimpleCursorAdapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        mInputField = (EditText) findViewById (R.id.inputField);
        mNotesList = (ListView) findViewById (R.id.notesList);
        mSimpleCursorAdapter = new SimpleCursorAdapter (this,
                R.layout.note_layout,
                null,
                FROM, TO,
                0);
        mNotesList.setAdapter (mSimpleCursorAdapter);
    }

    // открытие базы данных не делать в onCreate, ибо она будет задерживать загрузку приложения.
    // create db
    @Override
    protected void onResume () {
        super.onResume ();
        mSQLiteDb = mDBOpenHelper.getWritableDatabase ();
        Cursor cursor = mSQLiteDb.query (DBOpenHelper.DB_TABLE,
                FIELDS,
                null, null, null, null,
                ORDER);
        // создаёт новый курсор, старый убивается адаптером.
        mSimpleCursorAdapter.swapCursor (cursor);
    }

    public void onOkButtonClick (View view) {
    }
}
