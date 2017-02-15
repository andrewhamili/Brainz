package com.shamwow.brainz;

import android.database.Cursor;
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

    @BindView(R.id.cis_rb_a) RadioButton rb_a;
    @BindView(R.id.cis_rb_b) RadioButton rb_b;
    @BindView(R.id.cis_rb_c)RadioButton rb_c;
    @BindView(R.id.cis_tv_question)TextView tv_question;
    @BindView(R.id.btn_cisco_submit)Button btn_submit;
    String ansstud;
    StringBuffer cha,chb,chc = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_cisco);
        myDB = new databasecontroller(this);


        ButterKnife.bind(this);



        get_questions();

    }

    public void get_questions(){

        Cursor show_questions = myDB.get_cisco_question();

        if (show_questions.getCount()==0){
            qmsh.showMessage("Error","No Data Found");
        }


        while (show_questions.moveToNext()){
            cha.append(show_questions.getString(0));
            chb.append(show_questions.getString(1));
            chc.append(show_questions.getString(2));

        }
        rb_a.setText(cha);
        rb_b.setText(chb);
        rb_c.setText(chc);

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
