package com.honeyjam.baseball;

import com.honeyjam.baseball.domain.Baseball;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class BaseballTests {

    @Test
    void baseballRandomNumber() {
        Baseball baseball = new Baseball();
        int number = baseball.getNumber();
        log.info("number {}", number);
        assertThat(number).isBetween(0, 9);
    }

    @Test
    @DisplayName("Bassball 생성자")
    void baseballConstructor() {
        Baseball b = new Baseball(3);
        assertThat(b.getNumber()).isEqualTo(3);
    }

}
