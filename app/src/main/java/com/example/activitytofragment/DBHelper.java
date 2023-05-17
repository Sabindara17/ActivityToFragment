package com.example.activitytofragment;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;
    static final String DB_NAME = "MY.DB";
    static final int DB_VERSION = 1;

    static final String DB_TABLE = "USERS";
    static final String USER_ID = "_ID";
    static final String USER_NAME = "user_name";
    static final String USER_PASSWORD = "user_password";


    private static final String DB_QUERY_CREATE = "CREATE TABLE " + DB_TABLE + " (" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_NAME + " TEXT, " + USER_PASSWORD + " TEXT);";


    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_QUERY_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);

    }
    void addBook(DataClass dataClass){
        SQLiteDatabase sd = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USER_NAME,dataClass.getName());
        cv.put(USER_PASSWORD,dataClass.getPass());
        cv.put(USER_ID,dataClass.getId());
        long res = sd.insert(DB_TABLE, null, cv);
        if (res == -1) {
            Toast.makeText(context, "Failed to insert data", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show();

        }
    }

    public List<DataClass> getAllData() {
        List<DataClass> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + DB_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
                DataClass d =  new DataClass();
                d.setId(String.valueOf(cursor.getInt(0)));
                d.setName(cursor.getString(1));
                d.setPass(cursor.getString(2));
                list.add(d);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

//    void addBook(String uname, String password) {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(USER_NAME, uname);
//        contentValues.put(USER_PASSWORD, password);
//        long res = sqLiteDatabase.insert(DB_TABLE, null, contentValues);
//        if (res == -1) {
//            Toast.makeText(context, "Failed to insert data", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(context, "Success!", Toast.LENGTH_SHORT).show();
//
//        }
//    }
//
//
//    Cursor readAllData() {
//        String query = "SELECT * FROM " + DB_TABLE;
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = null;
//        if (db != null) {
//            cursor = db.rawQuery(query, null);
//        }
//        return cursor;
//    }

}
