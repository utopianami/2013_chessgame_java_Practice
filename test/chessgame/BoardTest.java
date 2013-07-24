package chessgame;

import pieces.Piece;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	
	private Board board;
	
	protected void setUp() {
		board = new Board();
	}
	
	public void testCreate() throws Exception {
		board.piecesCount();
		assertEquals(32, board.piecesCount());
	}
	
	//Board 생성 확인 
	public void testInit() throws Exception {
		
		assertEquals(8, new Board().chessBoard.size()); //체스판 사이즈 8 확인 

	}
	
	//체스판 좌표를 통해서 위치확인 
	public void testGetState() throws Exception {
		
		//0행, 1열 위치 확인 
		assertEquals('N', new Board().getMapInfo(0,1));
		assertEquals('B', new Board().getMapInfo(0,2));
		
	}
	
	public void testCountPeice() throws Exception {
		//검은색 말 수 확인
		assertEquals(32, board.piecesCount());
	}

}
