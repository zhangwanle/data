package com.example.wanle.jishiben;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDBHelper {

    private String db_name = "data1";
    private int db_version = 1;
    private myHelper helper;
    private SQLiteDatabase db;
    private Context ctx = null;
    private String DB_TITLE = "title";
    private String DB_CONTENT = "content";
    private String DB_ID = "_id";
    private String table = "user";

    MyDBHelper(Context ctx){
        this.ctx = ctx;
    }

    public MyDBHelper open(){
        helper = new myHelper(ctx,db_name,null,db_version);
        db = helper.getWritableDatabase();
        return this;
    }

    public void close(){
        db.close();
    }

    public int createNote(String title,String content){
        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("content",content);
        int rowid = (int)db.insert(table,null,values);
        return rowid;
    }

    public Boolean updateNote(Long rowid,String title,String content){
        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("content",content);
        int id = db.update(table,values,DB_ID+"="+rowid,null);
        return id>0;
    }

    public Boolean deleteNote(Long rowid){
        int id = db.delete(table,DB_ID+"="+rowid,null);
        return id>0;
    }

    public Cursor retrieveAllNotes(){
        Cursor cur = db.query(table,null,null,null,null,null,null,null);
        return cur;
    }

    public List<UserBean> getAllNotes(){
        Cursor c = retrieveAllNotes();
        ArrayList<UserBean> itemList = new ArrayList<>();
        while (c.moveToNext()){
            UserBean item = new UserBean();
            item.setTitle(c.getString(c.getColumnIndex(DB_TITLE)));
            item.setContent(c.getString(c.getColumnIndex(DB_CONTENT)));
            item.setId(c.getInt(c.getColumnIndex(DB_ID)));
            itemList.add(item);

        }
        return itemList;
    }

}
