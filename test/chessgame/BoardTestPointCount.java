package chessgame;

import static pieces.Piece.Color.*;
import pieces.Piece;
import junit.framework.TestCase;

public class BoardTestPointCount extends TestCase {
	
	private Board board;
	
	protected void setUp() {
		board = new Board();
	}

	

	//같은 열에 위치한 pawn의 점수 변화 
	public void testCheckPawn2() throws Exception {
		board.checkPoint(BLACK);
		assertEquals(38.0, Piece.blackPoint);
		
		//피스 이동 4개의 말이 같은 열에 존재 
		board.movePiece("b2", "c1");
		board.movePiece("b3", "c4");
		System.out.println(board.boardPrint()); 
		
		board.checkPoint(BLACK);
		assertEquals(4, board.checkPawn(BLACK)); //0.5점을 줘야 될 말은 총 4개 
		assertEquals(36.0,Piece.blackPoint); 
	}
}
