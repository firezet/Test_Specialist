package com.example.note;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

    long mNoteId = -1;
    private String mOldNote = null;

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
        registerForContextMenu (mNotesList);
        registerForContextMenu (mInputField);
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu (menu, v, menuInfo);

        switch ( v.getId () ) {
            case R.id.notesList:
                MenuInflater inflaterDB = getMenuInflater ();
                inflaterDB.inflate (R.menu.notes_menu, menu);
                menu.setHeaderTitle ("DB Action");
                break;
            case R.id.inputField:
                MenuInflater inflaterET = getMenuInflater ();
                inflaterET.inflate (R.menu.edit_text_menu, menu);
                menu.setHeaderTitle ("EditText");
                break;
            default:
                Toast.makeText (this, "oops", Toast.LENGTH_SHORT).show ();
        }
    }

    @Override
    public boolean onContextItemSelected (MenuItem item) {
        switch ( item.getItemId () ) {
            case R.id.item_edit:
                AdapterView.AdapterContextMenuInfo info =
                        ( AdapterView.AdapterContextMenuInfo) item
                                .getMenuInfo ();
                mOldNote = getNoteById (info.id);   // save for future use
                mInputField.setText (mOldNote);     // fill in input field
                mNoteId = info.id;                  // save for future use
                return true;
            case R.id.item_delete:
                AdapterView.AdapterContextMenuInfo info2 =
                        ( AdapterView.AdapterContextMenuInfo) item
                            .getMenuInfo ();
                deleteNote(info2.id);
                showNotes ();
                return true;
            default:
                return super.onContextItemSelected (item);
        }
    }

    private String getNoteById (long id) {
        mSQLiteDb = (mSQLiteDb == null) ? mDBOpenHelper.getWritableDatabase () : mSQLiteDb;
        Cursor c = mSQLiteDb.query (DBOpenHelper.TABLE_NAME, FIELDS, "_id = " + id,
                null, null, null, null);
        String note = null;
        if ( c != null) {
            note = c.getString (
                    c.getColumnIndexOrThrow (DBOpenHelper.COLUMN_NOTE));
            c.close ();
        }
        return note;
    }

    private void deleteNote (long id) {
        mSQLiteDb = (mSQLiteDb == null) ? mDBOpenHelper.getWritableDatabase () : mSQLiteDb;
        mSQLiteDb.delete (DBOpenHelper.TABLE_NAME, "_id = " + id, null);
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
