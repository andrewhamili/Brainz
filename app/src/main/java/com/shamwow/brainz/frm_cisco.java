package com.shamwow.brainz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;

public class frm_cisco extends AppCompatActivity {
    databasecontroller myDB;
    QuestionHandler qmsh;
    StringBuffer cha,chb,chc = new StringBuffer();

    @BindView(R.id.cis_rb_a) RadioButton rb_a;
    @BindView(R.id.cis_rb_b) RadioButton rb_b;
    @BindView(R.id.cis_rb_c)RadioButton rb_c;
    @BindView(R.id.cis_tv_question)TextView tv_question;
    @BindView(R.id.btn_cisco_submit)Button btn_submit;

    String ansstud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_cisco);
        myDB = new databasecontroller(this);


        ButterKnife.bind(this);



        get_questions();

    }

    public void get_questions(){

     Cursor cursor;
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
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(frm_cisco.this, "Escolar", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
