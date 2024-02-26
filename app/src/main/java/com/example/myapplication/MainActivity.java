package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText bbit2310score;

    EditText bisf1100score;

    EditText bsd2300score;

    EditText bbit1204score;

    EditText bit1102score;

    EditText bbit2310grade;

    EditText bisf1100grade;

    EditText bsd2300grade;

    EditText bbit1204grade;

    EditText bit1102grade;

    Button generate;

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bbit2310score = findViewById(R.id.bbit2310score);
        bbit2310grade = findViewById(R.id.bbit2310grade);
        bisf1100score = findViewById(R.id.bisf1100score);
        bisf1100grade = findViewById(R.id.bisf1100grade);
        bsd2300score = findViewById(R.id.bsd2300score);
        bsd2300grade = findViewById(R.id.bsd2300grade);
        bbit1204score = findViewById(R.id.bbit1204score);
        bbit1204grade = findViewById(R.id.bbit1204grade);
        bit1102score = findViewById(R.id.bit1102score);
        bit1102grade = findViewById(R.id.bit1102grade);
        generate = findViewById(R.id.generate);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "The generate button was clicked...");


                //Get All the scores
                String bbit2310scoreInputTxt = bbit2310score.getText().toString();
                String bisf1100scoreInputTxt = bisf1100score.getText().toString();
                String bsd2300scoreInputTxt = bsd2300score.getText().toString();
                String bbit1204scoreInputTxt = bbit1204score.getText().toString();
                String bit1102scoreInputTxt = bit1102score.getText().toString();


                //convert all the scores to grades
                String bbit2310gradeValue = convertScoreToGrade(bbit2310scoreInputTxt);
                String bisf1100gradeValue = convertScoreToGrade(bisf1100scoreInputTxt);
                String bsd2300gradeValue = convertScoreToGrade(bsd2300scoreInputTxt);
                String bbit1204gradeValue = convertScoreToGrade(bbit1204scoreInputTxt);
                String bit1102gradeValue = convertScoreToGrade(bit1102scoreInputTxt);


                //display the grades
                bbit2310grade.setText(bbit2310gradeValue);
                bisf1100grade.setText(bisf1100gradeValue);
                bsd2300grade.setText(bsd2300gradeValue);
                bbit1204grade.setText(bbit1204gradeValue);
                bit1102grade.setText(bit1102gradeValue);


            }
        });
    }

    private String convertScoreToGrade(String scoreStr) {

        String grade = "Invalid";

        try {
            int score = Integer.parseInt(scoreStr);

            if (score <= 39) {
                grade = "F";
            }
            if (score >= 40 && score <= 49) {
                grade = "D";
            }
            if (score >= 50 && score <= 59) {
                grade = "C";
            }
            if (score >= 60 && score <= 69) {
                grade = "B";
            }
            if (score >= 70 && score <= 100) {

                grade = "A";
            }

        } catch (Exception ex) {
            Log.d(TAG, "Trying to convert empty string to int " + ex.getMessage());

        }
        return grade;
    }

}

