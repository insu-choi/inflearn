package com.honeyjam.baseball;

import com.honeyjam.baseball.domain.Stage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StageTests {
    @Test
    @DisplayName("stage에서 스트라이크 가져오기")
    void stageGetStrike() {
        Stage s = new Stage("345");
        final boolean isCorrect = s.is("345");
        log.info("isCorrect {}", isCorrect);
        assertThat(isCorrect).isEqualTo(true);
        final int strike = s.getStrike();
        log.info("strike {}", strike);
        assertThat(strike).isEqualTo(3);
    }

    @Test
    @DisplayName("strike 확인")
    void getStrike() {
        Stage s = new Stage("345");
        s.is("345");
        int strike = s.getStrike();
        log.info("strike {}", strike);
        assertThat(strike).isEqualTo(3);
    }

    @Test
    @DisplayName("ball 확인")
    void getBall() {
        Stage s = new Stage("345");
        s.is("453");
        int ball = s.getBall();
        log.info("ball {}", ball);
        assertThat(ball).isEqualTo(3);
    }

    @Test
    @DisplayName("strike and ball 확인")
    void getStrikeAndBall() {
        Stage s = new Stage("345");
        s.is("354");
        int strike = s.getStrike();
        int ball = s.getBall();
        log.info("strike {}, ball {}", strike, ball);
        assertThat(strike).isEqualTo(1);
        assertThat(ball).isEqualTo(2);
    }

}
