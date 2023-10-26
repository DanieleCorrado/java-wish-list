package org.lesson.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        ArrayList<Present> presentsList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        // Controllo se il file presentsList esiste

        File list = new File("./resources/presentsList.txt");

        if(list.exists()) {

            // Se esiste controllo tutte le righe del file e aggiungo i regali presenti nella lista presentsList

            Scanner fileReader = null;
            try {
                fileReader = new Scanner(list);
                System.out.println("The presentsList file contains:");
                while (fileReader.hasNextLine()) {
                    String[] item = fileReader.nextLine().split(";");
                    System.out.println("Reciver: " + item[0]);
                    System.out.println("Present description: " + item[1]);
                    System.out.println("----------------");
                    Present present = new Present(item[0], item[0]);
                    presentsList.add(present);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            } finally {
                try {
                    if (fileReader != null) {
                        System.out.println("File closed!");
                        fileReader.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // Chiedo all'utente se vuole aggiungere altri regali

        while (!exit) {

            System.out.println("La lista contiene " + presentsList.size() + " regali.");

            System.out.print("Add new present? (y/n): ");
            exit = scanner.nextLine().equalsIgnoreCase("n");

            if (!exit) {

                System.out.print("Reciver: ");
                String receiver = scanner.nextLine();
                System.out.print("Description: ");
                String description = scanner.nextLine();

                Present present = new Present(receiver, description );

                presentsList.add(present);
            }
        }

        // Stampo della lista

        System.out.println("La lista dei regali è:");
        for (Present present : presentsList) {
            System.out.println(present);
        }

        // Scrivo la lista dei regali su un file

        FileWriter writer = null;
        File dir = new File("./resources");

        try {
            // Controllo se la directory resources esiste già

            if (!dir.exists()) {

                // se non esiste la creo
                dir.mkdirs();
            }
            // creo il file presentsList

            File myObj = new File("./resources/presentsList.txt");
            writer = new FileWriter(myObj);
            for (Present item : presentsList) {
                // inserisco nel file tutti gli oggetti presnti nella lista presentsList

                writer.write(item.getReceiver() + ";" + item.getDescription() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Unable to open file");
        } finally {
            try {
                if (writer != null) {
                    System.out.println("File closed!");
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
