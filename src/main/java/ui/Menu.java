package ui;

import io.PlikJSON;
import manager.MenedzerNotatek;
import model.Notatka;
import java.util.List;
import java.util.Scanner;

/**
 * Klasa odpowiedzialna za obsługę menu aplikacji.
 * Umożliwia użytkownikowi zarządzanie notatkami poprzez wybór opcji z menu.
 */
public class Menu {
    private final MenedzerNotatek menedzerNotatek;
    private final PlikJSON plikJSON;

    /**
     * Konstruktor klasy Menu.
     * Inicjalizuje obiekt {@link MenedzerNotatek} oraz {@link PlikJSON}.
     */
    public Menu() {
        menedzerNotatek = MenedzerNotatek.getInstance();
        plikJSON = new PlikJSON();
    }

    /**
     * Główna metoda uruchamiająca działanie menu.
     * Obsługuje interakcję z użytkownikiem, umożliwiając zarządzanie notatkami:
     * <ul>
     *     <li>Dodawanie nowych notatek</li>
     *     <li>Wyświetlanie wszystkich notatek</li>
     *     <li>Usuwanie notatek</li>
     *     <li>Wyszukiwanie notatek po słowach kluczowych</li>
     *     <li>Zapisywanie notatek do pliku JSON</li>
     *     <li>Wczytywanie notatek z pliku JSON</li>
     *     <li>Sortowanie notatek alfabetycznie po tytule</li>
     *     <li>Wyjście z aplikacji</li>
     * </ul>
     *
     * W przypadku błędnych danych wejściowych obsługiwane są wyjątki.
     */
    public void uruchom() {
        Scanner skaner = new Scanner(System.in);
        boolean wyjscie = false;

        System.out.println("Witaj w aplikacji do zarządzania notatkami!");

        while (!wyjscie) {
            try {
                // Wyświetlenie opcji menu
                System.out.println("\nWybierz opcję:");
                System.out.println("1. Dodaj notatkę");
                System.out.println("2. Wyświetl wszystkie notatki");
                System.out.println("3. Usuń notatkę");
                System.out.println("4. Wyszukaj notatki");
                System.out.println("5. Zapisz notatki do pliku");
                System.out.println("6. Wczytaj notatki z pliku");
                System.out.println("7. Posortuj notatki po tytule");
                System.out.println("8. Wyjście");

                int wybor = Integer.parseInt(skaner.nextLine());

                // Obsługa wybranej opcji
                switch (wybor) {
                    case 1 -> {
                        System.out.println("Podaj tytuł notatki:");
                        String tytul = skaner.nextLine();
                        System.out.println("Podaj treść notatki:");
                        String tresc = skaner.nextLine();
                        menedzerNotatek.dodajNotatke(new Notatka(tytul, tresc));
                    }
                    case 2 -> menedzerNotatek.wyswietlNotatki();
                    case 3 -> {
                        System.out.println("Podaj tytuł notatki do usunięcia:");
                        String tytul = skaner.nextLine();
                        menedzerNotatek.usunNotatkePoTytule(tytul);
                    }
                    case 4 -> {
                        System.out.println("Podaj słowo kluczowe do wyszukiwania:");
                        String slowoKluczowe = skaner.nextLine();
                        menedzerNotatek.wyszukajNotatki(slowoKluczowe);
                    }
                    case 5 -> plikJSON.zapiszNotatki(menedzerNotatek.getNotatki());
                    case 6 -> {
                        List<Notatka> wczytaneNotatki = plikJSON.wczytajNotatki();
                        if (wczytaneNotatki != null) {
                            menedzerNotatek.ustawNotatki(wczytaneNotatki);
                        }
                    }
                    case 7 -> menedzerNotatek.posortujNotatkiPoTytule();
                    case 8 -> {
                        System.out.println("Dziękujemy za skorzystanie z aplikacji. Do widzenia!");
                        wyjscie = true;
                    }
                    default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Błąd: Wprowadź poprawną liczbę jako opcję menu.");
            } catch (Exception e) {
                System.out.println("Wystąpił nieoczekiwany błąd: " + e.getMessage());
            }
        }
        skaner.close();
    }
}