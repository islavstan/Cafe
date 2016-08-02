package ua.dashan.cafe.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelpher extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cafe";
    private static final String TABLE_FOOD = "food";
    // TABLE_FOOD Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CONSIST = "consist";
    private static final String KEY_PHOTO = "photo";
    private static final String KEY_PRICE = "price";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_CATEGORY = "category";

    public DatabaseHelpher (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_FOOD = "CREATE TABLE " + TABLE_FOOD + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_CONSIST + " TEXT," + KEY_PHOTO + " INTEGER, " + KEY_PRICE + " INTEGER, " + KEY_WEIGHT + " INTEGER, " + KEY_CATEGORY + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_FOOD);
    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);

        // Create tables again
        onCreate(db);
    }



    // Getting food from category
    DatabaseModel getFood(String category) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_FOOD, new String[]{KEY_ID, KEY_NAME, KEY_PRICE, KEY_PHOTO, KEY_CATEGORY}, KEY_CATEGORY + "=?",
                new String[]{category}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        DatabaseModel databaseModel = new DatabaseModel(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(4)),
                Integer.parseInt(cursor.getString(3)), cursor.getString(7));
        return databaseModel;
    }

    // Adding new food
    void addFood(DatabaseModel model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, model.getName());
        values.put(KEY_CONSIST, model.getConsist());
        values.put(KEY_PHOTO, model.getPhoto());
        values.put(KEY_PRICE, model.getPrice());
        values.put(KEY_WEIGHT, model.getWeight());
        values.put(KEY_CATEGORY, model.getCategory());
        // Inserting Row
        db.insert(TABLE_FOOD, null, values);
        db.close(); // Closing database connection
    }
}
