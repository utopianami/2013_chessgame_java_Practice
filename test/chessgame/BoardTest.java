package chessgame;

import junit.framework.TestCase;

public class BoardTest extends TestCase {
	
	private Board youngnamBoard;
	
	
	public void setUp(){
		//테스트 전 공통적인 인스터스화 모음  
		youngnamBoard = new Board();
		
	}
	
	
	public void testInitalize() throws Exception {
		
		youngnamBoard.initalizeBoard();
		//System.out.println(youngnamBoard.chessBoard);	
		
		System.out.println(youngnamBoard.boardPrint());
	}
	
}