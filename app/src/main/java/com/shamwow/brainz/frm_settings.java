package com.shamwow.brainz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class frm_settings extends AppCompatActivity {

    @BindView(R.id.btn_questions)  Button btn_gotoquestionmanager;
    @BindView(R.id.btn_clear_data) Button btn_clear_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_settings);
        ButterKnife.bind(this);

        btn_gotoquestionmanager = (Button) findViewById(R.id.btn_questions);
        btn_gotoquestionmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(frm_settings.this, QuestionHandler.class));
            }
        });

        btn_clear_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showyesno();
            }
        });
    }

    public void showyesno(){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==DialogInterface.BUTTON_POSITIVE){
                    clearPreferences();
                } else {

                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    private void clearPreferences() {
        try {
            // clearing app data
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("pm clear com.shamwow.brainz");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
