package chessgame;


import junit.framework.TestCase;


public class RowTest extends TestCase {
	Board youngnamBoard;
	
	public void setUp(){
		youngnamBoard = new Board();
	}

	
	//체스판 빈공간 초기화 
	public void testInitEmpty() throws Exception {	
		
		
		new Row().initBlackPawn();
		assertEquals("........", new Board().linePrint(youngnamBoard.chessBoard.get(4)));
	}
	
	//체스판 BALCK_PAWN 초기화 
	public void testInitBlackPawn() throws Exception {	
		
		new Row().initBlackPawn();
		assertEquals("PPPPPPPP", new Board().linePrint(youngnamBoard.chessBoard.get(1)));
	}
	
	//체스판 WHITE_PAWN 초기
	public void testInitWhitePawn() throws Exception {	
		
		new Row().initWhitePawn();
		assertEquals("pppppppp", new Board().linePrint(youngnamBoard.chessBoard.get(6)));
	}


}
