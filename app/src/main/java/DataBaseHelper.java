import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.os.Build.ID;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Register.db";
    public static final String TABLE_NAME="Registration Table";
    public static final String COL_1="ID";
    public static final String COL_2="USERNAME";
    public static final String COL_3="USER_E-MAIL";
    public static final String COL_4="MOBILE NUMBER";
    public static final String COL_5="PASSWORD";
    protected static final int version=1;
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " +TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT,USER_E-MAIL TEXT,MOBILE NUMBER INTEGER,PASSWORD TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);

    }
}
