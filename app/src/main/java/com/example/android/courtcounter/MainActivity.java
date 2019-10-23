/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.courtcounter;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.TextView;

/**
 * This activity keeps track of the basketball score for 2 teams.
 */

// TODO 02. Create a ViewModel class to hold all the data associated with the screen: ScoreViewModel

public class MainActivity extends AppCompatActivity {

    // TODO 03. We move the data-related attributes to the ViewModel class

    // TODO 05. Create a member variable for the ViewModel in the UI Controller

    private ScoreViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO 06. Initialize ViewModel using ViewModelProvider.
        // ViewModelProvider provides ViewModels for a scope
        mViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);
    }

    // TODO 07. Using the ViewModel in the UIController.

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        mViewModel.setScoreTeamA(mViewModel.getScoreTeamA() + 1);
        displayForTeamA(mViewModel.getScoreTeamA());
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        mViewModel.setScoreTeamA(mViewModel.getScoreTeamA() + 2);
        displayForTeamA(mViewModel.getScoreTeamA());
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        mViewModel.setScoreTeamA(mViewModel.getScoreTeamA() + 3);
        displayForTeamA(mViewModel.getScoreTeamA());
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        mViewModel.setScoreTeamB(mViewModel.getScoreTeamB() + 1);
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        mViewModel.setScoreTeamB(mViewModel.getScoreTeamB() + 2);
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        mViewModel.setScoreTeamB(mViewModel.getScoreTeamB() + 3);
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        mViewModel.setScoreTeamA(0);
        mViewModel.setScoreTeamB(0);
        displayForTeamA(mViewModel.getScoreTeamA());
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
