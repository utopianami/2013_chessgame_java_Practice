package chessgame;


import junit.framework.TestCase;
import util.StringUtil;

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

	//보드판 모습 확인 
	public void testBoardPrint() throws Exception {		
		System.out.println("boardPrint 메소드 테스트 결과");		
		System.out.println(new Board().boardPrint(youngnamBoard.chessBoard));		
		System.out.println("boardPrint 메소드 테스트 결과완료 ");
		String blankRank = StringUtil.appendNewLine("........");
			
		assertEquals(
		StringUtil.appendNewLine("RNBQKBNR") +
		StringUtil.appendNewLine("PPPPPPPP") +
		blankRank + blankRank +blankRank +blankRank +
		StringUtil.appendNewLine("pppppppp") +
		StringUtil.appendNewLine("rnbqkbnr"), new Board().boardPrint(youngnamBoard.chessBoard));
	
	}
}
