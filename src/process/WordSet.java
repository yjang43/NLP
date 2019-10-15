package process;

import tool.*;

public class WordSet {
	public String[] wordSet = new String[0];
	public String[] sentence = new String[0];
	public char[] word = new char[0];
	
	
	public void addLetterToWord(char c) {
		word = ArrayTool.resizeArr(word);
		word[word.length - 1] = c;
	}
	
	
	
	public void addWordToSet(char[] word) {
		int i;
		boolean doAdd = false;
		for(i = 0; i < wordSet.length; i++) {
			if(ArrayTool.isSame(wordSet[i], word)) break;
		}
		if(i == wordSet.length) doAdd = true;
		if(doAdd) {
			wordSet = ArrayTool.resizeArr(wordSet);
			wordSet[wordSet.length - 1] = String.valueOf(word);
		}
	}
	
	public void addWordToSentence(char[] word) {
		sentence = ArrayTool.resizeArr(sentence);
		sentence[sentence.length - 1] = String.valueOf(word);
	}
	
	public void resetWord() {
		word = ArrayTool.clearArr(word);
		// System.out.println("hey");
	}
	
	public void resetSentence() {
		sentence = ArrayTool.clearArr(sentence);
	}
	
}