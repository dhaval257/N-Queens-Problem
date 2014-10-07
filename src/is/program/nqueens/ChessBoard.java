package is.program.nqueens;

public class ChessBoard {

	Integer[] formation;
	int hValue;

	public ChessBoard(Integer[] formation) {
		super();
		this.formation = formation;
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
			System.out.print("- "+ String.valueOf(i)+" -");
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

	
	public boolean areInConflict(int column1, int column2) {
		if (this.formation[column1] == this.formation[column2]) {
			return true;
		}else if(Math.abs(column1-column2)==Math.abs(this.formation[column1] - this.formation[column2])){
			return true;
		}
		return false;
	}

}
