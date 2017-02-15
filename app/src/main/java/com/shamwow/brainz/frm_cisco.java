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
    @BindView(R.id.btn_cisco_submit) Button btn_submit;
    @BindView(R.id.tv_test) TextView tv_test;

    String ansstud,answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_cisco);
        myDB = new databasecontroller(this);


        ButterKnife.bind(this);



        get_questions();
        answerme();
    }

    public void get_questions(){


        cursor = myDB.get_cisco_question();
        if (cursor.moveToFirst()){
            do{
                String q_q,q_a,q_b,q_c;

                q_a = cursor.getString(0);
                q_b = cursor.getString(1);
                q_c = cursor.getString(2);
                q_q = cursor.getString(3);

                rb_a.setText(q_a);
                rb_b.setText(q_b);
                rb_c.setText(q_c);
                tv_question.setText(q_q);

            }while ( cursor.moveToNext());
        }

    }

    public void answerme(){

        rb_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = rb_a.getText().toString();
                tv_test.setText(answer);
            }
        });

        rb_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = rb_b.getText().toString();
                tv_test.setText(answer);
            }
        });

        rb_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer= rb_c.getText().toString();
                tv_test.setText(answer);
            }
        });




//
//        int index = rg_cisco_choices.indexOfChild(findViewById(rg_cisco_choices.getCheckedRadioButtonId()));
//        String ans = String.valueOf(index);
//        cursor = myDB.get_answer(ans){

        }

}


