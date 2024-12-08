package com.example.tp.tp3;

import com.example.tp.verification.tp3.DateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateTimeTest {
    @Test
    public void testBasicTimeAddition() {
        DateTime dt = new DateTime(1, 1, 2024, 12, 30, 30);
        assertEquals(new DateTime(1, 1, 2024, 12, 30, 31),
                dt.addSeconds(1));
    }

    @Test
    public void testInvalidHours() {
        assertThrows(IllegalArgumentException.class, () ->
                new DateTime(1, 1, 2024, -1, 0, 0));
        assertThrows(IllegalArgumentException.class, () ->
                new DateTime(1, 1, 2024, 24, 0, 0));
    }

    @Test
    public void testInvalidMinutes() {
        assertThrows(IllegalArgumentException.class, () ->
                new DateTime(1, 1, 2024, 1, -1, 0));
        assertThrows(IllegalArgumentException.class, () ->
                new DateTime(1, 1, 2024, 1, 60, 0));
    }

    @Test
    public void testInvalidSeconds() {
        assertThrows(IllegalArgumentException.class, () ->
                new DateTime(1, 1, 2024, 1, 0, -1));
        assertThrows(IllegalArgumentException.class, () ->
                new DateTime(1, 1, 2024, 1, 0, 60));
    }



    @Test
    public void testSecondsOverflow() {
        DateTime dt = new DateTime(1, 1, 2024, 12, 30, 59);
        assertEquals(new DateTime(1, 1, 2024, 12, 31, 0),
                dt.addSeconds(1));
    }

    @Test
    public void testMinutesOverflow() {
        DateTime dt = new DateTime(1, 1, 2024, 12, 59, 59);
        assertEquals(new DateTime(1, 1, 2024, 13, 0, 0),
                dt.addSeconds(1));
    }

    @Test
    public void testHoursOverflow() {
        DateTime dt = new DateTime(1, 1, 2024, 23, 59, 59);
        assertEquals(new DateTime(2, 1, 2024, 0, 0, 0),
                dt.addSeconds(1));
    }

    @Test
    public void testMultipleDaysAddition() {
        DateTime dt = new DateTime(31, 12, 2023, 23, 59, 59);
        assertEquals(new DateTime(1, 1, 2024, 0, 0, 1), dt.addSeconds(2));
    }

    @Test
    public void testLargeSecondOffset() {
        DateTime dt = new DateTime(1, 1, 2024, 0, 0, 0);
        assertEquals(new DateTime(2, 1, 2024, 0, 0, 0),
                dt.addSeconds(86400)); // 24 hours in seconds
    }

    @Test
    public void testInvalidTime() {
        assertThrows(IllegalArgumentException.class, () ->
                new DateTime(1, 1, 2024, 24, 0, 0));
        assertThrows(IllegalArgumentException.class, () ->
                new DateTime(1, 1, 2024, 0, 60, 0));
        assertThrows(IllegalArgumentException.class, () ->
                new DateTime(1, 1, 2024, 0, 0, 60));
    }

    @Test
    public void testLeapYear() {
        DateTime dt = new DateTime(28, 2, 2024, 0, 0, 0);
        assertEquals(new DateTime(29, 2, 2024, 0, 0, 0),
                dt.addSeconds(86400));
    }

    @Test
    public void testNonLeapYear() {
        DateTime dt = new DateTime(28, 2, 2023, 0, 0, 0);
        assertEquals(new DateTime(1, 3, 2023, 0, 0, 0),
                dt.addSeconds(86400));
    }
}