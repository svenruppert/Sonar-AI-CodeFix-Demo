package com.svenruppert.cli.demo001;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class SecureDeserializationExample  {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Gib den Pfad zur Eingabedatei ein:");
    String filePath = scanner.nextLine();

    try {
      // Sichere Deserialisierung durch Validierung
      ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
      Object obj = objectInputStream.readObject();

      if (obj instanceof UserData) {  // Validierung des Typs
        UserData userData = (UserData) obj;
        System.out.println("Deserialisierte Daten: " + userData);
      } else {
        System.out.println("Unerwarteter Objekttyp!");
      }

      objectInputStream.close();
    } catch (IOException e) {
      System.err.println("Dateifehler: " + e.getMessage());
    } catch (ClassNotFoundException e) {
      System.err.println("Klasse nicht gefunden: " + e.getMessage());
    } finally {
      scanner.close();
    }
  }
}