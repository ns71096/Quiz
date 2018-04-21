package com.niksharma.quiz;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView question;
    private TextView scoreText;
    private int qID = 0;
    private int Score = 0;
    private ProgressBar progressbar;
    private int PROGRESS_STEP = 10;
    private TrueFalse que;
    TrueFalse[] questionBank = new TrueFalse[]{
            new TrueFalse(R.string.question1, false),
            new TrueFalse(R.string.question2, false),
            new TrueFalse(R.string.question3, true),
            new TrueFalse(R.string.question4, false),
            new TrueFalse(R.string.question5, false),
            new TrueFalse(R.string.question6, true),
            new TrueFalse(R.string.question7, true),
            new TrueFalse(R.string.question8, false),
            new TrueFalse(R.string.question9, true),
            new TrueFalse(R.string.question10, true)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Welcome User!");
        alert.setMessage("You are about to start!\nAnswer 10 Questions Given.\nAre You Ready for the Challenge???");
        alert.setCancelable(false);
        alert.setPositiveButton("Play", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
        question = findViewById(R.id.question_textView);
        que = questionBank[qID];
        question.setText(que.getqID());


        scoreText = findViewById(R.id.score_text);
        progressbar = findViewById(R.id.progressBar);

        Button button1;
        Button button2;
        button1 = findViewById(R.id.true_button);
        button2 = findViewById(R.id.false_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                updateQuestion();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateQuestion();
            }
        });
    }

    public void checkAnswer(boolean userSelection) {
        boolean ans = que.getAnswer();

        if (ans == userSelection) {
            Score++;
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, R.string.wrong_toast, Toast.LENGTH_SHORT).show();

    }

    public void updateQuestion() {
        progressbar.setProgress(PROGRESS_STEP);
        PROGRESS_STEP = PROGRESS_STEP + 10;
        qID = (qID + 1) % 10;
        if (qID == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setCancelable(false);
            alert.setTitle("Game Finished!!!");
            alert.setMessage("You scored " + Score + " points!");
            alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert.show();
        }
        que = questionBank[qID];
        int id = que.getqID();
        question.setText(id);
        String display = "Score: " + Score + "/" + questionBank.length;
        scoreText.setText(display);

    }
}
