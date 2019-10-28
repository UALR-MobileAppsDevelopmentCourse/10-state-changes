package com.example.android.courtcounter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by irconde on 2019-10-08.
 */
public class ScoreViewModel extends ViewModel {

    private MutableLiveData<Integer> scoreTeamA = new MutableLiveData<>(new Integer(0));
    private MutableLiveData<Integer> scoreTeamB = new MutableLiveData<>(new Integer(0));

    // TODO 03. We define a SavedStateHangle member
    // TODO 04. We need to define key values to identify data to be stored in saved state

    // TODO 05. We have to define a constructor that receives a SavesStateHandle
    // TODO 06. We have to modify setter and getter methods.

    // TODO 07. We try to recover data stored in the saved state. Is there's no value we initialize it.
    public MutableLiveData<Integer> getScoreTeamA() {
        return scoreTeamA;
    }

    // TODO 08. We save the value in the saved state
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
