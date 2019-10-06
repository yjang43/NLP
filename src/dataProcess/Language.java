package dataProcess;

import java.util.ArrayList;
import fileInputParse.FileParse;
import fileInputParse.FileRead;

public class Language {
  private static ArrayList<String> wordSet = new ArrayList<String>();
  private int index;
  protected static ArrayList<Integer> indexList = new ArrayList<Integer>();
  
  public void addUniqueWord(ArrayList<String> fileSet) {
    for(int i = 0; i < fileSet.size(); i++) {
      index = binarySearch(wordSet, fileSet.get(i));
      String strToAdd = fileSet.get(i);
      if(wordSet.size() == 0) {
        indexList.add(index);
//        System.out.println("current indexlist size: " + indexList.size());
        wordSet.add(strToAdd);
      }
      else {
        if(index >= wordSet.size()) {
          
          indexList.add(index);
//          System.out.println("current indexlist size: " + indexList.size());
          wordSet.add(strToAdd);
        }
        else {
          if(!strToAdd.equals(wordSet.get(index))) {
            indexList.add(index);
//            System.out.println("current indexlist size: " + indexList.size());
            wordSet.add(index, strToAdd);            
          }
        }
      }
//      boolean doAdd = true;
//      String strToAdd = fileSet.get(i);
//      
//      for(int j = 0; j < wordSet.size(); j++) {
//        if(wordSet.get(j).equals(fileSet.get(i))) {
//          doAdd = false;
//        }
//      }
//      if(doAdd) wordSet.add(findIndex(wordSet, strToAdd), strToAdd);
    }
  }
  
  // this method can be replaced by binary search method
  
  private int findIndex(ArrayList<String> wordSet, String str) {
    int index = -1;
    for(int i = 0; i < wordSet.size(); i++) {
      if(wordSet.get(i).compareTo(str) > 0) {
        index = i;
        break;
      }
    }
    if(index == -1) index = wordSet.size();
    return index;
  }
  
  public ArrayList<String> getWordSet() {
    return wordSet;
  }
  
  public int getIndex() {
    return index;
  }
  
  public static void setDefaultIndexList() {
    indexList = new ArrayList<Integer>();
  }
  
  public static ArrayList<Integer> getIndexList() {
    return indexList;
  }
  
  /**
   * binary search algorithm
   * code from: https://stackoverflow.com/questions/
   * 32260445/implementing-binary-search-on-an-array-of-strings
   * @param wordSet Dynamic array that stores words
   * @param stringToSearch String value that will be searching for the position in the array
   *        need to make sure to check if the word is already there. If so, need to explicitly 
   *        take care of such situation outside the code
   * @return index integer value of the strings position
   */
  protected static int binarySearch(ArrayList<String> wordSet, String stringToSearch) {
    int low = 0;
    int high = wordSet.size() - 1;
    int mid;

    while (low <= high) {
        mid = (low + high) / 2;
        if (wordSet.get(mid).compareTo(stringToSearch) < 0) low = mid + 1; 
        else if (wordSet.get(mid).compareTo(stringToSearch) > 0) high = mid - 1;
        else return mid;
    }
    return low;
  }
  // 1 2 4
  // 3
  
  public static void main(String args[]) {
    FileParse parser = new FileParse
        (FileRead.read("/Users/jang/eclipse-workspace/java/Project - NLP/src/testFile.txt"));
    parser.parse();
    for(int i = 0; i < parser.getFileSet().size(); i++) {
      System.out.printf("\t%s", parser.getFileSet().get(i));
    }
    System.out.println();
    Language lng = new Language();
    lng.addUniqueWord(parser.getFileSet());
    for(int i = 0; i < lng.getWordSet().size(); i++) {
      System.out.printf("\t%s", lng.getWordSet().get(i));
    }
    System.out.println();
  }
}