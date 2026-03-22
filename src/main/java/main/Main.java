package main;

import ui.Menu;

/**
 * Główna klasa aplikacji zarządzania notatkami.
 * Uruchamia menu aplikacji.
 */
public class Main {
    /**
     * Główna metoda programu.
     * Tworzy instancję menu i uruchamia interfejs użytkownika.
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.uruchom();
    }
}