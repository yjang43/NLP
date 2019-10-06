package fileInputParse;

import java.util.ArrayList;

public class FileParse {
  private String file;
  private ArrayList<String> fileSet;
  
  public FileParse(String file) {
    this.file = file;
    fileSet = new ArrayList<String>();
  }
  
  /**
   * major method, parse string file into string of ArrayList value
   */
  public void parse() {
    fileToLowerCase();
    wordSpliter();
  }
  
  private void fileToLowerCase() {
    file = file.toLowerCase();
  }
  
  private void wordSpliter() {
    ArrayList<Character> word = new ArrayList<Character>();
    Character c;
    for(int i = 0; i < file.length(); i++) {
      c = file.charAt(i);
      if((c > 96 && c < 123)) {
        word.add(c);
      }
      else if(c == '.' || c == ',' || c == '!' || c == '?') {
        if(!word.isEmpty()) {
          fileSet.add(characterToString(word));
          word = new ArrayList<Character>();
          word.add(c);
          fileSet.add(characterToString(word));
          word = new ArrayList<Character>();
        }
      }
      else {
        if(!word.isEmpty()) {
          fileSet.add(characterToString(word));
          word = new ArrayList<Character>();
        }
      }
      
      // if the file string ended in unexpected case
      if(i == file.length() - 1) {
        if(!word.isEmpty()) fileSet.add(characterToString(word));
      }
    }
  }
  
  private String characterToString(ArrayList<Character> arr) {
    String str = "";
    for(int i = 0; i < arr.size(); i++) {
      str = str.concat(arr.get(i).toString());
    }
    return str;
  }
  
  public void printDataSet(String[] set) {
    for(int i = 0; i < set.length; i++) {
      System.out.printf("\t%s", set[i]);
    }
  }
  
  public ArrayList<String> getFileSet() {
    return fileSet;
  }
}