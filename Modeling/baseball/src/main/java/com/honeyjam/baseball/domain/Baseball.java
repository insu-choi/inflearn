package com.honeyjam.baseball.domain;

import org.springframework.util.Assert;

public class Baseball {
    private int number;

    public Baseball() {
        this.number = (int) (Math.random() * 10);
    }

    public Baseball(int number) {
        Assert.isTrue((0 <= number) && (number <= 9), "number is 0 ~ 9");
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
