package com.example.note;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

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

    @Override
    protected void onStart () {
        super.onStart ();

    }

    // открытие базы данных не делать в onCreate, ибо она будет задерживать загрузку приложения.
    // create db
    @Override
    protected void onResume () {
        super.onResume ();
        showNotes ();
    }

    private void showNotes () {
        // add a check because we are have the same in onOkButtonClick()
        mSQLiteDb = (mSQLiteDb == null) ? mDBOpenHelper.getWritableDatabase () : mSQLiteDb;
        Cursor cursor = mSQLiteDb.query (DBOpenHelper.TABLE_NAME,
                FIELDS,
                null, null, null, null,
                ORDER);
        // создаёт новый курсор, старый убивается адаптером.
        mSimpleCursorAdapter.swapCursor (cursor);
    }

    public void onOkButtonClick (View view) {
        String newNote = mInputField.getText ().toString ().trim ();
        if ( newNote.length () > 0 ) {
            ContentValues values = new ContentValues (1);
            values.put (DBOpenHelper.COLUMN_NOTE, newNote);
            mSQLiteDb = mDBOpenHelper.getWritableDatabase ();
            mSQLiteDb.insert (DBOpenHelper.TABLE_NAME, null, values);
            showNotes ();
        }
        mInputField.setText (null);
    }

    @Override
    protected void onStop () {
        super.onStop ();
        if (mSQLiteDb != null) {
            mSQLiteDb.close ();
            mSQLiteDb = null;
            Toast.makeText (this, "DB closed", Toast.LENGTH_SHORT).show ();
        }
        Toast.makeText (this, "onStop", Toast.LENGTH_SHORT).show ();
    }
}
