package com.github.tudny.tudlogger;

import org.junit.jupiter.api.Test;

public class LogReadmeTest {

    @Test
    void logDebug() {
        Log.d("This is my message <3");
    }

    @Test
    void logError() {
        Log.e("This is an error!");
    }

    @Test
    void logErrorWithTrace() {
        Exception someException = new Exception("Some Exception");
        Log.e("The World is collapsing", someException);
    }

    @Test
    void millisTest() {
        Log.setMilis(true);
        Log.d("This is my message without millis <3");

        Log.setMilis(false);
        Log.d("This is my message with millis <3");
    }
}
