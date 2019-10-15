package inputFile;

import java.io.*;

import process.*;

public class Input {
	public WordSet ws;
	public Node nd;
	public Idea id;
	public void readSentence() {
		try(BufferedReader br = new BufferedReader(new FileReader
				("/Users/jang/eclipse-workspace/java/DataProcessing/src/data.txt"))) {
			int intChar;
			char c;
			ws = new WordSet();
			nd = new Node(ws);
			id = new Idea(ws);
			InputRule inprl = new InputRule(ws, nd, id);
	
			do {
				intChar = br.read();
				if (intChar == -1) break;
				c = (char)intChar;
				inprl.rules(c);
													// data process
			} while(intChar != -1); 				// add rule
		} catch(IOException exc) {
			
		}
	}
	
	

	
	public void printWordSet() {
		for(int i = 0; i < ws.wordSet.length; i++) {
			System.out.printf("\t%s", ws.wordSet[i]);
		}
		System.out.println();
	}
	public void printSentence() {
		for(int i = 0; i < ws.sentence.length; i++) {
			System.out.printf("\t%s", ws.sentence[i]);
		}
		System.out.println();
	}
	public void printNode() {
		for(int i = 0; i < nd.node.length; i++) {
			for(int j = 0; j < nd.node.length; j++) {
				System.out.printf("\t%d", nd.node[i][j]);
			}
			System.out.println();
		}
	}
	public void printIdea() {
		for(int i = 0; i < id.idea.length; i++) {
			for(int j = 0; j < id.idea.length; j++) {
				System.out.printf("\t%d", id.idea[i][j]);
			}
			System.out.println();
		}
	}
	
	
}