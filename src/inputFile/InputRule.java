package inputFile;

import process.*;

public class InputRule {
	char c;
	WordSet ws;
	Node nd;
	Idea id;
	
	public InputRule(WordSet ws, Node nd, Idea id) {
		this.ws = ws;
		this.nd = nd;
		this.id = id;
	}
	
	protected void rules(char c) {
		this.c = c;
									// bunch of if cases for characters such as ' ' or '.'
		if(c == ' ') rule_1(c); 
		else if(c == '.') rule_2(c);
		else if(c == '\t' || c == '\r' || c == '\n');
		else rule_3(c); 	
	}
	
	/*
	 * c = ' '
	 */
	private void rule_1(char c) {
		if(ws.word.length != 0) {
			ws.addWordToSet(ws.word);
			nd.nodeSizeCheck();
			id.ideaSizeCheck();
			ws.addWordToSentence(ws.word);
			ws.resetWord();	
		}
		// System.out.println("rule_1: " + "set length = " + ws.wordSet.length);
	}

	/*
	 * c = '.'
	 * this will trigger evaluation of the sentence and store the data
	 */
	private void rule_2(char c) {
		ws.addWordToSet(ws.word);
		nd.nodeSizeCheck();
		id.ideaSizeCheck();
		ws.addWordToSentence(ws.word);
		
		nd.nodeCalc();
		id.ideaCalc();
		
		ws.resetWord();
		ws.resetSentence();
	}
	
	/*
	 * c = else
	 */
	private void rule_3(char c) {
		ws.addLetterToWord(c);
	}
}