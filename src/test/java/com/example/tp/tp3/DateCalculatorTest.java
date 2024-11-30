package com.example.tp.tp3;

import com.example.tp.verification.tp3.Date;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DateCalculatorTest {

    @Test
    public void testValidDateRanges() {
        // Test valid dates
        assertDoesNotThrow(() -> new Date(1, 1, 2000).getNext());
    }

    @Test
    public void testInvalidMonthsRanges() {
        // Test invalid months
        assertThrows(IllegalArgumentException.class, () ->
                new Date(1, 0, 2000).getNext());
        assertThrows(IllegalArgumentException.class, () ->
                new Date(1, 13, 2000).getNext());
    }

    @Test
    public void testInvalidYearsRanges() {
        // Test invalid years
        assertThrows(IllegalArgumentException.class, () ->
                new Date(1, 1, 1581).getNext());
        assertThrows(IllegalArgumentException.class, () ->
                new Date(1, 1, 3001).getNext());
    }

    @Test
    public void testInvalidDaysRanges() {
        // Test invalid days
        assertThrows(IllegalArgumentException.class, () ->
                new Date(0, 1, 2000).getNext());
        assertThrows(IllegalArgumentException.class, () ->
                new Date(32, 1, 2000).getNext());
    }

    @Test
    public void testRegularDayTransition() {
        Date date = new Date(15, 3, 2024);
        Date next = date.getNext();
        assertEquals(new Date(16, 3, 2024), next);
    }

    @Test
    public void testMonthTransition() {
        Date date = new Date(31, 3, 2024);
        Date next = date.getNext();
        assertEquals(new Date(1, 4, 2024), next);
    }

    @Test
    public void testYearTransition() {
        Date date = new Date(31, 12, 2024);
        Date next = date.getNext();
        assertEquals(new Date(1, 1, 2025), next);
    }

    @Test
    public void testLeapYear() {
        // Test February 28th on leap year
        Date leapDate = new Date(28, 2, 2024);
        assertEquals(new Date(29, 2, 2024), leapDate.getNext());
    }

    @Test
    public void testNonLeapYear() {
        // Test February 28th on non-leap year
        Date nonLeapDate = new Date(28, 2, 2023);
        assertEquals(new Date(1, 3, 2023), nonLeapDate.getNext());
    }

    @Test
    public void test30DaysMonthBoundaries() {
        // Test 30-day months
        Date april = new Date(30, 4, 2024);
        assertEquals(new Date(1, 5, 2024), april.getNext());
    }

    @Test
    public void test31DaysMonthBoundaries() {
        // Test 31-day months
        Date july = new Date(31, 7, 2024);
        assertEquals(new Date(1, 8, 2024), july.getNext());
    }
}