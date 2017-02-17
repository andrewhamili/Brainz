package com.shamwow.brainz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    String ansstud,answer;
    int score =0;
    int counter =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_cisco);
        myDB = new databasecontroller(this);


        ButterKnife.bind(this);


        set_questions();
//        get_questions();
        answerme();
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_answer();
                counter+=1;
                set_questions();
            }
        });

    }


    public void set_questions(){



        if (counter==1){
            tv_question.setText("What is cisco?");
            rb_a.setText("Networking");
            rb_b.setText("Is a fap");
            rb_c.setText("Dafaq");
        }else if (counter==2) {
            tv_question.setText("Dafaq?");
            rb_a.setText("a");
            rb_b.setText("b");
            rb_c.setText("c");
        }







    }

    public void get_answer() {
        if (counter==5){

            if (counter==1){
                if (tv_preview.getText().toString() == "Networking"){
                    score += 1;
                    String result = Integer.toString(score);
                    tv_score.setText("Score: "+result);
                }else{
                    Toast.makeText(frm_cisco.this, "Wrong Answer", Toast.LENGTH_LONG).show();
                }

            } else if (counter==2){
                if(tv_preview.getText().toString()=="a"){
                    score +=1;
                    String result = Integer.toString(score);
                    tv_score.setText("Score: "+result);
                }else{
                    Toast.makeText(frm_cisco.this,"Wrong Answer",Toast.LENGTH_LONG).show();
                }
            }

        }else{

        }





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

    public void answerme(){

        rb_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = rb_a.getText().toString();
                tv_preview.setText(answer);
            }
        });

        rb_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = rb_b.getText().toString();
                tv_preview.setText(answer);
            }
        });

        rb_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer= rb_c.getText().toString();
                tv_preview.setText(answer);
            }
        });


        }

}


