package com.example.tp.tp1;

import com.example.tp.verification.tp1.PorteMonnaie;
import com.example.tp.verification.tp1.SommeArgent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PorteMonnaieTest {

    @Test
    void ajouterSomme_isAddingValuesCorrectly() {
        PorteMonnaie porteMonnaie = new PorteMonnaie();
        SommeArgent euro1 = new SommeArgent(2, "Euro");
        SommeArgent dinnar1 = new SommeArgent(2, "Dinnar");
        SommeArgent euro2 = new SommeArgent(2, "Euro");

        porteMonnaie.ajouterSomme(euro1);
        porteMonnaie.ajouterSomme(dinnar1);
        porteMonnaie.ajouterSomme(euro2);

        assertEquals(4, porteMonnaie.getContenu().get("Euro"));
        assertEquals(2, porteMonnaie.getContenu().get("Dinnar"));
    }

    @Test
    public void equalsTest() {
        PorteMonnaie porteMonnaie = new PorteMonnaie();
        PorteMonnaie porteMonnaie2 = new PorteMonnaie();

        SommeArgent euro1 = new SommeArgent(2, "Euro");
        SommeArgent dinnar1 = new SommeArgent(2, "Dinnar");
        SommeArgent euro2 = new SommeArgent(2, "Euro");

        porteMonnaie.ajouterSomme(euro1);
        porteMonnaie.ajouterSomme(dinnar1);
        porteMonnaie.ajouterSomme(euro2);

        porteMonnaie2.ajouterSomme(euro1);
        porteMonnaie2.ajouterSomme(dinnar1);
        porteMonnaie2.ajouterSomme(euro2);

        assertEquals(porteMonnaie, porteMonnaie2);

        porteMonnaie2.ajouterSomme(dinnar1);

        assertNotEquals(porteMonnaie, porteMonnaie2);

    }
}