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

    @Test
    public void testFebruaryLeapYearCases() {
        assertDoesNotThrow(() -> new Date(29, 2, 2024));
        assertDoesNotThrow(() -> new Date(29, 2, 2000));
        assertThrows(IllegalArgumentException.class, () ->
                new Date(29, 2, 1900));
    }

    @Test
    public void testFebruaryNonLeapYearCases() {
        assertThrows(IllegalArgumentException.class, () ->
                new Date(29, 2, 2023));
        assertDoesNotThrow(() -> new Date(28, 2, 2023));
    }

    @Test
    public void testMonthBoundariesForAllMonths() {
        assertThrows(IllegalArgumentException.class, () ->
                new Date(31, 4, 2024));
        assertThrows(IllegalArgumentException.class, () ->
                new Date(31, 6, 2024));
        assertThrows(IllegalArgumentException.class, () ->
                new Date(31, 9, 2024));
        assertThrows(IllegalArgumentException.class, () ->
                new Date(31, 11, 2024));

        // Test transitions at month ends
        assertEquals(new Date(1, 5, 2024), new Date(30, 4, 2024).getNext());
        assertEquals(new Date(1, 7, 2024), new Date(30, 6, 2024).getNext());
        assertEquals(new Date(1, 10, 2024), new Date(30, 9, 2024).getNext());
        assertEquals(new Date(1, 12, 2024), new Date(30, 11, 2024).getNext());
    }

    @Test
    public void testEqualsMethod() {
        Date date1 = new Date(15, 3, 2024);
        Date date2 = new Date(15, 3, 2024);
        Date date3 = new Date(16, 3, 2024);
        Date date4 = new Date(15, 4, 2024);
        Date date5 = new Date(15, 3, 2023);

        assertEquals(date1, date2);

        assertNotEquals(date1, date3);
        assertNotEquals(date1, date4);
        assertNotEquals(date1, date5);

        assertNotEquals(date1, null);

        assertNotEquals(date1, "not a date");
    }

    @Test
    public void testEdgeCaseDates() {
        assertDoesNotThrow(() -> new Date(1, 1, 1582));
        assertDoesNotThrow(() -> new Date(31, 12, 3000));
        Date endOf1999 = new Date(31, 12, 1999);
        assertEquals(new Date(1, 1, 2000), endOf1999.getNext());
    }
}