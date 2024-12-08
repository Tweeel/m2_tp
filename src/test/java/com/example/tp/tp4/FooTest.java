package com.example.tp.tp4;

import com.example.tp.verification.tp4.Foo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooTest {
    // Test de la méthode foo
    @Test
    public void testToutLesInstruction() {
        List<Integer> list = new ArrayList<>();
        list.add(200);
        list.add(50);
        assertEquals(200, Foo.foo(list));
    }

    @Test
    public void test2Chemins() {
        List<Integer> list = new ArrayList<>();
        list.add(200);
        list.add(200);
        list.add(50);
        assertEquals(400, Foo.foo(list));
    }
}
