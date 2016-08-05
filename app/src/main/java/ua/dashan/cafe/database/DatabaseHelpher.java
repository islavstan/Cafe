package ua.dashan.cafe.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ua.dashan.cafe.R;


public class DatabaseHelpher extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 11;
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
    private static final String KEY_BOUGHT_FOOD = "boughtfood";

    public DatabaseHelpher (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
      /*  String CREATE_TABLE_FOOD = "CREATE TABLE " + TABLE_FOOD + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_CONSIST + " TEXT," + KEY_PHOTO + " INTEGER, " + KEY_PRICE + " INTEGER, " + KEY_WEIGHT + " INTEGER, " + KEY_CATEGORY + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_FOOD);*/


        updateMyDatabase(db,0,DATABASE_VERSION);





    }
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);

        // Create tables again
       // onCreate(db);
        updateMyDatabase(db, oldVersion, newVersion);
    }
    public void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOD);
            //Создать таблицу
            String CREATE_TABLE_FOOD = "CREATE TABLE " + TABLE_FOOD + "("
                    + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                    + KEY_CONSIST + " TEXT," + KEY_PHOTO + " INTEGER, " + KEY_PRICE + " INTEGER, " + KEY_WEIGHT + " INTEGER, " + KEY_CATEGORY + " TEXT, " +KEY_BOUGHT_FOOD+ " INTEGER"+ ")";
            db.execSQL(CREATE_TABLE_FOOD);
        insertFood(db, "Апельсиновый сок", "Пакетированный апельсиновый сок.", 17, R.drawable.apelsin, "Напитки", 1);
        insertFood(db, "7 Up", "Газированный напиток «7 Up».", 17, R.drawable.up, "Напитки", 1);
        insertFood(db, "Pepsi", "Газированный напиток «Pepsi».", 17, R.drawable.pepsi, "Напитки", 1);
        insertFood(db, "Beck's", "Пиво«Beck's».", 20, R.drawable.beks, "Напитки", 1);
        insertFood(db, "Staropramen", "Пиво«Staropramen».", 20, R.drawable.staropramen, "Напитки", 1);
        insertFood(db, "Итальяни", "Куриное филе, шампиньоны, помидоры, сладкий перец, моцарелла, петрушка, орегано, соус Pomodoro.",
                199, R.drawable.italiani, "Пицца", 2);
        insertFood(db, "Чемпион", "Охотничьи колбаски, салями, помидоры, моцарелла, сладкий лук, чеснок, орегано, петрушка, соусы Pomodoro и BBQ.",
                229, R.drawable.champion, "Пицца", 2);

        insertFood(db, "Пепперони метровая", "Салями пепперони, помидоры черри, моцарелла, орегано, перец пепперони, соус Pomodoro.",
                239, R.drawable.peperoni, "Пицца", 2);
        insertFood(db, "Пицца от шефа метровая", "Хамон, помидоры черри, пармезан, маскарпоне, моцарелла, сливки, руккола, орегано, соус Pomodoro.",
                229, R.drawable.chefpizza, "Пицца", 2);
        insertFood(db, "Кайсо", "Морские водоросли, огурец, сельдерей, ромен, ореховый соус.",
                59, R.drawable.kajso, "Суши", 1);
        insertFood(db, "Икура", "Суши с икрой лосося.",
                39, R.drawable.ikura, "Суши", 1);
        insertFood(db, "Сет Филадельфия Люкс", "Суши с лососем, авокадо и икрой Масаго.",
                439, R.drawable.set, "Суши", 1);
        insertFood(db, "Филадельфия с лососем", "Классический ролл с охлажденным лососем, авокадо, огурцом и сливочным сыром Филадельфия.",
                89, R.drawable.filadelfiya, "Суши", 1);
        insertFood(db, "Паста «Болоньєзе»", "Домашняя паста, мясной соус «Bolognese», пармезан, базилик, соус «Pomodoro».",
                69, R.drawable.bolonyeze, "Паста", 1);
        insertFood(db, "Паста «Карбонара»", "Домашняя паста, грудинка, пармезан, яичный желток, чеснок, сливки, смесь перцев, соус «Carbonara».",
                69, R.drawable.karbonara, "Паста", 1);
        insertFood(db, "Паста «Четыре моря»", "Домашняя паста, креветки, кальмары, осьминоги, мидии, перец чили, чеснок, сливки, соус «Pomodoro».",
                69, R.drawable.pastachetyremorya, "Паста", 1);
        insertFood(db, "Лазанья «Карбонара»", "Листы лазаньи, ветчина, бекон, сыр моцарелла, пармезан, шампиньоны, лук, соус «Bechamel».",
                59, R.drawable.lazanyakarbonara, "Паста", 1);

        insertFood(db, "БУРГЕР МЕНЮ ЧИЗ", "Булочка пшеничная, котлета из телятины, листья салата айсберг, помидор, лук марс, сыр чеддер, соус сальса, картофель по-селянски, соус.",
                68, R.drawable.largeburgerssushivesla, "Бургер", 1);

        insertFood(db, "БУРГЕР МЕНЮ С ИНДЕЙКОЙ", "Булочка пшеничная, котлета из индейки, листья салата айсберг, лук марс, помидор, соус унаги, соус сырный, перец пеперони, картофель по-селянски, соус.",
                69, R.drawable.largeburgerssushivesla3, "Бургер", 1);

        insertFood(db, "БУРГЕР МЕНЮ С КУРИЦЕЙ И БЕКОНОМ", "Булочка пшеничная, котлета из курицы, бекон, листья салата айсберг, лук марс, помидор, соус барбекю, картофель по-селянски, соус.",
                69, R.drawable.largeburgerssushivesla5, "Бургер", 1);

        insertFood(db, "Стейк из курицы с соусом «Наршараб»", "Куриное филе, гранатовый соус.",
                54, R.drawable.stejkkuricza, "Стейк", 1);
        insertFood(db, "Стейк из свинины с грибным соусом", "Свиная вырезка, грибной соус.",
               69, R.drawable.stejksvinina, "Стейк", 1);
        insertFood(db, "Стейк из телятины с клюквенным соусом", "Телятина, клюквенный соус, специи.",
                84, R.drawable.stejktelyatina, "Стейк", 1);
        insertFood(db, "Стейк из семги на овощной подушке", "Сёмга, овощи, специи.",
               140, R.drawable.stejkizsemgi, "Стейк", 1);











    }



    // Getting food from category
    public List<DatabaseModel> getFoodFromDB(String category){
        List<DatabaseModel> modelList = new ArrayList<DatabaseModel>();
        SQLiteDatabase db = this.getWritableDatabase();
       // String query = "select * from "+ TABLE_FOOD ;
        //здесь всё должно быть в том же порядке что и в таблице
        Cursor cursor = db.query(TABLE_FOOD, new String[]{KEY_ID, KEY_NAME,KEY_CONSIST, KEY_PHOTO, KEY_PRICE,KEY_WEIGHT, KEY_CATEGORY}, KEY_CATEGORY + "=?",
                new String[]{category}, null, null, null, null);
       // Cursor cursor=db.rawQuery(query,null);
        if (cursor.moveToFirst()){
            do {

      //  if (cursor != null)
            //cursor.moveToFirst();
      /*  DatabaseModel databaseModel = new DatabaseModel( cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(4)),
                Integer.parseInt(cursor.getString(3)), cursor.getString(6),Integer.parseInt(cursor.getString(5)));*/
                DatabaseModel databaseModel = new DatabaseModel();
                databaseModel.setName(cursor.getString(1));
                databaseModel.setConsist(cursor.getString(2));
                databaseModel.setPhoto(Integer.parseInt(cursor.getString(3)));
                databaseModel.setId(Integer.parseInt(cursor.getString(0)));
                databaseModel.setPrice(Integer.parseInt(cursor.getString(4)));
                databaseModel.setWeight(Integer.parseInt(cursor.getString(5)));
                databaseModel.setCategory(cursor.getString(6));


        modelList.add(databaseModel);
            }while (cursor.moveToNext());}
        return modelList;
    }

    // Adding new food
    public void addFood(DatabaseModel model) {
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

    // Так как нужно добавить несколько напитков, мы создаем отдельный метод.
    public void insertFood(SQLiteDatabase db,String name,String consist,int price,int photo,String category,int weight){
//
        //для определения набора значений создается объект
       // ContentValues для хранения пар «имя/значение» данных
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_CONSIST,consist);
        contentValues.put(KEY_PRICE,price);
        contentValues.put(KEY_PHOTO,photo);
        contentValues.put(KEY_CATEGORY,category);
        contentValues.put(KEY_WEIGHT,weight);
        db.insert(TABLE_FOOD, null, contentValues);


    }
   //getting one food
    public List<DatabaseModel> getOneFoodFromDB(String name){
        List<DatabaseModel> modelList = new ArrayList<DatabaseModel>();
        SQLiteDatabase db = this.getWritableDatabase();
         //String query = "select * from "+ TABLE_FOOD ;
        Cursor cursor = db.query(TABLE_FOOD, new String[] { KEY_ID, KEY_NAME,KEY_CONSIST, KEY_PHOTO, KEY_PRICE,KEY_WEIGHT, KEY_CATEGORY }, KEY_NAME + "=?",
                new String[] { name }, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                DatabaseModel databaseModel = new DatabaseModel();
                databaseModel.setName(cursor.getString(1));
                databaseModel.setConsist(cursor.getString(2));
                databaseModel.setPhoto(Integer.parseInt(cursor.getString(3)));
                databaseModel.setId(Integer.parseInt(cursor.getString(0)));
                databaseModel.setPrice(Integer.parseInt(cursor.getString(4)));
                databaseModel.setWeight(Integer.parseInt(cursor.getString(5)));
                databaseModel.setCategory(cursor.getString(6));
                modelList.add(databaseModel);
            }while (cursor.moveToNext());}
        return modelList;
    }

    //getting buy food
    public List<DatabaseModel> getBuyFoodFromDB(){
        List<DatabaseModel> modelList = new ArrayList<DatabaseModel>();
        SQLiteDatabase db = this.getWritableDatabase();
        //String query = "select * from "+ TABLE_FOOD ;
        Cursor cursor = db.query(TABLE_FOOD, new String[] { KEY_ID, KEY_NAME,KEY_CONSIST, KEY_PHOTO, KEY_PRICE,KEY_WEIGHT, KEY_CATEGORY }, KEY_BOUGHT_FOOD + "=?",
                new String[] { String.valueOf(1) }, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                DatabaseModel databaseModel = new DatabaseModel();
                databaseModel.setName(cursor.getString(1));
                databaseModel.setConsist(cursor.getString(2));
                databaseModel.setPhoto(Integer.parseInt(cursor.getString(3)));
                databaseModel.setId(Integer.parseInt(cursor.getString(0)));
                databaseModel.setPrice(Integer.parseInt(cursor.getString(4)));
                databaseModel.setWeight(Integer.parseInt(cursor.getString(5)));
                databaseModel.setCategory(cursor.getString(6));
                modelList.add(databaseModel);
            }while (cursor.moveToNext());}
        return modelList;
    }

    public int buyFood(DatabaseModel model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_BOUGHT_FOOD, 1);
        // updating row
        return db.update(TABLE_FOOD, values, KEY_NAME + " = ?",
                new String[] { String.valueOf(model.getName()) });
    }





}
