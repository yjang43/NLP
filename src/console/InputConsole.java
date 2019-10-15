package console;
import tool.ArrayTool;

import java.io.IOException;

import process.*;

public class InputConsole {
	String str;
	public InputConsole(String str) {
		this.str = str;
	}
	
	private String[] strToWord() {
		char[] strToCharArr = str.toCharArray();
		char[] tmp = new char[0];
		String[] set = new String[0];
		for(int i = 0; i < strToCharArr.length; i++) {
			if(strToCharArr[i] != ' ') {
				tmp = ArrayTool.resizeArr(tmp);
				tmp[tmp.length - 1] = strToCharArr[i];
			}
			else {
				set = ArrayTool.resizeArr(set);
				set[set.length - 1] = String.copyValueOf(tmp);
				tmp = ArrayTool.clearArr(tmp);
			}
		}
		return set;
	}
	
	
	public int[] ideaThresholdCalc(WordSet ws, Idea id) {
		System.out.println();
		String[] set = strToWord();
		int[] ideaThreshold = new int[ws.wordSet.length];
		for(int i = 0; i < set.length; i++) {
			try {
				int index = ArrayTool.getIndex(set[i], ws.wordSet);
				for(int j = 0; j < ws.wordSet.length; j++) {
					ideaThreshold[j] += id.idea[index][j];
				}
			} catch (IndexOutOfBoundsException exc) {
			}
		}
		for(int i = 0; i < set.length; i++) {
			System.out.printf("\t%s", set[i]);
		}
		System.out.println();
		for(int i = 0; i < ideaThreshold.length; i++) {
	
			System.out.printf("\t%d", ideaThreshold[i]);
		}
		return ideaThreshold;
	}
}