package com.example.android.courtcounter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 * Created by irconde on 2019-10-08.
 */



public class ScoreViewModel extends ViewModel {

    private static final String SCORE_A_KEY = "scoreA";
    private static final String SCORE_B_KEY = "scoreB";
    private SavedStateHandle mState;

    // TODO 02. We have to define a constructor that receives a SavesStateHandle
    public ScoreViewModel(SavedStateHandle savedStateHandle) {
        this.mState = savedStateHandle;
    }

    // TODO 03. We create setter and getter methods.
    // TODO 04. We use module's LiveData support. Since we are using LiveData from mState, we don't
    //  need to use MutableLiveData anymore.

    public LiveData<Integer> getScoreTeamA() {

        LiveData<Integer> scoreTeamA = mState.getLiveData(SCORE_A_KEY);
        if (scoreTeamA.getValue() == null) {
            setScoreTeamA(0);
        }
        return scoreTeamA;
    }

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
