package com.example.nonprimitvedatapassing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    private TextView nameTV;
    private TextView rollNumTV;
    private TextView subjectsTV;
    private Button secToMainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getLayoutId();
        collectData();
        setOnClickListener();
    }

    private void getLayoutId() {
        nameTV = findViewById(R.id.nameTV);
        rollNumTV = findViewById(R.id.rollNumTV);
        subjectsTV = findViewById(R.id.subjectsTV);
        secToMainBtn = findViewById(R.id.secToMainBtn);
    }

    private void collectData() {
        Intent intent = getIntent();
        if (intent != null) {
            Student student = intent.getParcelableExtra("Student");
            setDataIntoTextViews(student);
        }
    }

    private void setDataIntoTextViews(Student student) {
        if (student != null) {
            nameTV.setText(student.getName());
            rollNumTV.setText(String.format(Locale.ENGLISH, "%d", student.getRollNum()));
            subjectsTV.setText((Arrays.toString(student.getSubjects().toArray())).replace("[", "")  //remove the right bracket
                    .replace("]", "")  //remove the left bracket
                    .trim());
        }
    }

    private void setOnClickListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.secToMainBtn: {
                        finish();
                    }
                    break;
                }
            }
        };

        if (secToMainBtn != null) {
            secToMainBtn.setOnClickListener(onClickListener);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
