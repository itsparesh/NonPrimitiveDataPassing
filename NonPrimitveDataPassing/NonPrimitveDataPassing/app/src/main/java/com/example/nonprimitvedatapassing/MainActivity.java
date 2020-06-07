package com.example.nonprimitvedatapassing;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mainToSecondActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainToSecondActivityBtn = findViewById(R.id.mainToSecBtn);
        setOnClickListener();
    }

    private Student prepareStudentData() {

        String name = "Paresh";
        long rollNum = 1301410060;
        ArrayList<String> subjectList = new ArrayList<>();
        subjectList.add("Maths");
        subjectList.add("Data Structure");
        subjectList.add("Compiler");
        subjectList.add("Operating System");
        subjectList.add("Database");
        return new Student(name, rollNum, subjectList);
    }

    private void setOnClickListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.mainToSecBtn: {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("Student", prepareStudentData());
                        startActivity(intent);
                    }
                    break;
                }
            }
        };

        if (mainToSecondActivityBtn != null) {
            mainToSecondActivityBtn.setOnClickListener(onClickListener);
        }
    }
}
