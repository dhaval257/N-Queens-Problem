package is.program.nqueens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import javax.annotation.Generated;

public class HillClimbing {

	static int BOARD_SIZE = 0;

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
		
//		Integer[] checkFormation = new Integer[BOARD_SIZE];
	//	checkFormation[0] = 1;checkFormation[1] = 2;checkFormation[2] = 0;
		//checkFormation[3] = 4;checkFormation[4] = 3;
		
		
		ChessBoard tempBoard = new ChessBoard(generateRandomInitialState());
		tempBoard.pritnState();
		
		
	}
	
	public static Integer[] generateRandomInitialState() {
		
		Integer[] toBeReturnedFormation = new Integer[BOARD_SIZE];
		for(int i = 0 ; i < BOARD_SIZE ; i++){
			
					Random rand = new Random();

		    // nextInt is normally exclusive of the top value,
		    // so add 1 to make it inclusive
		    int randomNum = rand.nextInt(BOARD_SIZE);
		    System.out.println(String.valueOf(randomNum));
		    toBeReturnedFormation[i] = randomNum;
		}
		return toBeReturnedFormation;
	}
}
