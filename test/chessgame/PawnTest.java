package chessgame;

import junit.framework.TestCase;

public class PawnTest extends TestCase {
	public void testCreate() throws Exception {
		
		String player1 = "white";
		String player2 = "black";
		
		
		Pawn youngnam = new Pawn(player1); 
		Pawn soojung = new Pawn(player2);
		
		
		String actual = youngnam.color;
		assertEquals("white", actual);

		
	}
}
