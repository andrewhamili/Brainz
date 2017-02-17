package com.shamwow.brainz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class frm_cisco extends AppCompatActivity {
    databasecontroller myDB;
    private QuestionLibrary qlib = new QuestionLibrary();

    QuestionHandler qmsh;
    StringBuffer cha,chb,chc = new StringBuffer();
    Cursor cursor;



    @BindView(R.id.cis_rb_a) RadioButton rb_a;
    @BindView(R.id.cis_rb_b) RadioButton rb_b;
    @BindView(R.id.cis_rb_c) RadioButton rb_c;
    @BindView(R.id.cis_tv_question) TextView tv_question;
    @BindView(R.id.btn_cisco_submit) Button btn_next;
    @BindView(R.id.tv_preview) TextView tv_preview;
    @BindView(R.id.tv_score) TextView tv_score;

    String choices;
    private String answer;
    private int score =0;
    private int number =0;
    String ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_cisco);
        myDB = new databasecontroller(this);


        ButterKnife.bind(this);


         set_questions();
         conditions();
//        get_questions();
//        answerme();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (number==0){
                    score=0;
                } else {
                    if (number != 5){
                        if (ref==answer){
                            score=score+1;
                            updateScore(score);
                            set_questions();


                        }else if (ref==answer){
                            score=score+1;
                            updateScore(score);
                            set_questions();

                        }else if (ref==answer){
                            score=score+1;
                            updateScore(score);
                            set_questions();

                        } else {
                            updateScore(score);
                            set_questions();

                        }
                    } else {

                        if (number==5){

                            updateScore(score);

                            showMessage("Brainz Inc.","Score: "+score);

                            btn_next.setText("Finish");
                            btn_next.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    finish();
                                }
                            });
                        }


                    }
                }





            }

        });

    }

    public void conditions(){

        rb_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = rb_a.getText().toString();
            }
        });

        rb_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = rb_b.getText().toString();
            }
        });

        rb_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = rb_c.getText().toString();
            }
        });



    }


    public void set_questions(){

    tv_question.setText(qlib.getListQuestions(number));
        rb_a.setText(qlib.getChoicea(number));
        rb_b.setText(qlib.getChoiceb(number));
        rb_c.setText(qlib.getChoicec(number));

        answer = qlib.getCorrectAnswer(number);
        number++;
        rb_a.setChecked(false);
        rb_b.setChecked(false);
        rb_c.setChecked(false);
    }

    public void updateScore(int point){
        tv_score.setText("Score: "+ score);
    }


    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }





//    public void get_questions(){
//
//
//        cursor = myDB.get_cisco_question();
//        if (cursor.moveToFirst()){
//            do{
//                String q_q,q_a,q_b,q_c;
//
//                q_a = cursor.getString(0);
//                q_b = cursor.getString(1);
//                q_c = cursor.getString(2);
//                q_q = cursor.getString(3);
//
//                rb_a.setText(q_a);
//                rb_b.setText(q_b);
//                rb_c.setText(q_c);
//                tv_question.setText(q_q);
//
//            }while ( cursor.moveToNext());
//        }
//
//    }
//
//    public void answerme(){
//
//        rb_a.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                choices = rb_a.getText().toString();
//                tv_preview.setText(choices);
//            }
//        });
//
//        rb_b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                choices = rb_b.getText().toString();
//                tv_preview.setText(choices);
//            }
//        });
//
//        rb_c.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                choices= rb_c.getText().toString();
//                tv_preview.setText(choices);
//            }
//        });
//
//
//        }

}


