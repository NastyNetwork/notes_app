package model;

// Klasa Notatka.java - Reprezentacja notatki

/**
 * Klasa reprezentująca pojedynczą notatkę.
 * Dziedziczy z klasy Element i dodaje treść notatki.
 */
public class Notatka extends Element {
    private String tresc; // Treść notatki

    /**
     * Konstruktor klasy Notatka.
     *
     * @param tytul Tytuł notatki
     * @param tresc Treść notatki
     */
    public Notatka(String tytul, String tresc) {
        super(tytul);
        this.tresc = tresc;
    }

    /**
     * Pobiera treść notatki.
     *
     * @return Treść notatki
     */
    public String getTresc() {
        return tresc;
    }

    /**
     * Ustawia nową treść notatki.
     *
     * @param tresc Nowa treść notatki
     */
    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    /**
     * Zwraca reprezentację tekstową notatki.
     *
     * @return Reprezentacja tekstowa notatki
     */
    @Override
    public String toString() {
        return "Tytuł: " + getTytul() + "\nTreść: " + tresc;
    }
}