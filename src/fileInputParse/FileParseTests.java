package fileInputParse;

public class FileParseTests {
  /**
   * test if parse() method makes all string lower case
   * @return true if pass, false otherwise
   */
  public static boolean testParse_isLowerCase() {
    boolean testResult = true;
    FileParse parser = new FileParse
        (FileRead.read("/Users/jang/eclipse-workspace/java/Project - NLP/src/testFile.txt"));
    parser.parse();
    String testStr = parser.getFileSet().get(0);
    if((testStr == "hello")) testResult = false;
//    System.out.println(testStr);
    return testResult;
  }
  
  /**
   * check if method gives the array list value expected value 
   * @return true if pass, false otherwise
   */
  public static boolean testParse_isArrayListResultSevenToNineExpected() {
    boolean testResult = true;
    FileParse parser = new FileParse
        (FileRead.read("/Users/jang/eclipse-workspace/java/Project - NLP/src/testFile.txt"));
    parser.parse();
    if(!(parser.getFileSet().get(7).equals("hello"))) {
      System.out.println(parser.getFileSet().get(7));
      testResult = false;
    }
    if(!(parser.getFileSet().get(8).equals("!"))) {
      System.out.println(parser.getFileSet().get(8));
      testResult = false;
    }
    if(!(parser.getFileSet().get(9).equals("good"))) {
      System.out.println(parser.getFileSet().get(9));
      testResult = false;
    }
    return testResult;
  }
  
  public static void main(String args[]) {
    
    System.out.println("testParse_isLowerCase() result: " + testParse_isLowerCase());
    System.out.println("testParse_isArrayListResultSevenToNineExpected() result: " + testParse_isArrayListResultSevenToNineExpected());
    
  }
}