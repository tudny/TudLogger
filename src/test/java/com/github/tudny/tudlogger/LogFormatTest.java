package com.github.tudny.tudlogger;

import org.junit.jupiter.api.Test;

public class LogFormatTest {
    @Test
    void logThings() {
        Log.df("Hello %s!", "message");
        Log.df("Hello %s", "World");
    }

    @Test
    void logErrors() {
        Log.ef("Hello error %d", 123);
        Log.ef("Error the world! %d", 645);
    }

    private int divide(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Don't divide by zero!");
        return a / b;
    }

    @Test
    void logErrorWithStackTrace() {
        Exception exception = new IllegalArgumentException("I don't think so.");
        Log.ef(exception, "Hello %s %d", "stack exception", 25349780);
        try {
            Log.d("20 / 4" + divide(20, 4));
            Log.d("7 / 0" + divide(7, 0));
        } catch (Exception e) {
            Log.e(e.getMessage(), e);
        }
    }
}
