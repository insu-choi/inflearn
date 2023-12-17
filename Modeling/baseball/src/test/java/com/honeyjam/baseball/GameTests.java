package com.honeyjam.baseball;

import com.honeyjam.baseball.domain.BaseballGame;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
public class GameTests {
    @Test
    void gameCreate() {
        String answer = "345";
        final int roundCount = 10;

        BaseballGame bbg = new BaseballGame(answer, roundCount);
        final String userInput = "123";
        bbg.guess(userInput);
        bbg.displayCurrentStatus();
        assertThat(bbg.isWin()).isEqualTo(false);
    }

    @Test
    void isOverAttemptCount() {
        BaseballGame bbg = new BaseballGame("789", 5);
        bbg.guess("123");
        bbg.guess("123");
        bbg.guess("123");
        bbg.guess("123");
        bbg.guess("123");
        assertThatThrownBy(() -> {
            bbg.guess("123");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("exceed");
    }

    @Test
    void isOverYouWin() {
        BaseballGame bbg = new BaseballGame("789", 5);
        bbg.guess("789");
        assertThatThrownBy(() -> {
            bbg.guess("123");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Answer");
    }

    @Test
    void gameScenario() {
        BaseballGame bbg = new BaseballGame("468");
        bbg.guess("123");
        bbg.guess("456");
        bbg.guess("789");
        bbg.guess("467");
        bbg.guess("468");
        assertThatThrownBy(() -> {
            bbg.guess("123");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("You Win");
    }

    @Test
    @DisplayName("Game 기본 생성자")
    void randomGame() {
        BaseballGame randomBbg = new BaseballGame();
        String randomNumber = randomBbg.getAnswer();
        log.info("randomNumber {}", randomNumber);
        assertThat(randomNumber.length()).isEqualTo(3);
    }
}
