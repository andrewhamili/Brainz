package com.shamwow.brainz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;

public class frm_highscore extends AppCompatActivity {

    @BindView(R.id.tv_hs_ce)TextView hs_ce;
    @BindView(R.id.tv_hs_cisco)TextView hs_cis;
    @BindView(R.id.tv_hs_mysql)TextView hs_mysql;
    @BindView(R.id.tv_hs_vb)TextView hs_vb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_highscore);

    }
}
