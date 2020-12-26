package com.github.tudny.tudlogger;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Tudny <a href="https://github.com/tudny">GitHub</a>
 * Java Logger for my next projects. Supports logging Debugs and Errors with System.out and System.err.
 * Also allows to decide whether user wants to show milliseconds in log or not.
 */
public class Log {

    /**
     * This is a formatter object of pattern without milliseconds.
     */
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    /**
     * This is a formatter object of pattern with milliseconds.
     */
    private static final DateTimeFormatter formatterMilis = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSSS");
    /**
     * This is a label for debug log.
     * */
    private static final String DEBUG = "Debug";
    /**
     * This is a label for error log.
     */
    private static final String ERROR = "Error";
    private static final boolean DEFAULT_MILLISECONDS_SHOW = false;
    /**
     * This is an flag which tels whether milliseconds should be displayed.
     * Default value is {@value #DEFAULT_MILLISECONDS_SHOW}.
     * */
    private static boolean withMilis = DEFAULT_MILLISECONDS_SHOW;

    /**
     * @return the formatter depending on {@link #withMilis}.
     */
    private static DateTimeFormatter getFormatter() {
        if (withMilis) return formatterMilis;
        else return formatter;
    }

    /**
     * @return formatted current time converted to string. Formatting depends on {@link #getFormatter()}.
     * */
    private static String getTime() {
        return getFormatter().format(LocalDateTime.now());
    }


    /**
     * Displays actual message to proper out stream as well as its time and type.
     * @param printStream out stream; could be any, but this class uses System.out and System.err only.
     * @param message message displayed in log.
     * @param type type of message; displayed next to the date.
     */
    private static void send(PrintStream printStream, String message, String type) {
        printStream.printf("%s | %s | %s\n", getTime(), type, message);
    }


    /**
     * Sends debug log with {@link #DEBUG} label and System.out as PrintStream.
     * @param message message displayed in log.
     */
    public static void d(String message) {
        send(System.out, message, DEBUG);
    }

    /**
     * Sends error log with {@link #ERROR} label and System.err as PrintStream.
     * @param message message displayed in log.
     */
    public static void e(String message) {
        send(System.err, message, ERROR);
    }

    /**
     * Simply runs {@link #e}, but prints stack trace as well.
     * @param message message displayed in log.
     * @param throwable exception which stack trace will be printed.
     */
    public static void e(String message, Throwable throwable) {
        e(message);
        throwable.printStackTrace();
    }


    /**
     * User can set if they want to display milliseconds in logger.
     * @param withMilisFlag true - milliseconds will be present; false - they will not
     *                  default value: {@value #DEFAULT_MILLISECONDS_SHOW}
     */
    public static void setMilis(boolean withMilisFlag) {
        Log.withMilis = withMilisFlag;
    }
}
