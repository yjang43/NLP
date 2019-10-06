package dataProcess;

import java.util.ArrayList;
import java.util.LinkedList;
import dataProcess.Language;
import dataProcess.Node;
import fileInputParse.FileParse;
import fileInputParse.FileRead;


public class Idea extends Language{
  private static final int NUM_VALS_TO_LOOK = 10;
  private static final int TRIAL = 10;
  public ArrayList<ArrayList<Double>> idea = new ArrayList<ArrayList<Double>>();
  double[][] data; 
  ArrayList<ArrayList<Double>> arr;
  // once you add a word
  // you will add a half of the word you adding
  // input will be word, output will be void changing value of the array
  
  public void resize() {
    if(getWordSet().size() != idea.size()) {
      for(int i = 0; i < getIndexList().size(); i++) 
        idea.add(getIndexList().get(i), new ArrayList<Double>(idea.size()));
      for(int i = 0; i < idea.size(); i++) 
        for(int j = 0; j < getIndexList().size(); j++) 
          idea.get(i).add(getIndexList().get(j), 0.0);
      for(int i = 0; i < idea.size(); i++) 
        idea.get(i).set(i, 1.0);
      setDefaultIndexList(); 
    }
  }
  
  public void input(ArrayList<String> fileSet) {
    String prevWord = "";
    String nextWord = "";
    for(int i = 0; i < fileSet.size(); i++) {
      if((i == fileSet.size() - 1)) break;
      
      prevWord = fileSet.get(i);
//      System.out.println(prevWord);
      nextWord = fileSet.get(i + 1);
      bitInput(prevWord, nextWord);
      prevWord = null;
      nextWord = null;
    }
  }
  
  void bitInput(String prev, String next) {
    int prevIndex = binarySearch(getWordSet(), prev);
//    System.out.println(prevIndex);
    int nextIndex = binarySearch(getWordSet(), next);
    for(int i = 0; i < idea.size(); i++) {
      idea.get(nextIndex).set(i, 0.5 * (idea.get(nextIndex).get(i) + idea.get(prevIndex).get(i)));
    }
  }
  
  
  // well, fuck it, brute force everything, it will need to traverse anyways
  
  void addUniqueWord() {
    // whenever the size of static array changes than we can add data there
  }
  
  // and then we have to compare it with node value or compare node value with this value
  // so when someone type down a sentence, we pick the narrow part and only seek for that value
  // and see if the value is the closest 
  // so yeah somehow very similar with node
  // add until you get .
  // and then compare the whole value whether or not the narrow data is the closest
  // get one word, find next word, see what value is the closest
  // continue that
  
  public void saySomething() {
    int[] indexStore = new int[NUM_VALS_TO_LOOK];
    String ending = "";
    String next;
    String prev = ".";
    int[] checkThese = new int[3];
    Node node = new Node();
    next = getNext(prev, node);
    while(ending != ".") {
      
      
      int max = 0;
      int curVal = 0;
      for(int i = 0; i < TRIAL; i++) {
        curVal = checkNext(prev, next, valToLookAt, indexToLookAt)(prev, next, checkThese);
        if(curVal > max) {
          next = getNext(prev, node);

        }
      }
      
      
      prev = next;
      ending = next;
    }
  }
  
  private String getNext(String prev, Node node) {
    // look at the node value and take from it
    String str = new String();
    return str;
  }
  
  private int checkNext(String prev, String next, int[] valToLookAt, int[] indexToLookAt) {
    
    return 0;
  }
  
  
  int findIndex(String word) {
    int a = 0;
    return a;
  }
  
  public static void main(String args[]) {
    FileParse parser = new FileParse
        (FileRead.read("/Users/jang/eclipse-workspace/java/Project - NLP/src/testFile.txt"));
    parser.parse();
    Language lng = new Language();
    lng.addUniqueWord(parser.getFileSet());
    for(int i = 0; i < lng.getWordSet().size(); i++) {
      System.out.printf("\t%s", lng.getWordSet().get(i));
    }
    System.out.println();
    Node tmp = new Node();
    tmp.resize();
    tmp.input(parser.getFileSet());
    Idea idea = new Idea();
    idea.resize();
     idea.input(parser.getFileSet());
    idea.bitInput("friend", "good");
    idea.bitInput("good", "hello");
    for(int i = 0; i < idea.idea.size(); i++) {
      if(idea.idea.get(3).get(i) != 0.0) System.out.printf("\t%f", idea.idea.get(3).get(i));
    }
    System.out.println();
    System.out.println(lng.getWordSet().get(5));
    System.out.println(idea.idea.get(4).get(4));
    
  }
}