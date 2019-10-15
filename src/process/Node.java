package process;

import tool.ArrayTool;

public class Node {
	WordSet ws;
	public int node[][];
	public Node(WordSet ws) {
		this.ws = ws;
		node = new int[0][0];
	}
	
	public void nodeCalc() {
		int row;
		int column;
		
		if(ws.sentence.length != 0) {
			for(int i = 0; i < ws.sentence.length; i++) {
				try {
					row = ArrayTool.getIndex(ws.sentence[i], ws.wordSet);
					column = ArrayTool.getIndex(ws.sentence[i + 1], ws.wordSet);
					node[row][column] += 1;
				} catch(IndexOutOfBoundsException exc) {
				}
			}
			
		}
	}
	
	public void nodeSizeCheck() {
		if(didSetChange()) node = ArrayTool.resizeMulArr(node);
	}
	
	public boolean didSetChange() {
		if(node.length != ws.wordSet.length) return true;
		else return false;
	}
	
}