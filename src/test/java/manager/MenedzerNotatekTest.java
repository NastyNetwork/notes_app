package manager;

import model.Notatka;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testy jednostkowe dla klasy MenedzerNotatek.
 */
public class MenedzerNotatekTest {

    private MenedzerNotatek menedzerNotatek;

    /**
     * Przygotowanie środowiska testowego przed każdym testem.
     * Tworzy nową instancję klasy {@link MenedzerNotatek} i czyści listę notatek.
     */
    @BeforeEach
    void setUp() {
        menedzerNotatek = MenedzerNotatek.getInstance();
        menedzerNotatek.ustawNotatki(List.of()); // Czyścimy listę notatek przed każdym testem
    }

    /**
     * Testuje metodę {@link MenedzerNotatek#dodajNotatke(Notatka)}.
     * Sprawdza, czy notatka została poprawnie dodana do listy.
     */
    @Test
    void testDodajNotatke() {
        Notatka notatka = new Notatka("Test", "To jest testowa notatka.");
        menedzerNotatek.dodajNotatke(notatka);
        assertTrue(menedzerNotatek.getNotatki().contains(notatka), "Notatka powinna zostać dodana.");
    }

    /**
     * Testuje metodę {@link MenedzerNotatek#usunNotatkePoTytule(String)}.
     * Sprawdza, czy notatka o podanym tytule została poprawnie usunięta.
     */
    @Test
    void testUsunNotatkePoTytule() {
        Notatka notatka = new Notatka("Usun", "To jest notatka do usunięcia.");
        menedzerNotatek.dodajNotatke(notatka);
        menedzerNotatek.usunNotatkePoTytule("Usun");
        assertFalse(menedzerNotatek.getNotatki().contains(notatka), "Notatka powinna zostać usunięta.");
    }

    /**
     * Testuje wyszukiwanie notatek zawierających słowo kluczowe.
     * Symuluje proces wyszukiwania poprzez filtrację listy notatek.
     */
    @Test
    void testWyszukajNotatki() {
        Notatka notatka1 = new Notatka("Pierwsza", "To jest test pierwszej notatki.");
        Notatka notatka2 = new Notatka("Druga", "To jest test drugiej notatki.");
        menedzerNotatek.dodajNotatke(notatka1);
        menedzerNotatek.dodajNotatke(notatka2);

        List<Notatka> znalezione = menedzerNotatek.getNotatki().stream()
                .filter(n -> n.getTresc().contains("test"))
                .toList();

        assertEquals(2, znalezione.size(), "Powinny zostać znalezione dwie notatki zawierające 'test'.");
    }

    /**
     * Testuje metodę {@link MenedzerNotatek#posortujNotatkiPoTytule()}.
     * Sprawdza, czy notatki zostały poprawnie posortowane alfabetycznie po tytule.
     */
    @Test
    void testSortowanieNotatekQuickSort() {
        Notatka notatka1 = new Notatka("Beta", "Druga notatka.");
        Notatka notatka2 = new Notatka("Alfa", "Pierwsza notatka.");
        Notatka notatka3 = new Notatka("Gamma", "Trzecia notatka.");

        menedzerNotatek.dodajNotatke(notatka1);
        menedzerNotatek.dodajNotatke(notatka2);
        menedzerNotatek.dodajNotatke(notatka3);

        menedzerNotatek.posortujNotatkiPoTytule();
        List<Notatka> sorted = menedzerNotatek.getNotatki();

        assertEquals("Alfa", sorted.get(0).getTytul(), "Pierwsza notatka powinna mieć tytuł 'Alfa'.");
        assertEquals("Beta", sorted.get(1).getTytul(), "Druga notatka powinna mieć tytuł 'Beta'.");
        assertEquals("Gamma", sorted.get(2).getTytul(), "Trzecia notatka powinna mieć tytuł 'Gamma'.");
    }

    /**
     * Testuje metodę {@link MenedzerNotatek#ustawNotatki(List)}.
     * Sprawdza, czy lista notatek została poprawnie ustawiona.
     */
    @Test
    void testUstawNotatki() {
        Notatka notatka1 = new Notatka("Tytul1", "Tresc1");
        Notatka notatka2 = new Notatka("Tytul2", "Tresc2");
        List<Notatka> noweNotatki = List.of(notatka1, notatka2);

        menedzerNotatek.ustawNotatki(noweNotatki);

        assertEquals(2, menedzerNotatek.getNotatki().size(), "Lista notatek powinna zawierać dwie notatki.");
        assertTrue(menedzerNotatek.getNotatki().containsAll(noweNotatki), "Nowe notatki powinny zostać ustawione.");
    }

    /**
     * Testuje metodę {@link MenedzerNotatek#swap(List, int, int)} pod kątem poprawnej zamiany
     * miejscami dwóch elementów listy. Dodaje dwie notatki do listy, wykonuje zamianę pozycji
     * i weryfikuje, czy kolejność została odwrócona zgodnie z oczekiwaniami.
     */
    @Test
    void testSwap() {
        Notatka notatka1 = new Notatka("Alfa", "Pierwsza notatka.");
        Notatka notatka2 = new Notatka("Beta", "Druga notatka.");
        menedzerNotatek.dodajNotatke(notatka1);
        menedzerNotatek.dodajNotatke(notatka2);

        // Swap dwóch notatek
        List<Notatka> lista = menedzerNotatek.getNotatki();
        menedzerNotatek.swap(lista, 0, 1);

        assertEquals(notatka2, lista.get(0), "Notatka 'Beta' powinna być teraz na pierwszym miejscu.");
        assertEquals(notatka1, lista.get(1), "Notatka 'Alfa' powinna być teraz na drugim miejscu.");
    }
}
