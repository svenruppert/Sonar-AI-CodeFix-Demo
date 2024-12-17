package com.svenruppert.cli.demo002;

public class RLMExample {
  public static void main(String[] args) {
    // Arabic reads right to left, English left to right
    String englishText = "Version 1.0";
    String arabicText = "الإصدار";
    // Concatenate without RLM
    String withoutRLM = arabicText + " " + englishText;
    // Concatenate with RLM
    String withRLM = arabicText + "\u200F" + " " + englishText;
    // Print the results
    System.out.println("Without RLM: " + withoutRLM);
    System.out.println("With RLM: " + withRLM);
  }

}
