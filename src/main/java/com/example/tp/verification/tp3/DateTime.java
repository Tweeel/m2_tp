package com.example.tp.verification.tp3;

public class DateTime extends Date {
    private int hours;
    private int minutes;
    private int seconds;

    public DateTime(int day, int month, int year, int hours, int minutes, int seconds) {
        super(day, month, year);
        isValidTime(hours, minutes, seconds);
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public DateTime addSeconds(long offsetSeconds) {
        long totalSeconds = seconds + offsetSeconds;
        long totalMinutes = minutes + (totalSeconds / 60);
        long totalHours = hours + (totalMinutes / 60);
        long totalDays = totalHours / 24;

        int newSeconds = (int) (totalSeconds % 60);
        int newMinutes = (int) (totalMinutes % 60);
        int newHours = (int) (totalHours % 24);

        DateTime result = new DateTime(day, month, year,
                newHours, newMinutes, newSeconds);

        for (int i = 0; i < totalDays; i++) {
            Date nextDay = result.getNext();
            result = new DateTime(nextDay.day, nextDay.month, nextDay.year, newHours, newMinutes, newSeconds);
        }

        return result;
    }

    private void isValidTime(int hours, int minutes, int seconds) {
        if (hours < 0 || hours >= 24) throw new IllegalArgumentException("Invalid hours, must be between 0 and 23");
        if (minutes < 0 || minutes >= 60)
            throw new IllegalArgumentException("Invalid minutes, must be between 0 and 59");
        if (seconds < 0 || seconds >= 60)
            throw new IllegalArgumentException("Invalid seconds, must be between 0 and 59");
    }
}