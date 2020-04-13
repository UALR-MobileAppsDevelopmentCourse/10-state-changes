package com.example.android.courtcounter;

import androidx.lifecycle.ViewModel;

/**
 * Created by irconde on 2019-10-08.
 */

// TODO 02. Create a ViewModel class to hold all the data associated with the screen: ScoreViewModel
public class ScoreViewModel extends ViewModel {

    // TODO 03. We move the data-related attributes to the ViewModel class
    // Tracks the score for Team A
    private int scoreTeamA = 0;

    // Tracks the score for Team B
    private int scoreTeamB = 0;

    // TODO 04. We create the getter and setter methods

    public int getScoreTeamA() {
        return scoreTeamA;
    }

    public void setScoreTeamA(int scoreTeamA) {
        this.scoreTeamA = scoreTeamA;
    }

    public int getScoreTeamB() {
        return scoreTeamB;
    }

    public void setScoreTeamB(int scoreTeamB) {
        this.scoreTeamB = scoreTeamB;
    }

    public int increaseScoreTeamA(int score) {
        this.scoreTeamA += score;
        return scoreTeamA;
    }

    public int increaseScoreTeamB(int score) {
        this.scoreTeamB += score;
        return scoreTeamB;
    }
}
