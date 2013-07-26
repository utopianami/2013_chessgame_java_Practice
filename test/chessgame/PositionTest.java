package chessgame;

import junit.framework.TestCase;

public class PositionTest extends TestCase {
	
	//문자 값 변환 메소드 
	public void testTransfer() throws Exception {
		Position test = new Position();
		test.transfer("a8");
		
		assertEquals(7, test.y);
		System.out.println(test.x);
	}

}
