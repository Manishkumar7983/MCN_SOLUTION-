package com.manish.sharpsprint;

//package com.example.sharpsprint;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "SharpSprint.db";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE user (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "wallet INTEGER," +
                        "streak INTEGER," +
                        "last_completed_date TEXT)"
        );

        db.execSQL(
                "CREATE TABLE challenge (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "title TEXT," +
                        "type TEXT," +
                        "reward INTEGER," +
                        "expiry_time TEXT)"
        );

        db.execSQL(
                "CREATE TABLE progress (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "challenge_id INTEGER," +
                        "completed_on TEXT)"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    // Insert default user
    public void insertUser() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("wallet", 0);
        cv.put("streak", 0);
        cv.put("last_completed_date", "");
        db.insert("user", null, cv);
    }

    public Cursor getUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM user LIMIT 1", null);
    }

    public void updateUser(int wallet, int streak, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("wallet", wallet);
        cv.put("streak", streak);
        cv.put("last_completed_date", date);
        db.update("user", cv, "id=1", null);
    }
}


