package io;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Notatka;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Klasa odpowiedzialna za operacje na plikach JSON.
 * Umożliwia zapis i odczyt listy notatek do/z pliku JSON.
 */
public class PlikJSON {
    private static final String NAZWA_PLIKU = "notatki.json";

    /**
     * Zapisuje listę notatek do pliku JSON.
     *
     * @param notatki Lista notatek do zapisania
     */
    public void zapiszNotatki(List<Notatka> notatki) {
        try (Writer writer = new FileWriter(NAZWA_PLIKU)) {
            Gson gson = new Gson();
            gson.toJson(notatki, writer);
            System.out.println("Zapisano notatki do pliku " + NAZWA_PLIKU);
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisywania notatek: " + e.getMessage()); // Zmiana na System.err
        }
    }

/**
     * Odczytuje listę notatek z pliku JSON.
     *
     * @return Lista notatek, lub null, jeśli wystąpił błąd lub plik nie istnieje.
     */
    public List<Notatka> wczytajNotatki() {
        try (Reader reader = new FileReader(NAZWA_PLIKU)) {
            Gson gson = new Gson();
            Type typListy = new TypeToken<List<Notatka>>() {}.getType();
            return gson.fromJson(reader, typListy);
        } catch (FileNotFoundException e) {
            System.out.println("Plik " + NAZWA_PLIKU + " nie istnieje."); // Zmiana na System.err
        } catch (IOException e) {
            System.out.println("Błąd podczas wczytywania notatek: " + e.getMessage()); // Zmiana na System.err
        }
        return null;
    }
}