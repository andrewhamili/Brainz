package com.shamwow.brainz;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class frm_mysql extends AppCompatActivity {

    databasecontroller myDB;
    @BindView(R.id.mysql_rb_a)
    RadioButton rb_a;
    @BindView(R.id.mysql_rb_b)
    RadioButton rb_b;
    @BindView(R.id.mysql_rb_c)
    RadioButton rb_c;
    @BindView(R.id.mysql_tv_question)
    TextView tv_question;
    @BindView(R.id.mysql_btn_submit)
    Button btn_next;
    @BindView(R.id.mysql_tv_score)
    TextView tv_score;
    @BindView(R.id.mysql_btn_show_answer)
    Button btn_show_answer;
    @BindView(R.id.mysql_rg_choices)
    RadioGroup rg_choices;
    @BindView(R.id.mysql_tv_high_score)
    TextView tv_high_score;

    String ref;
    private MySQLQuestionLibrary mysqllib = new MySQLQuestionLibrary();
    private String answer;
    private int score = 0;
    private int number = 0;
    private String subject = "MySQL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_mysql);

        myDB = new databasecontroller(this);
        ButterKnife.bind(this);
        set_questions();
        conditions();

        high_score_cis();

        tv_high_score.setVisibility(View.INVISIBLE);
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

            if (number == 5) {

                if (ref == answer) {
                    score = score + 1;
                    updateScore(score);
                    set_questions();
                }
                tv_high_score.setVisibility(View.VISIBLE);
                tv_score.setVisibility(View.VISIBLE);
                tv_question.setVisibility(View.INVISIBLE);
                rb_a.setVisibility(View.GONE);
                rb_b.setVisibility(View.GONE);
                rb_c.setVisibility(View.GONE);
                Toast.makeText(frm_mysql.this, "Finish", Toast.LENGTH_LONG).show();

                updateScore(score);
                insert_high_score_ce();
                high_score_cis();

                btn_show_answer.setVisibility(View.VISIBLE);
                btn_show_answer.setText("?");
                btn_show_answer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("Brainz Inc. MySQL",
                                "The Answer is:\n" +
                                        "1. Query\n" +
                                        "2. mysql_close\n" +
                                        "3. PHP Data Objects\n" +
                                        "4. CREATE DATABASE\n" +
                                        "5. Database");

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

    public void insert_high_score_ce() {
        String scorerecord = Integer.toString(score);
        boolean isInserted = myDB.insertinghighscore(subject, scorerecord);
        if (isInserted == true) {
//            Toast.makeText(frm_comp_essential.this, "Data Inserted", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(frm_mysql.this, "High Score not Recorded", Toast.LENGTH_LONG).show();
        }

        showMessage("Brainz Inc. MySQL", "Score: " + score);
    }

    public void high_score_cis() {
        Cursor get_high_score = myDB.get_high_score(subject);
        if (get_high_score.getCount() == 0) {
            showMessage("Error", "No Data Found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (get_high_score.moveToNext()) {
            buffer.append("Highest Score MySQL:\n" + get_high_score.getString(0) + "\n");
        }
        tv_high_score.setText(buffer.toString());
    }


    public void conditions() {

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


    public void set_questions() {

        tv_question.setText(mysqllib.MySQLgetListQuestions(number));
        rb_a.setText(mysqllib.MySQLgetChoicea(number));
        rb_b.setText(mysqllib.MySQLgetChoiceb(number));
        rb_c.setText(mysqllib.MySQLgetChoicec(number));

        answer = mysqllib.MySQLgetCorrectAnswer(number);
        number++;

        rg_choices.clearCheck();
        rb_a.setChecked(false);
        rb_b.setChecked(false);
        rb_c.setChecked(false);
    }

    public void updateScore(int point) {
        tv_score.setText("Score: " + score);
    }


    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

}
