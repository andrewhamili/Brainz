package com.shamwow.brainz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class frm_settings extends AppCompatActivity {

    Button btn_gotoquestionmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_settings);

        btn_gotoquestionmanager = (Button)findViewById(R.id.btn_questions);
        btn_gotoquestionmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(frm_settings.this,QuestionHandler.class));
            }
        });
    }
}
