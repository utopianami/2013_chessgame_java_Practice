package chessgame;


import junit.framework.TestCase;


public class RowTest extends TestCase {

	Row row;
	
	public void setUp(){
		row = new Row();
	}

	
	//체스판 빈공간 초기화 
	public void testInitEmpty() throws Exception {	
		
		
		row.initBlackPawn();
		assertEquals("PPPPPPPP", row.rowPrint());
	}
	

}
