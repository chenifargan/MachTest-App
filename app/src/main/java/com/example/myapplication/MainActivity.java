package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.adjustmenttestlibrary.MatchBoundary;
import com.example.adjustmenttestlibrary.MatchController;
import com.example.adjustmenttestlibrary.Person;

public class MainActivity extends AppCompatActivity implements MatchController.onRecordEventListener{
    private EditText main_p1_ID;
    private EditText main_p2_ID;
    private EditText main_p1_fname;
    private EditText main_p2_fname;
    private EditText main_p1_lname;
    private EditText main_p2_lname;
    private EditText main_p1_age;
    private EditText main_p2_age;
    private EditText main_p1_sign;
    private EditText main_p2_sign;


    private Button main_btn_submit;

    private TextView main_txt_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initListener();


    }

    private void initListener() {
        main_btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person p1 = new Person(Long.valueOf(main_p1_ID.getText().toString()),main_p1_fname.getText().toString(),main_p1_lname.getText().toString(),Integer.valueOf(main_p1_age.getText().toString()),main_p1_sign.getText().toString());
                Person p2 = new Person(Long.valueOf(main_p2_ID.getText().toString()),main_p2_fname.getText().toString(),main_p2_lname.getText().toString(),Integer.valueOf(main_p2_age.getText().toString()),main_p2_sign.getText().toString());
                MatchBoundary matchBoundary = new MatchBoundary(p1,p2);
                MatchController.match(matchBoundary,MainActivity.this);

            }
        });
    }

    private void findViews() {
        main_p1_ID = findViewById(R.id.main_p1_id);
        main_p2_ID = findViewById(R.id.main_p2_id);

        main_p1_fname = findViewById(R.id.main_p1_fname);
        main_p2_fname = findViewById(R.id.main_p2_fname);
        main_p1_lname = findViewById(R.id.main_p1_lname);
        main_p2_lname = findViewById(R.id.main_p2_lname);
        main_p1_age = findViewById(R.id.main_p1_age);
        main_p2_age = findViewById(R.id.main_p2_age);
        main_p1_sign = findViewById(R.id.main_p1_sign);
        main_p2_sign = findViewById(R.id.main_p2_sign);
        main_btn_submit= findViewById(R.id.main_btn_submit);
        main_txt_score= findViewById(R.id.main_txt_score);
    }


    @Override
    public void onMatchReturn(double val) {
        main_txt_score.setText(val+ "%");

    }

    @Override
    public void onMatchFaild(String mess) {
        Log.d("TAG", "mess: "+mess);
    }
}