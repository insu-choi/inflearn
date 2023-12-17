package com.honeyjam.baseball.domain;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Objects;

@Slf4j
@Getter
public class Stage {
    private final String answer;
    private int strike;
    private int ball;

    public Stage(String answer) {
        Assert.isTrue(answer.length() >= 3, "Stage Answer length >= 3");
        this.answer = answer;
    }

    public boolean is(String target) {
        this.compareTargetToAnswer(target);
        return Objects.equals(this.answer, target);
    }

    public void compareTargetToAnswer(final String userInput) {
        int[] answerIntArr = this.convertStringArrayToIntArray(this.answer);
        int[] userInputIntArr = this.convertStringArrayToIntArray(userInput);

        for (int i = 0; i < answerIntArr.length; i++) {
            for (int j = 0; j < userInputIntArr.length; j++) {
                int answerInt = answerIntArr[i];
                int userInputInt = userInputIntArr[j];
                if (answerInt == userInputInt) {
                    if (i == j) {
                        this.strike += 1;
                    } else {
                        this.ball += 1;
                    }
                    break;
                }
            }
        }
    }

    private static int[] convertStringArrayToIntArray(String answer) {
        String[] answerArr = answer.split("");
        return Arrays.stream(answerArr).mapToInt(Integer::parseInt).toArray();
    }

    public void displayStatus() {
        log.info("strike {}, ball {}", this.getStrike(), this.getBall());
    }
}
