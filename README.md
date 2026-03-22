Aplikacja do zarządzania notatkami

Projekt ma na celu stworzenie aplikacji "konsolowej" umożliwiającej użytkownikowi zarządzanie notatkami w sposób prosty, intuicyjny i funkcjonalny. Aplikacja pozwala na tworzenie, edycję, usuwanie oraz sortowanie notatek, a także na ich trwałe zapisywanie i odczytywanie z pliku w formacie JSON. Dzięki podziałowi funkcjonalności na wiele klas, kod jest łatwy w przyszłym rozwijaniu.


Funkcje programu:
- Tworzenie notatek
  (Użytkownik może tworzyć notatki, przypisując im tytuł oraz treść)

- Usuwanie notatek
  (Użytkownik może usuwać notatki na podstawie ich tytułu)

- Wyszukiwanie notatek
  (Aplikacja umożliwia przeszukiwanie notatek na podstawie słów kluczowych zawartych w tytule lub treści)

- Sortowanie notatek
  (Notatki są sortowane alfabetycznie po tytule za pomocą algorytmu QuickSort, który wykorzystuje metody partition (do podziału listy) i swap (do zamiany elementów).)

- Wyświetlanie listy notatek
  (Użytkownik może wyświetlić wszystkie zapisane notatki wraz z ich tytułami i treścią)

- Zapis i odczyt notatek z pliku JSON
  (Aplikacja umożliwia zapisanie wszystkich notatek do pliku JSON, co pozwala na ich trwałe przechowywanie.
Użytkownik może również odczytać notatki z wcześniej zapisanego pliku. Pierwsza litera w tytule notatki jest zapisywana jako wielka. Ułatwia to przyszłe sortowanie, gdy istnieją różne wielkości liter w tytule)

- Wyjście z aplikacji
  (Bezpieczne zakończenie pracy z aplikacją)

- Podstawowa obsługa błędów
  (Obsługuje nieprawidłowe dane wejściowe w menu, np. wpisanie tekstu zamiast liczby.
Wyświetla komunikaty o błędach podczas zapisywania i odczytywania plików JSON)


Architektura aplikacji:

-Klasy główne:
- Main
  (Punkt wejścia do aplikacji. Uruchamia menu)

- MenedzerNotatek
  (Centralny moduł zarządzania notatkami, pozwalający na dodawanie, usuwanie, wyszukiwanie, sortowanie i wyświetlanie notatek)

- PlikJSON
  (Klasa obsługująca zapis i odczyt notatek z pliku JSON)

- Element i Notatka
  (Klasy reprezentujące pojedyncze notatki, z których każda posiada tytuł i treść)

- Menu
  (Klasa odpowiedzialna za interacje z użytkownikiem przez menu konsolowe)

-Testy jednostkowe:

Testy zostały zaimplementowane z użyciem biblioteki JUnit, aby zapewnić niezawodność kluczowych funkcji aplikacji. Przetestowane zostały m.in.:
- Operacje na plikach JSON (zapis i odczyt notatek).
- Zarządzanie notatkami (dodawanie, usuwanie, sortowanie, wyszukiwanie).
- Funkcjonalność obiektów Notatka (pobieranie i ustawianie danych, formatowanie tekstowe).
- Poprawność działania algorytmu sortowania QuickSort, w tym poprawność działania metod partition i swap.
