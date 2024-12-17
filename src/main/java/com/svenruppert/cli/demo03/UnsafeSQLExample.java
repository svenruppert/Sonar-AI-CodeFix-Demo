package com.svenruppert.cli.demo03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UnsafeSQLExample {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Gib deinen Benutzernamen ein:");
    String username = scanner.nextLine();

    System.out.println("Gib dein Passwort ein:");
    String password = scanner.nextLine();

    try {
      // Verbindung zur Datenbank herstellen
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
      Statement statement = connection.createStatement();

      // Unsichere SQL-Abfrage, die Eingaben direkt verwendet (SQL-Injection möglich!)
      String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
      ResultSet resultSet = statement.executeQuery(query);

      if (resultSet.next()) {
        System.out.println("Erfolgreich eingeloggt!");
      } else {
        System.out.println("Login fehlgeschlagen.");
      }

      // Ressourcen schließen
      resultSet.close();
      statement.close();
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      scanner.close();
    }
  }
}
