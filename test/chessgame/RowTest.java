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
		System.out.println(new Row().linePrint(youngnamBoard.chessBoard.get(0)));
		assertEquals("........", new Row().linePrint(youngnamBoard.chessBoard.get(0)));
	}
	
	//체스판 BALCK_PAWN 초기화 
	public void testInitBlackPawn() throws Exception {	
		
		new Row().initBlackPawn();
		System.out.println(new Row().linePrint(youngnamBoard.chessBoard.get(1)));
		assertEquals("PPPPPPPP", new Row().linePrint(youngnamBoard.chessBoard.get(1)));
	}
	
	//체스판 WHITE_PAWN 초기
	public void testInitWhitePawn() throws Exception {	
		
		new Row().initWhitePawn();
		System.out.println(new Row().linePrint(youngnamBoard.chessBoard.get(6)));
		assertEquals("pppppppp", new Row().linePrint(youngnamBoard.chessBoard.get(6)));
	}

	
	public void testBoardPrint() throws Exception {		
		System.out.println("boardPrint 메소드 테스트 결과");		
		System.out.println(new Row().boardPrint(youngnamBoard.chessBoard));		
		System.out.println("boardPrint 메소드 테스트 결과완료 ");		
	}
}
