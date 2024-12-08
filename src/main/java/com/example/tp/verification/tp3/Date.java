package com.example.tp.verification.tp3;

public class Date {
    int day;
    int month;
    int year;

    public Date(int day, int month, int year) {
        isValidDate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date getNext() {
        int nextDay = day + 1;
        int nextMonth = month;
        int nextYear = year;

        if (nextDay > getDaysInMonth(month, year)) {
            nextDay = 1;
            nextMonth++;
            if (nextMonth > 12) {
                nextMonth = 1;
                nextYear++;
            }
        }

        return new Date(nextDay, nextMonth, nextYear);
    }

    private void isValidDate(int day, int month, int year) {
        if (year < 1582 || year > 3000) throw new IllegalArgumentException("Invalid year, must be between 1582 and 3000");
        if (month < 1 || month > 12) throw new IllegalArgumentException("Invalid month, must be between 1 and 12");
        if (day < 1 || day > getDaysInMonth(month, year)) throw new IllegalArgumentException("Invalid day, for this month the day must be between 1 and " + getDaysInMonth(month, year));
    }

    private int getDaysInMonth(int month, int year) {
        return switch (month) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> 31;
        };
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Date other)) return false;
        return day == other.day && month == other.month && year == other.year;
    }
}
