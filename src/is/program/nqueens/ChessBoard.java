package is.program.nqueens;



import java.util.ArrayList;
import java.util.PriorityQueue;

public class ChessBoard implements Comparable<ChessBoard>{

	Integer[] formation;
	int hValue;

	public ChessBoard(Integer[] formation) {
		super();
		this.formation = formation;
		this.hValue = this.calculateHValue();
	}

	public Integer[] getFormation() {
		return formation;
	}

	public void setFormation(Integer[] formation) {
		this.formation = formation;
	}

	public int gethValue() {
		return hValue;
	}

	public void sethValue(int hValue) {
		this.hValue = hValue;
	}

	public void pritnState() {
		for (int i = 0; i < HillClimbing.BOARD_SIZE; i++) {
			System.out.print("- " + String.valueOf(i) + " -");
		}
		System.out.println("");
		for (int i = 0; i < HillClimbing.BOARD_SIZE; i++) {
			for (int j = 0; j < HillClimbing.BOARD_SIZE; j++) {
				if (formation[j] == i) {
					System.out.print("| Q |");
				} else {
					System.out.print("|   |");
				}

			}
			System.out.println("");
			// System.out.println(String.valueOf(formation[i]) + " ");
		}
	}

	// Check if two given comlumn contains queens that are in conflict
	public boolean areInConflict(int column1, int column2) {
		if (this.formation[column1] == this.formation[column2]) {
			return true;
		} else if (Math.abs(column1 - column2) == Math
				.abs(this.formation[column1] - this.formation[column2])) {
			return true;
		}
		return false;
	}

	public int calculateHValue() {
		int tempHValue = 0;
		for (int i = 0; i < HillClimbing.BOARD_SIZE; i++) {
			for (int j = 0; j < HillClimbing.BOARD_SIZE; j++) {
				if (i != j && areInConflict(i, j)) {
					tempHValue++;
				}

			}

		}
		return tempHValue / 2;// Because every pair was counted twice
	}

	public ChessBoard getBestChild() {
		
		ChessBoard tempChessBoard;
		Integer[] tempFormation;
		ChessBoard toBeReturnedChild;
		PriorityQueue<ChessBoard> toBeReturnedChildren = new PriorityQueue<ChessBoard>();

		for (int i = 0; i < HillClimbing.BOARD_SIZE; i++) {
			for (int j = 0; j < HillClimbing.BOARD_SIZE; j++) {
				// create new formation
				tempFormation = new Integer[HillClimbing.BOARD_SIZE];
				
				//Copy from existing formation
				tempFormation = this.getFormation().clone();
				if(j != this.formation[i]){
				tempFormation[i] = j;
				tempChessBoard = new ChessBoard(tempFormation);
				//tempChessBoard.pritnState();
				toBeReturnedChildren.add(tempChessBoard);
				}
			}
		}
		//System.out.println("Total  size of queue is : " + String.valueOf(toBeReturnedChildren.size()));
		/*for(ChessBoard singleBoad : toBeReturnedChildren){
			System.out.println("Formation is :");
			singleBoad.pritnState();
			System.out.println("Its heuristic is : " + String.valueOf(singleBoad.gethValue()));
		}*/
		
		toBeReturnedChild = toBeReturnedChildren.poll();
		
		if(toBeReturnedChild.gethValue() < this.gethValue()){
			return toBeReturnedChild;	
		}else{
			return null;
		}
		
	}

	@Override
	public int compareTo(ChessBoard o) {
		// TODO Auto-generated method stub
		return this.gethValue() - o.gethValue();
		
	}

}
