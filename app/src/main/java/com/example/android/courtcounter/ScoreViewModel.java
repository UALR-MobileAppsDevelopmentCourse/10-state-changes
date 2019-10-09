package com.example.android.courtcounter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by irconde on 2019-10-08.
 */
public class ScoreViewModel extends ViewModel {

    // TODO 07. Replace the int members with MutableLiveData objects
    private MutableLiveData<Integer> scoreTeamA = new MutableLiveData<>(new Integer(0));
    private MutableLiveData<Integer> scoreTeamB = new MutableLiveData<>(new Integer(0));

    // TODO 03. We create the getter and setter methods

    // TODO 08. We create the getter and setter methods of the MutableLiveData version

    public MutableLiveData<Integer> getScoreTeamA() {
        return scoreTeamA;
    }

    public void setScoreTeamA(int scoreTeamA) {
        this.scoreTeamA.setValue(scoreTeamA);
    }

    public MutableLiveData<Integer> getScoreTeamB() {
        return scoreTeamB;
    }

    public void setScoreTeamB(int scoreTeamB) {
        this.scoreTeamB.setValue(scoreTeamB);
    }

    public void increaseScoreTeamA(int value) {
        int currentScore = this.scoreTeamA.getValue();
        this.scoreTeamA.setValue(currentScore + value);
    }

    public void increaseScoreTeamB(int value) {
        int currentScore = this.scoreTeamB.getValue();
        this.scoreTeamB.setValue(currentScore + value);
    }

    public void resetScoreTeamA() {
        this.scoreTeamA.setValue(0);
    }

    public void resetScoreTeamB() {
        this.scoreTeamB.setValue(0);
    }
}
