package chessgame;

import junit.framework.TestCase;


public class Alltest extends TestCase {
	public static junit.framework.TestSuite suite(){
		junit.framework.TestSuite suite = new junit.framework.TestSuite();
		
		suite.addTestSuite(PawnTest.class);
		
		return suite;
		
	}

}

