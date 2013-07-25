package chessgame;

import junit.framework.TestCase;
import static pieces.Piece.Color.*;
import static pieces.Piece.Type.*;

public class BoardTest extends TestCase {
	
	private Board board;
	
	protected void setUp() {
		board = new Board();
	}
	
	
	//Board 생성 확인 
	public void testInit() throws Exception {
		
		assertEquals(8, board.chessBoard.size()); //체스판 사이즈 8 확인 

	}
	
	//체스판 좌표를 통해서 위치확인 
	public void testGetState() throws Exception {
		
		//0행, 1열 위치 확인 
		assertEquals('N', board.getMapInfo(0,1));
		assertEquals('B', board.getMapInfo(0,2));
		
	}
	
	public void testPieceCount() throws Exception {
		
		Board testBoard = new Board();
		System.out.println(testBoard.pieceCount());
		assertEquals(32, testBoard.pieceCount());
	}

}
