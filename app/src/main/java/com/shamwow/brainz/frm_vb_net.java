package com.shamwow.brainz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import butterknife.BindView;

public class frm_vb_net extends AppCompatActivity {

    private VBQuestionLibrary vblib = new VBQuestionLibrary();

    @BindView(R.id.vb_rb_a) RadioButton rb_a;
    @BindView(R.id.vb_rb_b) RadioButton rb_b;
    @BindView(R.id.vb_rb_c) RadioButton rb_c;
    @BindView(R.id.vb_tv_question)TextView tv_question;
    @BindView(R.id.vb_btn_submit) Button btn_next;
    @BindView(R.id.vb_tv_score) TextView tv_score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_vb_net);
    }
}
