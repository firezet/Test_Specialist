package com.example.note;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Maksym Galushka on 26.10.2016.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "notes.db";
    static final String DB_TABLE = "notes";
    static final String COLUMN_NOTE = "note";
    static final int DB_VERSION = 1;

    private static final String DB_CREATE = "CREATE TABLE "
            + DB_TABLE + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NOTE + " TEXT NOT NULL);";

    Context mContext;

    public DBOpenHelper (Context context) {
        super (context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL (DB_CREATE);

        // TODO DELETE AFTER DEBUGGING
        ContentValues values = new ContentValues (1);
        for ( int i = 1; i <= 5; i++ ) {
            values.put (COLUMN_NOTE, "Note #" + i);
            /*
             *  SQLite не может хранить в таблицах поля, которые все null
             *  about null: обработчик для ситуации, когда все поля null
             *  в этом проекте идентификатор всегда есть, не важно есть заметка или нет
             *  пожтому мы может проигнорировать это поставив null
             */
            db.insert (DB_TABLE, null, values);
        }
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
