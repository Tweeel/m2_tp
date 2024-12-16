package com.example.tp.tp5;

import com.example.tp.verification.tp5.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProgrammeVoitureTest {

    private ProgrammeVoiture programmeVoiture;

    @Mock
    private IPersistanceModeleVoiture persistanceMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        programmeVoiture = new ProgrammeVoiture();
        programmeVoiture.setPersistance(persistanceMock);
    }

    @Test
    public void testRechercherVoitureParMarque() {
        String marque = "Renault";
        ModeleVoiture voiture1 = new ModeleVoiture();
        voiture1.setMarque(marque);
        ModeleVoiture voiture2 = new ModeleVoiture();
        voiture2.setMarque(marque);
        List<ModeleVoiture> expectedVoitures = Arrays.asList(voiture1, voiture2);
        when(persistanceMock.searchModeleVoiture(any(CritereRerchercheModeleVoiture.class)))
                .thenReturn(expectedVoitures);
        List<ModeleVoiture> result = programmeVoiture.rechercherVoitureParMarque(marque);
        assertEquals(expectedVoitures, result);
        verify(persistanceMock).searchModeleVoiture(any(CritereRerchercheModeleVoiture.class));
    }

    @Test
    public void testRechercherVoitureParId_Success() throws TooMuchResultException {
        Long id = 1L;
        ModeleVoiture expectedVoiture = new ModeleVoiture();
        expectedVoiture.setId(id);

        when(persistanceMock.searchModeleVoitureById(id)).thenReturn(expectedVoiture);

        ModeleVoiture result = programmeVoiture.rechercherVoitureParId(id);

        assertEquals(expectedVoiture, result);
        verify(persistanceMock).searchModeleVoitureById(id);
    }

    @Test
    public void testRechercherVoitureParId_TooMuchResult() throws TooMuchResultException {
        Long id = 1L;

        when(persistanceMock.searchModeleVoitureById(id))
                .thenThrow(new TooMuchResultException());

        ModeleVoiture result = programmeVoiture.rechercherVoitureParId(id);

        assertNull(result);
        verify(persistanceMock).searchModeleVoitureById(id);
    }

    @Test
    public void testEnregisterModeleVoiture_Update() throws ErreurPersistance {
        ModeleVoiture voiture = new ModeleVoiture();
        voiture.setId(1L);

        when(persistanceMock.updateModeleVoiture(voiture)).thenReturn(true);

        boolean result = programmeVoiture.enregisterModeleVoiture(voiture);

        assertTrue(result);
        verify(persistanceMock).updateModeleVoiture(voiture);
        verify(persistanceMock, never()).addModeleVoiture(any());
    }

    @Test
    public void testEnregisterModeleVoiture_Add() throws ErreurPersistance {
        ModeleVoiture voiture = new ModeleVoiture();

        when(persistanceMock.addModeleVoiture(voiture)).thenReturn(true);

        boolean result = programmeVoiture.enregisterModeleVoiture(voiture);

        assertTrue(result);
        verify(persistanceMock).addModeleVoiture(voiture);
        verify(persistanceMock, never()).updateModeleVoiture(any());
    }

    @Test
    public void testEnregisterModeleVoiture_Error() throws ErreurPersistance {
        ModeleVoiture voiture = new ModeleVoiture();

        when(persistanceMock.addModeleVoiture(voiture))
                .thenThrow(new ErreurPersistance());

        boolean result = programmeVoiture.enregisterModeleVoiture(voiture);

        assertFalse(result);
        verify(persistanceMock).addModeleVoiture(voiture);
    }
}
