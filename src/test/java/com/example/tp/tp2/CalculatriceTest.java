package com.example.tp.tp2;

import com.example.tp.verification.tp2.Calculatrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatriceTest {


    @Test
    public void racineCarreTest() {
        try {
            Calculatrice.racineCarree(-10);
            Assertions.fail("Une exception doit etre lever si on calcule la racine carre d'un nombre negatif");
        } catch (IllegalArgumentException aExp) {
            assert (aExp.getMessage().contains("nombre negative"));
        }
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Calculatrice.racineCarree(-10);
        });
        Assertions.assertTrue(exception.getMessage().contains("nombre negative"));
    }

    @Test()
    public void desiverTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Calculatrice.diviser(100, 0);
        });
    }

    @Test
    public void racineCarreeDansInterval_AInferieur0_Test() {
        try {
            Calculatrice.racineCarreeDansInterval(-10, 10);
            Assertions.fail("Une exception doit etre lever si on calcule la racine carre d'un nombre negatif");
        } catch (IllegalArgumentException aExp) {
            assert (aExp.getMessage().contains("nombre negative"));
        }
    }

    @Test
    public void racineCarreeDansInterval_BInferieur0_Test() {
        try {
            Calculatrice.racineCarreeDansInterval(10, -10);
            Assertions.fail("Une exception doit etre lever si on calcule la racine carre d'un nombre negatif");
        } catch (IllegalArgumentException aExp) {
            assert (aExp.getMessage().contains("nombre negative"));
        }
    }

    @Test
    public void racineCarreeDansInterval_aSuperieurB_Test() {
        try {
            Calculatrice.racineCarreeDansInterval(10, 5);
            Assertions.fail("Une exception doit etre lever si on calcule la racine carre d'un nombre negatif");
        } catch (IllegalArgumentException aExp) {
            assert (aExp.getMessage().contains("a doit etre inferieur ou egal a b"));
        }
    }

    @Test
    public void racineCarreeDansInterval_success_Test() {
        Assertions.assertDoesNotThrow(() -> {
            int a = 10;
            int b = 20;
            List<Double> Expected = List.of(3.1622776601683795, 3.3166247903554, 3.4641016151377544, 3.605551275463989, 3.7416573867739413, 3.872983346207417, 4.0, 4.123105625617661, 4.242640687119285, 4.358898943540674, 4.47213595499958);
            List<Double> result = Calculatrice.racineCarreeDansInterval(a, b);
            assertEquals(Expected, result);
        });
    }

    @Test
    public void matriceAleatoire_MInferieur0_Test() {
        try {
            Calculatrice.matriceAleatoire(-10, 10, 1, 10);
            Assertions.fail("Une exception doit etre lever si M et N sont inferieur a 0");
        } catch (IllegalArgumentException aExp) {
            assert (aExp.getMessage().contains("M et N doivent etre superieur a 0"));
        }
    }

    @Test
    public void matriceAleatoire_NInferieur0_Test() {
        try {
            Calculatrice.matriceAleatoire(10, -10, 1, 10);
            Assertions.fail("Une exception doit etre lever si M et N sont inferieur a 0");
        } catch (IllegalArgumentException aExp) {
            assert (aExp.getMessage().contains("M et N doivent etre superieur a 0"));
        }
    }

    @Test
    public void matriceAleatoire_AInferieurB_Test() {
        try {
            Calculatrice.matriceAleatoire(10, 10, 10, 1);
            Assertions.fail("Une exception doit etre lever si A est superieur a B");
        } catch (IllegalArgumentException aExp) {
            assert (aExp.getMessage().contains("A doit etre inferieur ou egal a B"));
        }
    }

    @Test
    public void matriceAleatoire_success_Test() {
        Assertions.assertDoesNotThrow(() -> {
            int M = 10;
            int N = 10;
            int A = 1;
            int B = 10;
            int[][] result = Calculatrice.matriceAleatoire(M, N, A, B);
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    assert (result[i][j] >= A && result[i][j] <= B);
                }
            }
            assertEquals(result.length, M);
            for (int[] ints : result) {
                assertEquals(ints.length, N);
            }
        });
    }
}
