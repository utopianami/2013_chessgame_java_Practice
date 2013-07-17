package chessgame;

import junit.framework.TestCase;

public class BoardTest extends TestCase {
	
	
	private Board youngnamBoard;//youngnamBoard 생성 
	
	public void setUp(){
		//테스트 전 공통적인 인스터스화 모음  
		youngnamBoard = new Board();	
	}
	
	
	//체스판 초기화 후 출력 
	public void testInitalize() throws Exception {
		
		System.out.println(youngnamBoard.boardPrint());
	}
	
}