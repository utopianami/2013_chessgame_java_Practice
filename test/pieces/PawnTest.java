package pieces;

import pieces.Pawn;
import junit.framework.TestCase;

public class PawnTest extends TestCase {
	
	private Pawn youngnam;
	private Pawn soojung;
	
	public void setUp(){
		//테스트 전 공통적인 인스터스 모음   
		youngnam = new Pawn("white");
		soojung = new Pawn("black");
	}
	
	public void testCreate() throws Exception {
		//인스턴스 생성 확인 
		String actual = youngnam.color;
		assertEquals("white", actual);
		
		actual = soojung.color;
		assertEquals("black", actual);
		
	}
	
	public void testCreate2() throws Exception {
		//생성자에 인자값이 없는 경우 초기값을 "white"로 설정 
		Pawn youngnam = new Pawn();
		assertEquals("white", youngnam.color);
	}
}
