package com.svenruppert.cli;

import java.io.File;
import java.io.IOException;

public class InsecureTempFileExample {

  private InsecureTempFileExample() {
  }

  public static void main(String[] args) throws IOException {
    File tempFile = new File("/tmp/tempfile.txt");
    tempFile.createNewFile();
    System.out.println("Temporary file created at: " + tempFile.getAbsolutePath());
  }

}
