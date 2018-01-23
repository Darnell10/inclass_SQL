package c4q.com.inclass_sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by D on 1/22/18.
 */

public class Bridge_DB_helper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bridge.db";
    private static final String TABLE_NAME = "bridge crew";
    private static final int SCHEMA_VERSION = 1;


    public Bridge_DB_helper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE_TABLE" + TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "last_name TEXT, first_name Text, company TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /**  Important for when you update an entire database with a new version.
         *   We won't be exploring that in this lecture's example.
         */
    }

    public void addbridge(Bridge bridge) {
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM" + TABLE_NAME + "WHERE first_name = " + bridge.getFirstName()
                        + "AND last_name = " + bridge.getLastName()
                        + "AND company " + bridge.getCompany()
                        + ";", null);

        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME
                    + "(last_name, first_name,company) VALUES("
                    + bridge.getLastName() + "','"
                    + bridge.getLastName() + "','"
                    + bridge.getCompany() + ");");
        }
        cursor.close();
    }

    public List<Bridge> getBridgeList() {
        Cursor cursor = getReadableDatabase().rawQuery(" SELECT * FROM " + TABLE_NAME + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Bridge bridge = new Bridge(
                                    cursor.getString(cursor.getColumnIndex("last_name")),
                                    cursor.getString(cursor.getColumnIndex("first_name")),
                                    cursor.getString(cursor.getColumnIndex("company")));
                    getBridgeList().add(bridge);

                } while(cursor.moveToNext());
            }
        }
        return getBridgeList();
    }

}
