package pieces;

import pieces.Pawn;
import junit.framework.TestCase;


public class PawnTest extends TestCase {
	

	
	//Pawn Class 생성 확인 테스트 코드 
	public void testCreate() throws Exception {
		
		//생성 후 색깔 확인 
		assertEquals(Pawn.BLACK_PLAYER, new Pawn(Pawn.BLACK_PLAYER, Pawn.PAWN_SYMBOL).getColor());
		assertEquals(Pawn.WHITE_PLAYER, new Pawn(Pawn.WHITE_PLAYER, Pawn.PAWN_SYMBOL).getColor());
		
		//생성 후 심볼 확인(체스판에 출력될 값)
		assertEquals('P', new Pawn(Pawn.BLACK_PLAYER, Pawn.PAWN_SYMBOL).getSymbol()); //검은색 말 확인 : 대문자 'P' 
		assertEquals('p', new Pawn(Pawn.WHITE_PLAYER, Pawn.PAWN_SYMBOL).getSymbol()); //흰색 말 확인 : 소문자 'p'

		//생성 후 심볼 출력 
		System.out.println(new Pawn(Pawn.BLACK_PLAYER, Pawn.PAWN_SYMBOL).getSymbol());
		System.out.println(new Pawn(Pawn.WHITE_PLAYER, Pawn.PAWN_SYMBOL).getSymbol());
		System.out.println(new Pawn(Pawn.EMPTY, Pawn.EMPTY_SYMBOL).getSymbol());
	}
}
