package pieces;

import pieces.Pawn;
import junit.framework.TestCase;

public class PawnTest extends TestCase {
	
	private Pawn youngnam;
	private Pawn soojung;
	
	public void setUp(){
		//테스트 전 공통적인 인스터스 모음   
		youngnam = new Pawn(Pawn.PLAYER_WHITE);
		soojung = new Pawn(Pawn.PLAYER_BLACK);
	}
	
	public void testCreate() throws Exception {
		//인스턴스 생성 확인 
		String actual = youngnam.color;
		assertEquals(Pawn.PLAYER_WHITE, actual);
		
		actual = soojung.color;
		assertEquals(Pawn.PLAYER_BLACK, actual);
		
		//print 
		
	}
	
	public void testCreate2() throws Exception {
		//생성자에 인자값이 없는 경우 초기값을 "white"로 설정 
		new Pawn();
		assertEquals(Pawn.PLAYER_WHITE, new Pawn().color);
	}
	
	
	
	public void testPawnColor() throws Exception {
		//검은색 폰은 'P', 흰색폰은 'p'출력 
		assertEquals('p', youngnam.pawnPrint); //백색 
		assertEquals('P', soojung.pawnPrint); //흑색  
		
	}
}
