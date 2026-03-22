package manager;

// Klasa MenedzerNotatek.java - Zarządzanie notatkami
import model.Notatka;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa zarządzająca notatkami w aplikacji.
 * Umożliwia dodawanie, usuwanie, wyświetlanie, wyszukiwanie i sortowanie notatek.
 * Zaimplementowana zgodnie z wzorcem projektowym Singleton, aby zapewnić istnienie
 * tylko jednej instancji klasy w trakcie działania aplikacji.
 */
public class MenedzerNotatek {
    private static MenedzerNotatek instance; // Singleton
    private final List<Notatka> notatki; // Lista notatek

    /**
     * Prywatny konstruktor klasy MenedzerNotatek.
     * Inicjalizuje listę notatek.
     */
    private MenedzerNotatek() {
        notatki = new ArrayList<>();
    }

    /**
     * Zwraca jedyną instancję klasy MenedzerNotatek (wzorzec Singleton).
     *
     * @return Instancja MenedzerNotatek
     */
    public static MenedzerNotatek getInstance() {
        if (instance == null) {
            instance = new MenedzerNotatek();
        }
        return instance;
    }

    /**
     * Dodaje nową notatkę do listy.
     *
     * @param notatka Notatka do dodania
     * @throws NullPointerException jeśli notatka jest null
     */
    public void dodajNotatke(Notatka notatka) {
        notatki.add(notatka);
        System.out.println("Dodano notatkę: " + notatka.getTytul());
    }

    /**
     * Wyświetla wszystkie notatki na konsoli.
     * <p>
     * Jeśli lista notatek jest pusta, wyświetlana jest odpowiednia informacja.
     * </p>
     */
    public void wyswietlNotatki() {
        if (notatki.isEmpty()) {
            System.out.println("Brak notatek do wyświetlenia.");
        } else {
            for (Notatka notatka : notatki) {
                System.out.println(notatka);
            }
        }
    }

    /**
     * Usuwa notatkę o podanym tytule.
     *
     * @param tytul Tytuł notatki do usunięcia
     */
    public void usunNotatkePoTytule(String tytul) {
        boolean znaleziono = notatki.removeIf(notatka -> notatka.getTytul().equalsIgnoreCase(tytul));
        if (znaleziono) {
            System.out.println("Usunięto notatkę: " + tytul);
        } else {
            System.out.println("Nie znaleziono notatki o tytule: " + tytul);
        }
    }

    /**
     * Wyszukuje notatki zawierające podane słowo kluczowe w tytule lub treści.
     *
     * @param slowoKluczowe Słowo kluczowe do wyszukiwania
     */
    public void wyszukajNotatki(String slowoKluczowe) {
        boolean znaleziono = false;
        for (Notatka notatka : notatki) {
            if (notatka.getTytul().contains(slowoKluczowe) || notatka.getTresc().contains(slowoKluczowe)) {
                System.out.println(notatka);
                znaleziono = true;
            }
        }
        if (!znaleziono) {
            System.out.println("Nie znaleziono notatek zawierających: " + slowoKluczowe);
        }
    }

     /**
     * Sortuje notatki alfabetycznie po tytule (metoda publiczna inicjująca sortowanie).
     */
    public void posortujNotatkiPoTytule() {
        if (notatki.isEmpty()) {
            System.out.println("Brak notatek do posortowania.");
            return;
        }
        quickSort(notatki, 0, notatki.size() - 1);
        System.out.println("Notatki zostały posortowane alfabetycznie po tytule.");
    }

    /**
     * Implementacja algorytmu QuickSort (metoda prywatna).
     *
     * @param list Lista notatek do posortowania.
     * @param low  Indeks początkowy.
     * @param high Indeks końcowy.
     */
    private void quickSort(List<Notatka> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    /**
     * Metoda partycjonująca listę dla algorytmu QuickSort (metoda prywatna).
     *
     * @param list Lista notatek.
     * @param low  Indeks początkowy.
     * @param high Indeks końcowy.
     * @return Indeks elementu osiowego po partycjonowaniu.
     */
    private int partition(List<Notatka> list, int low, int high) {
        String pivot = list.get(high).getTytul().toLowerCase(); // Porównujemy w trybie case-insensitive
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getTytul().toLowerCase().compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    /**
     * Zamienia miejscami dwa elementy w liście.
     *
     * @param list Lista notatek
     * @param i    Indeks pierwszego elementu
     * @param j    Indeks drugiego elementu
     */
    protected void swap(List<Notatka> list, int i, int j) {
        Notatka temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * Pobiera listę notatek.
     *
     * @return Lista notatek
     */
    public List<Notatka> getNotatki() {
        return new ArrayList<>(notatki);
    }

    /**
     * Ustawia nową listę notatek.
     *
     * @param noweNotatki Lista notatek do ustawienia
     */
    public void ustawNotatki(List<Notatka> noweNotatki) {
        notatki.clear();
        notatki.addAll(noweNotatki);
    }
}