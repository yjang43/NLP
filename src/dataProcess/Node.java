package dataProcess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import dataProcess.Language;
import fileInputParse.*;

/**
 * class that calculates the likelihood of the next word
 * @author jang
 *
 */
public class Node extends Language{
  private final int NODE_MEMORY = 1000;
  private Random rnd = new Random();
  private ArrayList<LinkedList<String>> node = new ArrayList<LinkedList<String>>();

  /**
   * Once the size of wordSet changes change the size of node as well.
   * The change of size will occur after the change in wordSet is complete
   */
  public void resize() {
    if(getWordSet().size() != node.size()) {
      for(int i = 0; i < getIndexList().size(); i++) 
        node.add(getIndexList().get(i), new LinkedList<String>());
//      setDefaultIndexList(); let idea object call this function or do it outside the operation
    }
  }

  /**
   * Returns the most likely word as a output. 
   * Algorithm for choosing one will be by using random
   * @param prevWord word that will decide the most likely coming next word
   * @return next word
   */
  public String output(String prevWord) {
    int index = binarySearch(getWordSet(), prevWord);
    int rndIndex = rnd.nextInt(node.get(index).size());
    return node.get(index).get(rndIndex);
  }

  /**
   * Take set of inputs and calculate node connection. Main input function
   * @param fileSet parsed data from the file
   */
  public void input(ArrayList<String> fileSet) {
    String prevWord = "";
    String nextWord = "";
    for(int i = 0; i < fileSet.size(); i++) {
      prevWord = fileSet.get(i);
      if(!(i == fileSet.size() - 1)) nextWord = fileSet.get(i + 1);
      bitInput(prevWord, nextWord);
      prevWord = null;
      nextWord = null;
    }
  }

  /**
   * Calculate the value of node after taking one previous word and next word.
   * Here we will later include special cases such as ., ?, ! to find a pattern in conversation
   * Example: Hello Jack
   * @param prevWord prevWord Hello
   * @param nextWord nextWord Jack
   */
  private void bitInput(String prevWord, String nextWord) {
    // we can add special cases such as !, ., ,, ?, and etc.
    if(nextWord != null) {
      nextInputCome(prevWord, nextWord);
    }
  }
  
  /**
   * Helper function for bitInput method.
   * Node memory = 1000
   * @param prevWord previous word
   * @param nexWord next word
   */
  private void nextInputCome(String prevWord, String nexWord) {
    
    int index = binarySearch(getWordSet(), prevWord);
    if(node.get(index).size() > NODE_MEMORY) {
      node.get(index).removeFirst();
      node.get(index).addLast(nexWord);  
    }
    else node.get(index).addLast(nexWord);
  }
  
  public static void main(String args[]) {
    FileParse parser = new FileParse
        (FileRead.read("/Users/jang/eclipse-workspace/java/DataProcessing/src/data.txt"));
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
//    System.out.println(Language.getIndexList().size());
    Node tmp = new Node();
    tmp.resize();
    
//    System.out.println((tmp.node.get(1) == null));
    tmp.input(parser.getFileSet());

    // System.out.println(tmp.node.get(9).get(1));
    System.out.print("i ");
    String str = tmp.output("i");
    System.out.printf(" %s", str);
    for(int i = 0; i < 20; i++) {
      str = tmp.output(str);
      System.out.printf(" %s", str);
      
    }
    
  }
  
  
}