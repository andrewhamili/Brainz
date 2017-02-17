package com.shamwow.brainz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.content.res.TypedArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;


/**
 * Created by AngeloDesktop on 12/02/2017.
 */

public class databasecontroller extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "brainz.db";
    frm_cisco q_cisco;

    public static final String QUESTION_TABLE = "questions";
    public static final String Q_COL1 = "q_id";
    public static final String Q_COL2 = "q_subject";
    public static final String Q_COL3 = "q_answer";
    public static final String Q_COL4 = "q_IsFinished";
    public static final String Q_COL5 = "q_q_a";
    public static final String Q_COL6 = "q_q_b";
    public static final String Q_COL7 = "q_q_c";
    public static final String Q_Question = "q_question";

    public static final String RESULTS_TABLE = "results";
    public static final String R_COL1 = "r_id";
    public static final String R_COL2 = "r_subject";
    public static final String R_COL3 = "r_score";

    public static final String QuestionsCreate = "CREATE TABLE " + QUESTION_TABLE + " " +
            "(" + Q_COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Q_COL2 + " TEXT,"
                + Q_COL3 + " TEXT,"
                + Q_COL4 + " TEXT,"
                + Q_COL5 + " TEXT,"
                + Q_COL6 + " TEXT,"
                + Q_COL7 + " TEXT,"
                + Q_Question + " TEXT)";

    public static final String ResultsCreate = "CREATE TABLE "
            + RESULTS_TABLE + "("
            + R_COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + R_COL2 + " TEXT,"
            + R_COL3 + " INTEGER)";

    public static final String DroppingTables = "DROP TABLE IF EXIST "
            + QUESTION_TABLE + ","
            + RESULTS_TABLE;

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

    public boolean insertingquestions(String q_subject, String q_answer, String q_IsFinished, String q_q_a,String q_q_b,String q_q_c, String q_Question) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Q_COL2, q_subject);
        contentValues.put(Q_COL3, q_answer);
        contentValues.put(Q_COL4, q_IsFinished);
        contentValues.put(Q_COL5, q_q_a);
        contentValues.put(Q_COL6, q_q_b);
        contentValues.put(Q_COL7, q_q_c);
        contentValues.put(Q_Question,q_Question);

        long result = db.insert(QUESTION_TABLE, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }


    public Cursor get_specific_questions(String q_subject){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor show_question = db.rawQuery("SELECT * FROM "+QUESTION_TABLE+" WHERE "+Q_COL2+"= ?",new String[]{q_subject});
        return  show_question;
    }


    public boolean updatequestions(String q_id,String q_subject, String q_answer, String q_IsFinished, String q_q_a,String q_q_b,String q_q_c,String q_Question) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Q_COL1, q_id);
        contentValues.put(Q_COL2, q_subject);
        contentValues.put(Q_COL3, q_answer);
        contentValues.put(Q_COL4, q_IsFinished);
        contentValues.put(Q_COL5,q_q_a);
        contentValues.put(Q_COL6,q_q_b);
        contentValues.put(Q_COL7,q_q_c);
        contentValues.put(Q_Question,q_Question);

        db.update(QUESTION_TABLE, contentValues, "q_id = ?", new String[]{q_id});
        return true;
    }

    public Integer deletequestion(String q_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(QUESTION_TABLE, "q_id = ?", new String[]{q_id});

    }



    public Cursor get_cisco_question(){
        q_cisco = new frm_cisco();

        String[]  columnchoices = {Q_Question,Q_COL5,Q_COL6,Q_COL7};

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor showciscoquestions = db.rawQuery("SELECT q_Question,q_q_a,q_q_b,q_q_c FROM questions WHERE q_subject = ? AND q_IsFinished = ? ",new String[] {"Cisco","false"});


//        Cursor showciscoquestions = db.query(true,QUESTION_TABLE,columnchoices,"q_subject=?",new String[] {"Cisco"},null,null,null,null);

        return  showciscoquestions;
    }

    public Cursor get_id_for_cisco(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor showid_cisco = db.rawQuery("SELECT q_id FROM question WHERE q_subject = ?", new String[]{"Cisco"});
        return showid_cisco;

    }








}