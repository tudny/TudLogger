package com.github.tudny.tudlogger;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    /**
     * Simple Logger class with some debugging functions.
     * */

    // Two default time formats
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter formatterMilis = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSSS");
    // Labels for output messages
    private static final String DEBUG = "Debug";
    private static final String ERROR = "Error";
    // Flag of displaying milliseconds
    private static Boolean withMilis = Boolean.FALSE;

    // Returns formatter depending on withMilis flag
    private static DateTimeFormatter getFormatter() {
        if (withMilis) return formatterMilis;
        else return formatter;
    }

    // Returns current time formatted to string
    private static String getTime() {
        return getFormatter().format(LocalDateTime.now());
    }

    // Displays actual message to proper out stream as well as its time and type
    private static void send(PrintStream printStream, String message, String type) {
        printStream.printf("%s | %s | %s\n", getTime(), type, message);
    }

    // Default debug log
    public static void d(String message) {
        send(System.out, message, DEBUG);
    }

    // Default error log
    public static void e(String message) {
        send(System.err, message, ERROR);
    }

    // Default error log, but also prints stack trace
    public static void e(String message, Throwable throwable) {
        e(message);
        throwable.printStackTrace();
    }

    // Sets withMilis flag
    public static void setMilis(boolean withMilis) {
        Log.withMilis = withMilis;
    }
}
