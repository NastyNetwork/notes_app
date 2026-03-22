package model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Klasa testowa dla klasy Notatka.
 * Testuje podstawowe metody ustawiające i pobierające treść oraz reprezentację tekstową notatki.
 */
class NotatkaTest {

    /**
     * Testuje metody getTresc() i setTresc().
     * Sprawdza poprawność ustawiania i pobierania treści notatki.
     */
    @Test
    void testGetAndSetTresc() {
        Notatka notatka = new Notatka("Tytuł", "Treść");

        assertEquals("Treść", notatka.getTresc(), "Początkowa treść powinna być 'Treść'.");

        notatka.setTresc("Nowa Treść");
        assertEquals("Nowa Treść", notatka.getTresc(), "Nowa treść powinna być 'Nowa Treść'.");
    }

    /**
     * Testuje metodę toString().
     * Sprawdza, czy metoda zwraca poprawną reprezentację tekstową notatki.
     */
    @Test
    void testToString() {
        Notatka notatka = new Notatka("Tytuł", "Treść");

        String expected = "Tytuł: Tytuł\nTreść: Treść";

        assertEquals(expected, notatka.toString(), "Reprezentacja tekstowa powinna być zgodna z oczekiwaniami.");
    }
}
