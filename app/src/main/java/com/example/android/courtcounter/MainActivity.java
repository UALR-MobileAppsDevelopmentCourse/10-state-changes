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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.TextView;

/**
 * This activity keeps track of the basketball score for 2 teams.
 */

// TODO 01. Create a ViewModel class to hold all the data associated with the screen

public class MainActivity extends AppCompatActivity {

    // TODO 02. We move the data-related attributes to the ViewModel class

    // TODO 04. Create a member variable for the ViewModel in the UI Controller

    private ScoreViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO 05. Initialize ViewModel using ViewModelProvider.
        // ViewModelProvider provides ViewModels for a scope
        mViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);
        // TODO 09. Start observing LiveData object.
        // TODO 09.01. Create the observer which updates the UI
        final Observer<Integer> scoreAObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                displayForTeamA(integer);
            }
        };
        final Observer<Integer> scoreBObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                displayForTeamB(integer);
            }
        };
        // TODO 09.02. Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mViewModel.getScoreTeamA().observe(this, scoreAObserver);
        mViewModel.getScoreTeamB().observe(this, scoreBObserver);
        // TODO 10. We don't need to explicitly call displayForTeamX every time the user taps on the corresponding
        //  button to change the score

        // TODO 11. We move the data-related operations to the ViewModel

    }

    // TODO 06. Using the ViewModel in the UIController.

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        mViewModel.increaseScoreTeamA(1);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        mViewModel.increaseScoreTeamA(2);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        mViewModel.increaseScoreTeamA(3);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        mViewModel.increaseScoreTeamB( 1);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        mViewModel.increaseScoreTeamB( 2);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        mViewModel.increaseScoreTeamB( 3);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        mViewModel.resetScoreTeamA();
        mViewModel.resetScoreTeamB();
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
