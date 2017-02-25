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

public class frm_cisco extends AppCompatActivity {
    databasecontroller myDB;
    private CiscoQuestionLibrary qlib = new CiscoQuestionLibrary();

    QuestionHandler qmsh;
    StringBuffer cha, chb, chc = new StringBuffer();
    Cursor cursor;


    @BindView(R.id.cis_rb_a)
    RadioButton rb_a;
    @BindView(R.id.cis_rb_b)
    RadioButton rb_b;
    @BindView(R.id.cis_rb_c)
    RadioButton rb_c;
    @BindView(R.id.cis_tv_question)
    TextView tv_question;
    @BindView(R.id.cis_tv_high_score)
    TextView tv_high_score;
    @BindView(R.id.tv_score)
    TextView tv_score;
    @BindView(R.id.cis_btn_submit)
    Button btn_next;
    @BindView(R.id.cis_btn_show_answer)
    Button btn_show_answer;
    @BindView(R.id.cis_rg_choices)
    RadioGroup rg_choices;


    private String subject = "Cisco";

    private String answer;
    private int score = 0;
    private int number = 0;
    String ref, choices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_cisco);

        myDB = new databasecontroller(this);
        ButterKnife.bind(this);
        set_questions();
        conditions();
        high_score_cis();

//        get_questions();
//        answerme();

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

        if (number != 10) {
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

            if (number == 10) {

                if (ref == answer) {
                    score = score + 1;
                    updateScore(score);
                    set_questions();
                    high_score_cis();
                }

                tv_high_score.setVisibility(View.VISIBLE);
                tv_score.setVisibility(View.VISIBLE);
                tv_question.setVisibility(View.INVISIBLE);

                rb_a.setVisibility(View.GONE);
                rb_b.setVisibility(View.GONE);
                rb_c.setVisibility(View.GONE);
                Toast.makeText(frm_cisco.this, "Finish", Toast.LENGTH_LONG).show();

                updateScore(score);
                insert_high_score_cisco();
                high_score_cis();

                btn_show_answer.setVisibility(View.VISIBLE);
                btn_show_answer.setText("?");
                btn_show_answer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMessage("Brainz Inc. Cisco",
                                "The Answer is:\n" +
                                        "1. Class B\n" +
                                        "2. The job of the Data Link layer is to check messages are sent to the right device.\n" +
                                        "3. 255.255.255.224\n" +
                                        "4. Maximum Transmission Unit\n" +
                                        "5. High Level Data Link Control\n" +
                                        "6. no\n" +
                                        "7. Ctrl + C\n" +
                                        "8. 224.255.0.0\n" +
                                        "9. RJ-45\n" +
                                        "10. Presentation\n");

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

    public void insert_high_score_cisco() {
        String scorerecord = Integer.toString(score);
        boolean isInserted = myDB.insertinghighscore(subject, scorerecord);
        if (isInserted == true) {
//            Toast.makeText(frm_cisco.this, "Data Inserted", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(frm_cisco.this, "High Score not Recorded", Toast.LENGTH_LONG).show();
        }

        showMessage("Brainz Inc. Cisco", "Score: " + score);
    }

    public void high_score_cis() {
        Cursor get_high_score = myDB.get_high_score(subject);
        if (get_high_score.getCount() == 0) {
            showMessage("Error", "No Data Found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (get_high_score.moveToNext()) {
            buffer.append("Highest Score Cisco:\n" + get_high_score.getString(0) + "\n");
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

        tv_question.setText(qlib.getListQuestions(number));
        rb_a.setText(qlib.getChoicea(number));
        rb_b.setText(qlib.getChoiceb(number));
        rb_c.setText(qlib.getChoicec(number));

        answer = qlib.getCorrectAnswer(number);
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


