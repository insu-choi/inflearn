package com.honeyjam.baseball.domain;

import lombok.Getter;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BaseballGame {
    String answer;
    int maxRoundCount;
    List<Stage> stageList;

    public BaseballGame(String answer, int maxRoundCout) {
        Assert.isTrue(answer.length() >= 3, "answer length >= 3.");
        Assert.isTrue(maxRoundCout > 0, "maxRoundCout > 0");
        this.answer = answer;
        this.maxRoundCount = maxRoundCout;
        this.stageList = new ArrayList<>();
    }

    public BaseballGame(String answer) {
        this(answer, 10);
    }

    public BaseballGame(int maxRoundCount) {
        this("345", maxRoundCount);
    }

    public void guess(String userInput) {
        if (!this.stageList.isEmpty()) {
            Stage lastStage = this.stageList.get(this.stageList.size() - 1);
            Assert.isTrue(!this.isWin(), "Answer is " + this.getAnswer() + " attempts: " + this.getMaxRoundCount());
        }
        Assert.isTrue(this.stageList.size() < this.maxRoundCount, "exceed the number of attempts");
        Stage s = new Stage(this.answer);
        s.is(userInput);
        this.stageList.add(s);
        this.displayCurrentStatus();
    }

    public void displayCurrentStatus() {
        Stage curStage = this.stageList.get(this.stageList.size() - 1);
        curStage.displayStatus();
    }

    public boolean isWin() {
        if (this.stageList.isEmpty()) {
            return false;
        }
        Stage curStage = this.stageList.get(this.stageList.size() - 1);
        return (curStage.getStrike() == this.answer.length());
    }
}
