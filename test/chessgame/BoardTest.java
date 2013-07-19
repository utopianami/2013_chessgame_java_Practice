package chessgame;

import pieces.Pawn;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	
	//Board 생성 확인 
	public void testInit() throws Exception {
		
		assertEquals(8, new Board().chessBoard.size()); //체스판 사이즈 8 확인 

	}
	
	//체스판 좌표를 통해서 위치확인 
	public void testGetState() throws Exception {
		
		//0행, 1열 위치 확인 
		assertEquals('.', new Board().getMapInfo(0,1));
		
	}

}
