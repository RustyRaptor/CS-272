public class NQueen {
	public static void main(String[] args) {

	}
	public static ArraylistStack<Integer> solveNQueen(int N) {
		ArraylistStack<Integer> board = new ArraylistStack<Integer>();
		Integer rowid = 1;
		Integer Qpos = 1;

		while (board.size() < N){
			while (Qpos <= N) {
				boolean conflict = checkConflict(Qpos);
				if (conflict) {
					board.push(Qpos);
					Qpos = 1;
					rowid = board.size() + 1;
				} else {
					Qpos++;
				}
			}
			while (!board.isEmpty() && Qpos >= N) {
				if (board.pop() < N) {
					board.push(++Qpos);
				}else {

				}
			}
		}
	}

	public static boolean checkConflict(Integer Qpos,
					    ArraylistStack<Integer> board){
		int dist = 1;
		while (!board.pop().equals(Qpos) && Math.abs(Qpos - board.pop()) != dist){
			dist++;
		}
		return board.size() == 0;
	}

	public static void printBoard(ArraylistStack<Integer> board){

	}
}
