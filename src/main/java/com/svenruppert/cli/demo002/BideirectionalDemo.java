package com.svenruppert.cli.demo002;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.createFile;

public class BideirectionalDemo {

  public static void main(String[] args) {
      // U+202E is the Right-to-Left Override (RLO) character
      String normalName = "report.txt";
      String deceptiveName = "report" + "\u202E" + "exe.txt";
      // Try to create files with these names
      createFile(normalName);
      createFile(deceptiveName);
      // Print what the names look like to the Java program
      System.out.println("Expected file name: " + normalName);
      System.out.println("Deceptive file name appears as: " + deceptiveName);
    }

    private static void createFile(String fileName) {
      File file = new File(fileName);
      try {
        if (file.createNewFile()) {
          System.out.println("File created: " + file.getName());
        } else {
          System.out.println("File already exists: " + file.getName());
        }
      } catch (IOException e) {
        System.out.println("An error occurred while creating the file: " + fileName);
        e.printStackTrace();
      }
    }

  }
