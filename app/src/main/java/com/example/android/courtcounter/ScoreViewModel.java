package com.example.android.courtcounter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 * Created by irconde on 2019-10-08.
 */



public class ScoreViewModel extends ViewModel {

    // TODO 05. We need to define key values to identify data to be stored in saved state
    private static final String SCORE_A_KEY = "scoreA";
    private static final String SCORE_B_KEY = "scoreB";

    // TODO 04. We define a SavedStateHangle member
    private SavedStateHandle mState;

    // TODO 03. We configure the defined ViewModel to receive a SavedStateHandle object through the constructor
    public ScoreViewModel(SavedStateHandle savedStateHandle) {
        this.mState = savedStateHandle;
    }

    // TODO 06. We have to modify setter and getter methods.
    // TODO 07. We try to recover data stored in the saved state. Is there's no value we initialize it.

    public LiveData<Integer> getScoreTeamA() {

        LiveData<Integer> scoreTeamA = mState.getLiveData(SCORE_A_KEY);
        if (scoreTeamA.getValue() == null) {
            setScoreTeamA(0);
        }
        return scoreTeamA;
    }

    // TODO 08. We save the value in the saved state

    public void setScoreTeamA(int scoreTeamA) {
        this.mState.set(SCORE_A_KEY, scoreTeamA);
    }

    public LiveData<Integer> getScoreTeamB() {
        LiveData<Integer> scoreTeamB = mState.getLiveData(SCORE_B_KEY);
        if (scoreTeamB.getValue() == null) {
            setScoreTeamB(0);
        }
        return scoreTeamB;
    }

    public void setScoreTeamB(int scoreTeamB) {
        this.mState.set(SCORE_B_KEY, scoreTeamB);
    }

    public void increaseScoreTeamA(int value) {
        int currentScore = getScoreTeamA().getValue().intValue();
        setScoreTeamA(currentScore + value);
    }

    public void increaseScoreTeamB(int value) {
        int currentScore = getScoreTeamB().getValue().intValue();
        setScoreTeamB(currentScore + value);
    }

    public void resetScoreTeamA() {
        setScoreTeamA(0);
    }

    public void resetScoreTeamB() {
        setScoreTeamB(0);
    }
}
