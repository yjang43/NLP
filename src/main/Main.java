package main;

import inputFile.*;
import console.*;
import tool.ArrayTool;

class Main {
	public static void main(String args[]) {
		Input inp = new Input();
		inp.readSentence();

		System.out.println();
		//inp.printIdea();
		InputConsole inpcon = new InputConsole
				("Dear bear I will like to eat some candy ");   // this is input
		int[] threshold = inpcon.ideaThresholdCalc(inp.ws, inp.id);
		OutputConsole otp = new OutputConsole(inp.ws, inp.nd, inp.id, threshold);
		otp.start(15);

//		System.out.println(ArrayTool.isSame(a, b));

	}
}