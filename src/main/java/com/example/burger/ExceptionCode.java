package com.example.burger;

import lombok.Getter;

public enum ExceptionCode {

    BURGER_NOT_FOUND(404, "Burger not found");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
