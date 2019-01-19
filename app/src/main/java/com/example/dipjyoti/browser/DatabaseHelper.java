package com.example.dipjyoti.browser;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABSE_NAME = "bookmark.db";
    private static final String TABLE_NAME_URL = "urlTable";
//    DatabaseHelper(Context c){
//
//        super(c, DATABSE_NAME, null, 3);
//    }





    private static final String SQL_CREATE_TABLE = "CREATE TABLE userAuth(name text, email text, password text);";
    private static final String SQL_CREATE_URL_TABLE = "CREATE TABLE "+TABLE_NAME_URL+" (generalUrl text, originalUrl text);";

//String s = "CREATE TABLE "+TABLE_NAME+" ("+TAB_ID+" INTEGER PRIMARY KEY, "+TAB_NAME+" TEXT, "+TAB_DAYS+" TEXT)";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
//    public DatabaseHelper(Context context) {
//        super(context, DATABSE_NAME, null, 1);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
        db.execSQL(SQL_CREATE_URL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int Older_Version, int New_Version) {
        db.execSQL("DROP TABLE IF EXISTS userAuth");
        db.execSQL("DROP TABLE IF EXISTS urlTable");
        onCreate(db);
    }

//    String[] my_data() {
//
//        SQLiteDatabase sq = this.getReadableDatabase();
//
//        String q = "SELECT * FROM "+TABLE_NAME_URL;
//
//        Cursor c = sq.rawQuery(q, null);
//
//        String[] recvied_data = new String[c.getCount()];
//
//        if(c.moveToFirst()){
//            int counter = 0 ;
//            do {
//                recvied_data[counter] = c.getString(c.getColumnIndex(TABLE_NAME_URL+""));
//                counter = counter+1;
//
//            } while(c.moveToNext());
//
//        }
//
//        return recvied_data;
//    }


}
