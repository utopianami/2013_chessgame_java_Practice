package chessgame;

import pieces.Pawn;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	
	private Pawn player1;
	private Pawn player2;
	private Board youngnamBoard;
	int actual;
	
	public void setUp(){
		//테스트 전 공통적인 인스터스화 모음  
		youngnamBoard = new Board();
		player1 = new Pawn();
		player2 = new Pawn();
	}
	
	public void testCreate() throws Exception {
		//체스판 위에 말 확인 
		actual = youngnamBoard.getPiecesNumber();
		assertEquals(0, actual);
		
	}
	
	public void testCheckNumber() throws Exception {
		//말을 체스판으로 옮기는 함수 
		youngnamBoard.enroll(player1);
		youngnamBoard.enroll(player2);
		
		//체스판 위에 말의 숫자 확인 
		actual = youngnamBoard.getPiecesNumber();
		assertEquals(2, actual);
		
		//체스판 위에 말의 인스터스 확인 
		assertEquals(player1, youngnamBoard.getPieces(0));
		assertEquals(player2, youngnamBoard.getPieces(1));
	}
	

}
