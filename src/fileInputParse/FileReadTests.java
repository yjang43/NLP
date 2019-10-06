package fileInputParse;

class FileReadTests {
  public static boolean testRead_doesReturnString() {
    boolean testResult = true;
//    String str = FileRead.read("/Users/jang/eclipse-workspace/java/NLP/src/data.txt");
    
    return testResult;
  }
  
  public static void main(String args[]) {
    System.out.println("check output for reading file: " + 
        FileRead.read("/Users/jang/eclipse-workspace/java/NLP/src/data.txt"));
  }
}