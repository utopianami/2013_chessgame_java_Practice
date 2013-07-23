package pieces;

import pieces.Piece;
import junit.framework.TestCase;


public class PieceTest extends TestCase {
	

	
	//Pawn Class 생성 확인 테스트 코드 
	public void testCreate() throws Exception {
		
		//생성 후 색깔 확인 
		assertEquals(Piece.BLACK_PLAYER, Piece.create(Piece.PAWN, Piece.BLACK_PLAYER).getColor());
		assertEquals(Piece.WHITE_PLAYER, Piece.create(Piece.PAWN, Piece.WHITE_PLAYER).getColor());
		
		//생성 후 심볼 확인(체스판에 출력될 값)
		assertEquals('P', Piece.create(Piece.PAWN, Piece.BLACK_PLAYER).getName()); //검은색 말 확인 : 대문자 'P' 
		assertEquals('p', Piece.create(Piece.PAWN, Piece.WHITE_PLAYER).getName()); //흰색 말 확인 : 소문자 'p'
	}
	
	//흰색말인지 확인 하는 테스트 코드 
	public void testIswhite() throws Exception {
		boolean actual = Piece.create(Piece.PAWN, Piece.BLACK_PLAYER).isWhite();
		assertFalse(actual);
		
		boolean actual1 = Piece.create(Piece.PAWN, Piece.WHITE_PLAYER).isWhite();
		assertTrue(actual1);
	}
	
	//검은색 말인지 확인 하는 테스트 코드 
	public void testIsBlack() throws Exception {
		boolean actual = Piece.create(Piece.PAWN, Piece.WHITE_PLAYER).isBlack();
		assertTrue(actual);
		
		boolean actual1 = Piece.create(Piece.PAWN, Piece.BLACK_PLAYER).isBlack();
		assertFalse(actual1);
	}
}
