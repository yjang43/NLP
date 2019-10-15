package console;

import java.util.Random;
import tool.ArrayTool;
import process.*;


public class OutputConsole {
	int[] ideaThreshold;
	int[] ideaSum;
	int[] boundary;
	WordSet ws;
	Node nd;
	Idea id;
	public OutputConsole(WordSet ws, Node nd, Idea id, int[] threshold) {
		this.ws = ws;
		this.nd = nd;
		this.id = id;
		ideaThreshold = threshold;
		ideaSum = new int[ws.wordSet.length];
		boundary = new int[ws.wordSet.length];
	}
	Random rnd = new Random();
	
	public void start(int words) {
		int index;
		int errorNum = 0;
		int n;
		int trial = 0;
		
		setBoundaryForRand();
		System.out.println();
		do {
			n = rnd.nextInt(nodeComponentSum());
			index = checkBoundaryForRand(n);	
			errorNum++;
			// System.out.println(doesIdeaOverload(id.idea[index]));
			// System.out.println((nodeComponentSum() / 3));
			// System.out.println(errorNum);
		} while(doesIdeaOverload(id.idea[index]) && errorNum <= (nodeComponentSum() / 3));
		// if(errorNum > (nodeComponentSum() / 3)) return;
		System.out.print(ws.wordSet[index] + " ");
		
		while(trial < words) {
			errorNum = 0;
			setBoundaryForRand_2(index);
			do {
				n = rnd.nextInt(nodeRowSum(index));
				errorNum++;
				// System.out.println(doesIdeaOverload(id.idea[index]));
				// System.out.println((nodeComponentSum() / 3));
			} while(doesIdeaOverload(id.idea[index]) && errorNum <= (nodeComponentSum() / 3));
			// if(errorNum > (nodeComponentSum() / 3)) return;
			index = checkBoundaryForRand(n);
			System.out.print(ws.wordSet[index] + " ");
			trial++;
		}
		
		
	}
	
	public boolean doesIdeaOverload(int[] idea) {
		int[] tmp = ArrayTool.copyArr(ideaSum);
		int i;
		for(i = 0; i < idea.length; i++) {
			tmp[i] += idea[i];
			if(ideaThreshold[i] < tmp[i]) break;
		}
		if(i == idea.length) {
			ideaSum = tmp;
			return false;
		}
		else return true;
	}
	
	private void setBoundaryForRand() {
		int sum = 0;
		for(int i = 0; i < nd.node.length; i++) {
			for(int j = 0; j < nd.node.length; j++) {
				sum += nd.node[i][j];
			}
			boundary[i] = sum;
		}
	}
	private void setBoundaryForRand_2(int index) {
		int sum = 0;
		for(int i = 0; i < nd.node.length; i++) {
			sum += nd.node[index][i];
			boundary[i] = sum;
		}
		
	}
	private int checkBoundaryForRand(int n) {
		for(int i = 0; i < nd.node.length; i++) {
			if(n < boundary[i]) return i;
		}
		return -1;
	}

	private int nodeComponentSum() {
		int sum = 0;
		for(int i = 0; i < nd.node.length; i++) {
			for(int j = 0; j < nd.node.length; j++) {
				sum += nd.node[i][j];
			}
		}
		return sum;
	}
	private int nodeRowSum(int index) {
		int sum = 0;
		for(int i = 0; i < nd.node.length; i++) {
			sum += nd.node[index][i];
		}
		return sum;
	}
	
}