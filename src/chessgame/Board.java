package chessgame;

import pieces.Pawn;
import java.util.ArrayList;

/**
 * 체스판 클래스 
 * @author YoungNamLee
 */


public class Board {
	
	private ArrayList<Pawn> chessPieces = new ArrayList<Pawn>();

	/**
	 * 체스판 위에 있는 말의 수 확인 
	 * @return 현재 체스판 위에 있는 말의 수 
	 */
	public int getPiecesNumber() {
		return chessPieces.size();
	}

	/**
	 * 체스판 위에 말을 추가하는 함수 
	 * @param 체스판 위에 추가하고자 하는 말 
	 */
	public void enroll(Pawn player) {
		chessPieces.add(player);
	}

	
	/**
	 * 체스판 위에 말을 확인하는 함수 
	 * @param 확인하고 하자는 말의 순번 
	 * @return 순번에 해당하는 인스턴스 
	 */
	public Pawn getPieces(int index) {
		return chessPieces.get(index);
	}
	
}
