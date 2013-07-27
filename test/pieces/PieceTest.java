package pieces;

import pieces.Piece;
import junit.framework.TestCase;


public class PieceTest extends TestCase {
	

	
	//Pawn Class 생성 확인 테스트 코드 
	public void testCreate() throws Exception {
		
		//생성 후 색깔 확인 
		assertEquals(Piece.Color.BLACK, Piece.createBlackPawn().getColor());
		
		//생성 후 심볼 확인(체스판에 출력될 값)
		assertEquals('R', Piece.createBlackRook().getSymbol()); // 

		//생성 후 심볼 확인(체스판에 출력될 값)
		assertEquals('r', Piece.createWhiteRook().getSymbol()); // 
	}
	
	
	//말의 색 말인지 확인 하는 테스트 코드 
	public void testIsBlack() throws Exception {
		boolean actual = Piece.createBlackBishop().isBlack();
		assertTrue(actual);
		
		boolean actual1 = Piece.createWhiteBishop().isBlack();
		assertFalse(actual1);
	}
	
	public void testPoint() throws Exception {
		assertEquals(3.0, Piece.createBlackBishop().getPoint());
		
	}
}
