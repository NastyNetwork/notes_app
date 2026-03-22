package model;

// Klasa Element.java - Klasa bazowa dla notatek

/**
 * Klasa bazowa reprezentująca element w aplikacji.
 * Umożliwia zarządzanie tytułem elementu.
 */
public abstract class Element {
    private String tytul; // Tytuł elementu

    /**
     * Konstruktor klasy Element.
     *
     * @param tytul Tytuł elementu
     */
    public Element(String tytul) {
        this.tytul = capitalizeFirstLetter(tytul);
    }

    /**
     * Pobiera tytuł elementu.
     *
     * @return Tytuł elementu
     */
    public String getTytul() {
        return tytul;
    }

    /**
     * Ustawia nowy tytuł elementu.
     *
     * @param tytul Nowy tytuł elementu
     */
    public void setTytul(String tytul) {
        this.tytul = capitalizeFirstLetter(tytul);
    }

    /**
     * Zmienia pierwszą literę napisu na wielką.
     */
    private String capitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}