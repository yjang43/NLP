package process;

import tool.ArrayTool;

public class Idea {
	WordSet ws;
	public int idea[][];
	public Idea(WordSet ws) {
		this.ws = ws;
		idea = new int[0][0];
	}
	public void ideaCalc() {
		for(int i = 0; i < idea.length; i++) {
			try {
				for(int j = 0; i < idea.length; j++) {
					idea[i][j] += idea[i - 1][j];
				}
			} catch(IndexOutOfBoundsException exc) {
				
			}
		}
	}

	
	public void ideaSizeCheck() {
		if(didSetChange()) idea = ArrayTool.resizeMulArr(idea);
		idea[idea.length -1][idea.length - 1] = 1;
	}
	
	public boolean didSetChange() {
		if(idea.length != ws.wordSet.length) return true;
		else return false;
	}
}