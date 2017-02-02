package com.shamwow.brainz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class frm_topics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_topics);

        Button vb_net =(Button) findViewById(R.id.btn_vb_net);

        vb_net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(frm_topics.this,frm_vb_net.class));
            }
        });


        Button mysql = (Button) findViewById(R.id.btn_mysql);
        mysql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(frm_topics.this,frm_mysql.class));
            }
        });

        Button comp_esssentials = (Button) findViewById(R.id.btn_comp_essentials);
        comp_esssentials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(frm_topics.this,frm_comp_essential.class));
            }
        });


        Button cisco = (Button)findViewById(R.id.btn_cisco);

        cisco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(frm_topics.this,frm_cisco  .class));
            }
        });
    }
}
