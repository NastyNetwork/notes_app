package model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Klasa testowa dla klasy Element i jej podklasy Notatka.
 * Testuje podstawową funkcjonalność metod ustawiających i pobierających dane oraz reprezentacji tekstowej.
 */
class ElementTest {

    /**
     * Testuje ustawianie i pobieranie tytułu w obiekcie Notatka.
     * Sprawdza, czy zmiana tytułu jest poprawnie przechowywana i odczytywana.
     */
    @Test
    void testSetAndGetTytul() {
        Notatka notatka = new Notatka("Tytuł", "Treść");
        notatka.setTytul("Nowy Tytuł");
        assertEquals("Nowy Tytuł", notatka.getTytul(), "Tytuł powinien zostać zmieniony na 'Nowy Tytuł'.");
    }

    /**
     * Testuje metodę toString() w obiekcie Notatka.
     * Sprawdza, czy reprezentacja tekstowa zwraca prawidłowy format zawierający tytuł i treść notatki.
     */
    @Test
    void testToString() {
        Notatka notatka = new Notatka("Tytuł", "Treść");
        assertEquals("Tytuł: Tytuł\nTreść: Treść", notatka.toString(), "Reprezentacja tekstowa powinna być w poprawnym formacie.");
    }
}
