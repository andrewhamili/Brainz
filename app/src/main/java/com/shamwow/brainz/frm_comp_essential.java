package com.shamwow.brainz;

import android.support.v7.app.AlertDialog;
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

public class frm_comp_essential extends AppCompatActivity {

    databasecontroller myDB;
    private CompEssentialsQuestionLibrary celib = new CompEssentialsQuestionLibrary();

    @BindView(R.id.ce_rb_a)RadioButton rb_a;
    @BindView(R.id.ce_rb_b) RadioButton rb_b;
    @BindView(R.id.ce_rb_c) RadioButton rb_c;
    @BindView(R.id.ce_tv_question)TextView tv_question;
    @BindView(R.id.ce_btn_submit)Button btn_next;
    @BindView(R.id.ce_tv_score) TextView tv_score;
    @BindView(R.id.ce_btn_show_answer) Button btn_show_answer;
    @BindView(R.id.ce_rg_choices)RadioGroup rg_choices;

    private String answer;
    private int score =0;
    private int number =0;
    String ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_comp_essential);

        myDB = new databasecontroller(this);
        ButterKnife.bind(this);
        set_questions();
        conditions();


        btn_show_answer.setVisibility(View.INVISIBLE);
        tv_score.setVisibility(View.INVISIBLE);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoring();
            }
        });
    }

    public void scoring() {
        if (number == 0) {
            score = 0;

        }




        if (number != 5) {
            if (ref == answer) {
                score = score + 1;
                updateScore(score);
                set_questions();


            } else if (ref == answer) {
                score = score + 1;
                updateScore(score);
                set_questions();

            } else if (ref == answer) {
                score = score + 1;
                updateScore(score);
                set_questions();

            } else {
                updateScore(score);
                set_questions();

            }
        } else {

            if (number==5){

                if (ref==answer){
                    score = score + 1;
                    updateScore(score);
                    set_questions();
                }


                tv_score.setVisibility(View.VISIBLE);
                tv_question.setVisibility(View.INVISIBLE);
                rb_a.setVisibility(View.GONE);
                rb_b.setVisibility(View.GONE);
                rb_c.setVisibility(View.GONE);
                Toast.makeText(frm_comp_essential.this, "Finish", Toast.LENGTH_LONG).show();
                updateScore(score);
                showMessage("Brainz Inc. Computer Essentials", "Score: " + score);

                btn_show_answer.setVisibility(View.VISIBLE);
                btn_show_answer.setText("?");
                btn_show_answer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("Brainz Inc. Computer Essentials",
                                        "The Answer is:\n" +
                                                "1. Internet browser\n" +
                                                "2. Touchpad\n" +
                                                "3. Central Processing Unit\n" +
                                                "4. An operating system\n" +
                                                "5. 1024 bytes\n");


                    }
                });

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

        tv_question.setText(celib.CompEssentialsgetListQuestions(number));
        rb_a.setText(celib.CompEssentialsgetChoicea(number));
        rb_b.setText(celib.CompEssentialsgetChoiceb(number));
        rb_c.setText(celib.CompEssentialsgetChoicec(number));
        answer = celib.CompEssentialsgetCorrectAnswer(number);
        number++;

       rg_choices.clearCheck();
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
}
