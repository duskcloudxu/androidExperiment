package com.example.admin.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/12/23.
 */

public class CBankDeal {
    private CBankHelper cBankHelper;
    private Context context;

    public CBankDeal(Context context) {
        this.context = context;
        this.cBankHelper = new CBankHelper(context);
    }

    public void insert(CBankAccount cBankAccount) {
        ContentValues cv=new ContentValues();
        cv.put("_id",cBankAccount._id);
        cv.put("userName",cBankAccount.userName);
        cv.put("openBank",cBankAccount.OpenBank);
        cBankHelper.insert(cv);
    }
    public ArrayList<CBankAccount> query(String name) {
        Cursor c = cBankHelper.query(name);
        ArrayList<CBankAccount> list = new ArrayList<>();
        while (c.moveToNext()) {
            CBankAccount temp = new CBankAccount();
            temp._id = c.getInt(c.getColumnIndex("_id"));
            temp.userName = c.getString(c.getColumnIndex("userName"));
            temp.OpenBank = c.getString(c.getColumnIndex("openBank"));
            list.add(temp);
        }
        return list;
    }
    public int update(CBankAccount cBankAccount){
        ContentValues cv=new ContentValues();
        cv.put("_id",cBankAccount._id);
        cv.put("userName",cBankAccount.userName);
        cv.put("openBank",cBankAccount.OpenBank);
        return cBankHelper.update(cv);
    }
    public int delete(CBankAccount cBankAccount){
        ContentValues cv=new ContentValues();
        cv.put("_id",cBankAccount._id);
        cv.put("userName",cBankAccount.userName);
        cv.put("openBank",cBankAccount.OpenBank);
        return cBankHelper.delete(cv);
    }
    public ArrayList<CBankAccount> showAll() {
        Cursor c = cBankHelper.queryAll();
        ArrayList<CBankAccount> list = new ArrayList<>();
        while (c.moveToNext()) {
            CBankAccount temp = new CBankAccount();
            temp._id = c.getInt(c.getColumnIndex("_id"));
            temp.userName = c.getString(c.getColumnIndex("userName"));
            temp.OpenBank = c.getString(c.getColumnIndex("openBank"));
            list.add(temp);
        }
        return list;
    }
}
