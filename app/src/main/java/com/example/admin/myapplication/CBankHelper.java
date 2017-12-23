package com.example.admin.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by admin on 2017/12/23.
 */

public class CBankHelper extends SQLiteOpenHelper {
    private Context context;
    private SQLiteDatabase db;
    private String tableName = "userList";
    private final static String CREATE_TBL = "create table userList (_id integer, userName text primary key , openBank text)";

    public CBankHelper(Context context) {
        super(context, "bankHelper", null, 1);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(CREATE_TBL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
    }

    public void insert(ContentValues value) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(tableName, null, value);
        Log.d("test", "insert ok");
        db.close();
    }

    public Cursor query(String value) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(tableName, null, "userName = ?", new String[]{value}, null, null, null, null);
        return cursor;
    }

    public int update(ContentValues value) {
        SQLiteDatabase db = getWritableDatabase();
        return db.update(tableName, value, "userName = ?", new String[]{value.get("userName").toString()});
    }

    public int delete(ContentValues value) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(tableName, "userName = ?", new String[]{value.get("userName").toString()});
    }

    public Cursor queryAll() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(tableName, null, null, null, null, null, null);
        return cursor;
    }
}
