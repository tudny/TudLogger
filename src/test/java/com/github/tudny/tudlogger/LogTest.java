package com.github.tudny.tudlogger;

import org.junit.jupiter.api.Test;

class LogTest {

    @Test
    void logThings() {
        Log.d("Hello message!");
        Log.d("Hello World");
    }

    @Test
    void logErrors() {
        Log.e("Hello error");
        Log.e("Error the world!");
    }

    private int divide(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Don't divide by zero!");
        return a / b;
    }

    @Test
    void logErrorWithStackTrace() {
        Log.e("Hello stack error", new IllegalArgumentException("I don't think so."));
        try {
            Log.d("20 / 4" + divide(20, 4));
            Log.d("7 / 0" + divide(7, 0));
        } catch (Exception e) {
            Log.e(e.getMessage(), e);
        }
    }
}