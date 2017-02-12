package com.shamwow.brainz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionHandler extends AppCompatActivity {
    databasecontroller myDB;


    private String array_spinner[];
    Button btn_function;
    Spinner spinnersubj;
    EditText q_questions,q_answer,q_id;
    RadioButton rb_add,rb_del,rb_update;
    RadioGroup rg_functions;
    TextView tv_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_handler);
        myDB = new databasecontroller(this);

        btn_function = (Button) findViewById(R.id.btn_function);

        q_questions = (EditText) findViewById(R.id.qh_tv_questions);
        q_answer = (EditText) findViewById(R.id.qh_tv_answers);
        q_id = (EditText)findViewById(R.id.qh_tv_id);
        spinnersubj = (Spinner) findViewById(R.id.spinner_subjs);

        rg_functions = (RadioGroup)findViewById(R.id.rg_functions);
        rb_add = (RadioButton)findViewById(R.id.rb_add);
        rb_del = (RadioButton)findViewById(R.id.rb_delete);
        rb_update = (RadioButton)findViewById(R.id.rb_update);

        tv_no = (TextView)findViewById(R.id.tv_no);


        spinnerloader();
        radiooo();
        data_manipulation();

    }

    public void spinnerloader(){
        array_spinner = new String[4];
        array_spinner[0] = "MySQL";
        array_spinner[1] = "VB.NET";
        array_spinner[2] = "Cisco";
        array_spinner[3] = "Computer Essential";
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array_spinner);
        spinnersubj.setAdapter(adapter);
    }

    public void radiooo(){

        rb_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_function.setText("Add");
                q_id.setVisibility(View.GONE);
                tv_no.setVisibility(View.GONE);
            }
        });

        rb_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_function.setText("Update");
                q_id.setVisibility(View.VISIBLE);
                tv_no.setVisibility(View.VISIBLE);
            }
        });

        rb_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_function.setText("Delete");
                q_id.setVisibility(View.VISIBLE);
                tv_no.setVisibility(View.VISIBLE);
            }
        });


    }


    public void data_manipulation() {

        btn_function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btn_function.getText().toString()=="Add"){



                    boolean isInserted = myDB.insertingquestions(spinnersubj.getSelectedItem().toString(),
                            q_questions.getText().toString(),
                            q_answer.getText().toString());

                    if (isInserted == true)
                        Toast.makeText(QuestionHandler.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(QuestionHandler.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                } else if (btn_function.getText().toString()=="Update"){

                    boolean isUpdated = myDB.updatequestions(q_id.getText().toString(),
                            spinnersubj.getSelectedItem().toString(),
                            q_questions.getText().toString(),
                            q_answer.getText().toString());

                    if (isUpdated == true)

                        Toast.makeText(QuestionHandler.this,"Data Updated",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(QuestionHandler.this,"Data not Updated",Toast.LENGTH_LONG).show();





                }




            }
        });
    }



}
