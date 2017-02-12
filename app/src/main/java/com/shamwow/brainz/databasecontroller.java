package com.shamwow.brainz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AngeloDesktop on 12/02/2017.
 */

public class databasecontroller extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "brainz.db";

    public static final String QUESTION_TABLE = "questions";
    public static final String Q_COL1 = "q_id";
    public static final String Q_COL2 = "q_subject";
    public static final String Q_COL3 = "q_question";
    public static final String Q_COL4 = "q_answer";

    public static final String RESULTS_TABLE = "results";
    public static final String R_COL1 = "r_id";
    public static final String R_COL2 = "r_subject";
    public static final String R_COL3 = "r_score";

    public static final String QuestionsCreate = "CREATE TABLE " + QUESTION_TABLE + "("+Q_COL1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+Q_COL2+" TEXT,"+Q_COL3+" TEXT,"+Q_COL4+" TEXT)";
    public static final String ResultsCreate = "CREATE TABLE "+ RESULTS_TABLE + "("+R_COL1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+R_COL2+" TEXT,"+R_COL3+" INTEGER)";
    public static final String DroppingTables = "DROP TABLE IF EXIST "+QUESTION_TABLE+","+ RESULTS_TABLE;

    public databasecontroller(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QuestionsCreate);
        db.execSQL(ResultsCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DroppingTables);
        onCreate(db);
    }

    public boolean insertingquestions(String q_subject,String q_question,String q_answer){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Q_COL2,q_subject);
        contentValues.put(Q_COL3,q_question);
        contentValues.put(Q_COL4,q_answer);

        long result = db.insert(QUESTION_TABLE,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public boolean updatequestions(String q_id,String q_subject,String q_question,String q_answer){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Q_COL1,q_id);
        contentValues.put(Q_COL2,q_subject);
        contentValues.put(Q_COL3,q_question);
        contentValues.put(Q_COL4,q_answer);

        db.update(QUESTION_TABLE,contentValues, "q_id = ?",new String[] { q_id } );
        return true;
    }

    public Integer deletequestion(String q_id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(QUESTION_TABLE,"q_id = ?",new String[] {q_id});

    }

    public Cursor get_all_questions(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor show_questions = db.rawQuery("SELECT * FROM "+ QUESTION_TABLE,null);
        return show_questions;

    }


}



