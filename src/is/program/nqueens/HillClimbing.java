package is.program.nqueens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class HillClimbing {

	static int BOARD_SIZE = 0;
	static int userInput1 = 0;
	static int userInput2 = 0;
	static ChessBoard retrivedBestChild;
	

	public static void main(String args[]) {
		System.out.println("Enter board size");

		// Checking user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			BOARD_SIZE = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Value enteres is : " + String.valueOf(BOARD_SIZE));

		//

		// Integer[] checkFormation = new Integer[BOARD_SIZE];
		// checkFormation[0] = 1;checkFormation[1] = 2;checkFormation[2] = 0;
		// checkFormation[3] = 4;checkFormation[4] = 3;

		ChessBoard tempBoard;
		tempBoard = new ChessBoard(generateRandomInitialState());
		// tempBoard.pritnState();

		System.out.println("Heuristic value of this formation is :"
				+ String.valueOf(tempBoard.gethValue()));

		retrivedBestChild = tempBoard.getBestChild();

		if (retrivedBestChild == null) {
			System.out.println("Plateu");
		} else {
			retrivedBestChild.pritnState();
			System.out.println("Improved heuristic is :"
					+ String.valueOf(retrivedBestChild.gethValue()));
		}

		// //////////////////Main
		// algorithm////////////////////////////////////////////////////////
		// //////////////////////////////////////////////////////////////////////////////////////
		retrivedBestChild = new ChessBoard(generateRandomInitialState());
		int numOfRestart = 0;
		int numOfSteps = 0;
		// tempBoard.pritnState();

		while (retrivedBestChild.gethValue() != 0) {
			
			retrivedBestChild = retrivedBestChild.getBestChild();

			if (retrivedBestChild == null) {
				System.out.println("Plateu");
				numOfRestart++;
				numOfSteps = 0 ;
				retrivedBestChild = new ChessBoard(generateRandomInitialState());
			} else {
			//	retrivedBestChild.pritnState();
				
				numOfSteps++;
			}
		}
		System.out.println("Number of restart required are : " + String.valueOf(numOfRestart));
		System.out.println("Number of steps to climb are : " + String.valueOf(numOfSteps));
		System.out.println("e e e e e");
		// ///////////////////////////////////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////////////////////////////////////

	}

	public static Integer[] generateRandomInitialState() {

		Integer[] toBeReturnedFormation = new Integer[BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++) {

			Random rand = new Random();

			// nextInt is normally exclusive of the top value,
			// so add 1 to make it inclusive
			int randomNum = rand.nextInt(BOARD_SIZE);
			//System.out.println(String.valueOf(randomNum));
			toBeReturnedFormation[i] = randomNum;
		}
		return toBeReturnedFormation;
	}
}
