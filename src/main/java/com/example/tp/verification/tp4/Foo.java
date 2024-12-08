package com.example.tp.verification.tp4;

import java.util.List;
import java.util.Scanner;

public class Foo {
    public static int foo(List<Integer> inputs) {
        int x, y, index = 1;
        x = 0;
        y = inputs.get(0);
        while (y > 100) {
            x = x + y;
            y = inputs.get(index);
            index++;
        }
        return x;
    }
}
