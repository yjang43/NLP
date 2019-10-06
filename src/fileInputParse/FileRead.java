package fileInputParse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
  
  public static String read(String fileName) {
    String file = "";
    try(BufferedReader br = new BufferedReader(new FileReader
        (fileName))) {
      String line;
      while(true) {
        line = br.readLine();
        // line will refer to null if EOF
        if(line == null) break;
        file = file.concat(" " + line);
      }
      br.close();
    } catch(IOException exc) {
      System.out.println("Error opening file");
    }
    return file;
  }
}