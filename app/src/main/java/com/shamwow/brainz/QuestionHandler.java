package com.shamwow.brainz;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
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
    Spinner spinnersubj,spinnerchoose;
    EditText q_a,q_b,q_c,q_answer,q_id,q_question;
    RadioButton rb_add,rb_del,rb_update,rb_view;
    RadioGroup rg_functions;
    TextView tv_no;
    String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_handler);
        myDB = new databasecontroller(this);

        btn_function = (Button) findViewById(R.id.btn_function);

        q_question = (EditText)findViewById(R.id.qh_question);
        q_a = (EditText) findViewById(R.id.qh_a);
        q_b = (EditText)findViewById(R.id.qh_b);
        q_c = (EditText)findViewById(R.id.qh_c);
        q_answer = (EditText) findViewById(R.id.qh_tv_answers);

        q_id = (EditText)findViewById(R.id.qh_tv_id);
        spinnersubj = (Spinner) findViewById(R.id.spinner_subjs);
        spinnerchoose = (Spinner)findViewById(R.id.sp_viewchoices);

        rg_functions = (RadioGroup)findViewById(R.id.rg_functions);
        rb_add = (RadioButton)findViewById(R.id.rb_add);
        rb_del = (RadioButton)findViewById(R.id.rb_delete);
        rb_update = (RadioButton)findViewById(R.id.rb_update);
        rb_view = (RadioButton)findViewById(R.id.rb_view);

        spinnerchoose.setVisibility(View.GONE);
        q_id.setVisibility(View.GONE);

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
        spinnerchoose.setAdapter(adapter);
    }

    public void radiooo(){

        rb_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_function.setText("Add");
                spinnerchoose.setVisibility(View.GONE);
                q_id.setVisibility(View.GONE);

            }
        });

        rb_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_function.setText("Update");
                q_id.setVisibility(View.VISIBLE);
                spinnerchoose.setVisibility(View.GONE);
            }
        });

        rb_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_function.setText("Delete");
                q_id.setVisibility(View.VISIBLE);
                spinnerchoose.setVisibility(View.GONE);
            }
        });
        rb_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_function.setText("View");
                spinnerchoose.setVisibility(View.VISIBLE);


            }
        });


    }


    public void data_manipulation() {

        btn_function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btn_function.getText().toString()=="Add"){

                   status = "false";

                    boolean isInserted = myDB.insertingquestions(spinnersubj.getSelectedItem().toString(),q_answer.getText().toString(),
                            status,q_a.getText().toString(),q_b.getText().toString(),q_c.getText().toString(),q_question.getText().toString());

                    if (isInserted == true)
                        Toast.makeText(QuestionHandler.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(QuestionHandler.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                } else if (btn_function.getText().toString()=="Update"){
                    status = "false";
                    boolean isUpdated = myDB.updatequestions(q_id.getText().toString(),
                            spinnersubj.getSelectedItem().toString(),
                            q_answer.getText().toString(),status ,q_a.getText().toString(),q_b.getText().toString(),q_c.getText().toString(),q_question.getText().toString());

                    if (isUpdated == true)

                        Toast.makeText(QuestionHandler.this,"Data Updated",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(QuestionHandler.this,"Data not Updated",Toast.LENGTH_LONG).show();


                } else if(btn_function.getText().toString()=="Delete") {
                    Integer deletedRows = myDB.deletequestion(q_id.getText().toString());
                    if (deletedRows > 0)

                        Toast.makeText(QuestionHandler.this,"Data Deleted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(QuestionHandler.this,"Data not Deleted",Toast.LENGTH_LONG).show();

                } else if (btn_function.getText().toString()=="View"){
                    Cursor show_data =  myDB.get_specific_questions(spinnerchoose.getSelectedItem().toString());

                    if (show_data.getCount() ==0){

                        showMessage("Error","No Data Found");
                        return;

                    }

                    StringBuffer buffer = new StringBuffer();
                    while (show_data.moveToNext()){
                        buffer.append("Question ID: " +show_data.getString(0)+"\n");
                        buffer.append("Subject: " +show_data.getString(1)+"\n");
                        buffer.append("Answer: " +show_data.getString(2)+"\n");
                        buffer.append("Status: " +show_data.getString(3)+"\n");
                        buffer.append("Question A: " +show_data.getString(4)+"\n");
                        buffer.append("Question B: " +show_data.getString(5)+"\n");
                        buffer.append("Question C: " +show_data.getString(6)+"\n");
                        buffer.append("Question:" + show_data.getString(7)+"\n\n");

                    }

                    showMessage("Questions",buffer.toString());
                }




            }
        });


    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }




}
