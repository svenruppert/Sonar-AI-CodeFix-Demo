package com.svenruppert.cli.demo001;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class UnsafeDeserializationExample  {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Gib den Pfad zur Eingabedatei ein:");
    String filePath = scanner.nextLine();

    try {
      // Unsichere Deserialisierung der Datei
      ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
      Object obj = objectInputStream.readObject();

      // Direkte Annahme, dass die Eingabe sicher ist
      UserData userData = (UserData) obj;
      System.out.println("Deserialisierte Daten: " + userData);

      objectInputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      scanner.close();
    }
  }
}
