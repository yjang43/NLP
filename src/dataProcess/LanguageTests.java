package dataProcess;

import java.util.ArrayList;

public class LanguageTests {
  public static boolean testAddUniqueWord_isSortedAsExpected() {
    boolean testResult = true;
    Language lng = new Language();
    
    // String value to be used: Hello, my, name, is, Jason
    ArrayList<String> testArr = new ArrayList<String>();
    testArr.add("hello");
    testArr.add("my");
    testArr.add("name");
    testArr.add("is");
    testArr.add("jason");
    
    // test the method
    lng.addUniqueWord(testArr);
    
    // expected result -> hello is jason my name
    if(!lng.getWordSet().get(0).equals("hello")) {
      testResult = false;
      System.out.println("!!!!");
    }
    if(!lng.getWordSet().get(1).equals("is")) testResult = false;
    if(!lng.getWordSet().get(2).equals("jason")) testResult = false;
    if(!lng.getWordSet().get(3).equals("my")) testResult = false;
    if(!lng.getWordSet().get(4).equals("name")) testResult = false;
    return testResult;
  }
  public static void main(String args[]) {
    System.out.println(testAddUniqueWord_isSortedAsExpected());
  }
}