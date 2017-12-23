package com.example.admin.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class MyContentProvider extends ContentProvider {
    private CBankHelper cBankHelper;

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        ContentValues cv=new ContentValues();
        cv.put("userName",selectionArgs[0]);
        return cBankHelper.delete(cv);
    }

    @Override
    public String getType(Uri uri) {
        // at the given URI.
        return "test";
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        cBankHelper.insert(values);
        return uri;
    }

    @Override
    public boolean onCreate() {
        cBankHelper = new CBankHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        return cBankHelper.query(selectionArgs[0]);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return cBankHelper.update(values);
    }
    public Cursor queryAll(Uri uri){
        return cBankHelper.queryAll();
    }
}
