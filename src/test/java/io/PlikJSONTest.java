package io;
import manager.MenedzerNotatek;
import model.Notatka;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Klasa testowa dla PlikJSON.
 * Testuje funkcjonalność zapisywania i odczytywania notatek do/z pliku JSON.
 */
class PlikJSONTest {
    private PlikJSON plikJSON;
    private MenedzerNotatek menedzerNotatek;

    /**
     * Inicjalizuje obiekty testowe przed każdym testem.
     * Ustawia menedżera notatek z pustą listą notatek.
     */
    @BeforeEach
    void setUp() {
        plikJSON = new PlikJSON();
        menedzerNotatek = MenedzerNotatek.getInstance();
        menedzerNotatek.ustawNotatki(List.of());
    }

    /**
     * Testuje zapisywanie i odczytywanie notatek.
     * Sprawdza, czy zapisane notatki są poprawnie odczytywane z pliku JSON.
     */
    @Test
    void testZapiszIWczytajNotatki() {
        Notatka notatka1 = new Notatka("Test1", "Treść testowa 1");
        Notatka notatka2 = new Notatka("Test2", "Treść testowa 2");
        menedzerNotatek.dodajNotatke(notatka1);
        menedzerNotatek.dodajNotatke(notatka2);

        plikJSON.zapiszNotatki(menedzerNotatek.getNotatki());

        List<Notatka> wczytaneNotatki = plikJSON.wczytajNotatki();
        assertNotNull(wczytaneNotatki, "Lista wczytanych notatek nie powinna być null.");
        assertEquals(2, wczytaneNotatki.size(), "Liczba wczytanych notatek powinna wynosić 2.");
        assertEquals("Test1", wczytaneNotatki.get(0).getTytul(), "Tytuł pierwszej notatki powinien być 'Test1'.");
    }
}
