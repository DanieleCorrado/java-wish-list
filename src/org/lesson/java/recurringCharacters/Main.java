package org.lesson.java.recurringCharacters;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci una parola: ");
        String word = scanner.nextLine();

        HashMap<Character, Integer> recurrence = new HashMap<>();

        for (char character : word.toCharArray()) {

            // Se il carattere non è presente nella Map, inizializza la sua occorrenza a 1

            if (!recurrence.containsKey(character)) {
                recurrence.put(character, 1);
            } else {

                // Altrimenti, incrementa la sua occorrenza di 1

                recurrence.put(character, recurrence.get(character) + 1);
            }
        }

        for (Character carattere : recurrence.keySet()) {
            System.out.println(carattere + ": " + recurrence.get(carattere));
        }
    }
}
