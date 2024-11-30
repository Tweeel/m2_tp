package com.example.tp.tp1;

import com.example.tp.verification.tp1.SommeArgent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SommeArgentTest {

    @Test
    public void addTest() {
        SommeArgent m1= new SommeArgent(12,"DINARS");
        SommeArgent m2= new SommeArgent(14, "DINARS");
        SommeArgent expected = new SommeArgent(26, "DINARS");
        SommeArgent result = m1.add(m2); // (2)
        assertEquals(expected,result);
    }

    @Test
    public void equalsTest() {
        SommeArgent m1= new SommeArgent(12, "DINARS");
        SommeArgent m2= new SommeArgent(14, "DINARS");
        SommeArgent m3= new SommeArgent(14, "EURO");
        assertNotNull(m1);
        assertEquals(new SommeArgent(12, "DINARS"), m1); // (1)
        assertNotEquals(m1, m2);
        assertNotEquals(m3, m2);
    }
}