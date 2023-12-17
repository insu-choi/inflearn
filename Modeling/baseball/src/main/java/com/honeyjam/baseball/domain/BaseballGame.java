package com.honeyjam.baseball.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class BaseballGame {
    String answer;
    int maxRoundCount;
    List<Stage> stageList;

    public BaseballGame(String answer, int maxRoundCount, List<Stage> stageList) {
        this.answer = answer;
        this.maxRoundCount = maxRoundCount;
        this.stageList = stageList;
    }

    public BaseballGame(String answer, int maxRoundCount) {
        this.init(answer, maxRoundCount);
    }

    public BaseballGame(int maxRoundCount) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < 3) {
            Baseball ball = new Baseball();
            String number = ball.getNumberString();
            String totalStr = sb.toString();
            if (totalStr.contains(number)) {
                continue;
            }
            sb.append(number);
            i++;
        }
        String randomAnswer = sb.toString();
        this.init(randomAnswer, maxRoundCount);
    }

    public BaseballGame(String answer) {
        this.init(answer, 10);
    }

    public BaseballGame() {
        this(10);
    }

    public void init(String answer, int maxRoundCount) {
        Assert.isTrue(answer.length() >= 3, "answer length >= 3.");
        Assert.isTrue(this.validRepetitionNumber(answer), "duplicated Number " + answer);
        Assert.isTrue(maxRoundCount > 0, "maxRoundCout > 0");
        this.answer = answer;
        this.maxRoundCount = maxRoundCount;
        this.stageList = new ArrayList<>();
    }

    public boolean validRepetitionNumber(String answer) {
        return Arrays.stream(answer.split("")).distinct().count() == answer.length();
    }

    public void guess(String userInput) {
        if (! this.stageList.isEmpty()) {
            final String message = "Answer is " + this.getAnswer() +
                    " attempts: " + this.stageList.size() +
                    "/" + this.maxRoundCount +
                    " You Win";
            Assert.isTrue(! this.isWin(), message);
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
        return (this.stageList.size() < this.maxRoundCount) &&
            (curStage.getStrike() == this.answer.length());
    }
}
