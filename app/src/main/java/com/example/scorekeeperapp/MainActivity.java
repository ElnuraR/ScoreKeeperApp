package com.example.scorekeeperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    int finalScoreTeamA = 0;
    int finalScoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkScore(scoreTeamA, scoreTeamB);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addForTeamA(View v) {
        if (checkScore(scoreTeamA, scoreTeamB)) {
            scoreTeamA += 1;
            displayForTeamA(scoreTeamA);
        }
        else {
            displayTable(v);
            resetScore(v);
        }
    }

    public boolean checkScore(int scoreTeamA, int scoreTeamB) {
        return (scoreTeamA < 15 || scoreTeamA < scoreTeamB + 2) && (scoreTeamB < 15 || scoreTeamB < scoreTeamA + 2);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score of First Set for Team A.
     */
    public void displayFirstForTeamA(int score) {
        if (!checkScore(scoreTeamA, scoreTeamB)) {
            TextView scoreView = (TextView) findViewById(R.id.a_first_score);
            scoreView.setText(String.valueOf(score));
            finalScoreTeamA += scoreTeamA;
        }
        else {
            TextView scoreView = (TextView) findViewById(R.id.a_first_score);
            scoreView.setText(String.valueOf(0));
        }
    }

    /**
     * Displays the given score of Second Set for Team A.
     */
    public void displaySecondForTeamA(int score) {
        if (!checkScore(scoreTeamA, scoreTeamB)) {
            TextView scoreView = (TextView) findViewById(R.id.a_second_score);
            scoreView.setText(String.valueOf(score));
            finalScoreTeamA += scoreTeamA;
        }
        else {
            TextView scoreView = (TextView) findViewById(R.id.a_second_score);
            scoreView.setText(String.valueOf(0));
        }
    }

    /**
     * Displays the given score of Third Set for Team A.
     */
    public void displayThirdForTeamA(int score) {
        if (!checkScore(scoreTeamA, scoreTeamB)) {
            TextView scoreView = (TextView) findViewById(R.id.a_third_score);
            scoreView.setText(String.valueOf(score));
            finalScoreTeamA += scoreTeamA;
        }
        else {
            TextView scoreView = (TextView) findViewById(R.id.a_third_score);
            scoreView.setText(String.valueOf(0));
        }
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addForTeamB(View v) {
        if (checkScore(scoreTeamA, scoreTeamB)) {
            scoreTeamB += 1;
            displayForTeamB(scoreTeamB);
        }
        else {
            displayTable(v);
            resetScore(v);
        }
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score of Fisrt Set for Team B.
     */
    public void displayFirstForTeamB(int score) {
        if (!checkScore(scoreTeamA, scoreTeamB)) {
            TextView scoreView = (TextView) findViewById(R.id.b_first_score);
            scoreView.setText(String.valueOf(score));
            finalScoreTeamB += scoreTeamB;
        }
        else {
            TextView scoreView = (TextView) findViewById(R.id.b_first_score);
            scoreView.setText(String.valueOf(0));
        }
    }

    /**
     * Displays the given score of Second Set for Team A.
     */
    public void displaySecondForTeamB(int score) {
        if (!checkScore(scoreTeamA, scoreTeamB)) {
            TextView scoreView = (TextView) findViewById(R.id.b_second_score);
            scoreView.setText(String.valueOf(score));
            finalScoreTeamB += scoreTeamB;
        }
        else {
            TextView scoreView = (TextView) findViewById(R.id.b_second_score);
            scoreView.setText(String.valueOf(0));
        }
    }

    /**
     * Displays the given score of Third Set for Team A.
     */
    public void displayThirdForTeamB(int score) {
        if (!checkScore(scoreTeamA, scoreTeamB)) {
            TextView scoreView = (TextView) findViewById(R.id.b_third_score);
            scoreView.setText(String.valueOf(score));
            finalScoreTeamB += scoreTeamB;
        }
        else {
            TextView scoreView = (TextView) findViewById(R.id.b_third_score);
            scoreView.setText(String.valueOf(0));
        }
    }

    /**
     * Reset the score for both teams
     */
    public void resetScore(View v) {
        scoreTeamA = scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Reset the score for the whole game
     */
    public void resetGame(View v) {
        resetScore(v);

        TextView aScoreView1 = (TextView) findViewById(R.id.a_first_score);
        aScoreView1.setText(String.valueOf(0));

        TextView aScoreView2 = (TextView) findViewById(R.id.a_second_score);
        aScoreView2.setText(String.valueOf(0));

        TextView aScoreView3 = (TextView) findViewById(R.id.a_third_score);
        aScoreView3.setText(String.valueOf(0));

        TextView bScoreView1 = (TextView) findViewById(R.id.b_first_score);
        bScoreView1.setText(String.valueOf(0));

        TextView bScoreView2 = (TextView) findViewById(R.id.b_second_score);
        bScoreView2.setText(String.valueOf(0));

        TextView bScoreView3 = (TextView) findViewById(R.id.b_third_score);
        bScoreView3.setText(String.valueOf(0));

        TextView resultView = (TextView) findViewById(R.id.result);
        resultView.setText("");

    }

    /**
     * Display the final result
     */
    @SuppressLint("SetTextI18n")
    public void displayResult(View v) {
        TextView resultView = (TextView) findViewById(R.id.result);

        if (finalScoreTeamA > finalScoreTeamB) {
            resultView.setText("Team A is a winner!");
        }
        else {
            resultView.setText("Team B is a winner!");
        }
    }

    /**
     * Display the score for both teams of each Set
     */
    public void displayTable(View v) {
        TextView aScoreView1 = (TextView) findViewById(R.id.a_first_score);
        String aStrScore1 = aScoreView1.getText().toString();

        TextView aScoreView2 = (TextView) findViewById(R.id.a_second_score);
        String aStrScore2 = aScoreView2.getText().toString();

        TextView aScoreView3 = (TextView) findViewById(R.id.a_third_score);
        String aStrScore3 = aScoreView3.getText().toString();

        if (aStrScore1.equals("0")) {
            displayFirstForTeamA(scoreTeamA);
            displayFirstForTeamB(scoreTeamB);
        }
        else if (aStrScore2.equals("0")) {
            displaySecondForTeamA(scoreTeamA);
            displaySecondForTeamB(scoreTeamB);
        }
        else if (aStrScore3.equals("0")){
            displayThirdForTeamA(scoreTeamA);
            displayThirdForTeamB(scoreTeamB);
            displayResult(v);
        }
        else {
            resetScore(v);
        }
    }
}