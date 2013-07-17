package pieces;

import junit.framework.TestCase;

public class CharacterTest extends TestCase {
	
	//isWhitespace
	public void testWhitespace() throws Exception {
		assertEquals(true, Character.isWhitespace('\n'));
		assertTrue(Character.isWhitespace('\t'));
		assertTrue(Character.isWhitespace(' '));
	}
	
	
	//식별자 
	public void testIdentifier() throws Exception{
		assertFalse(Character.isJavaIdentifierPart('^')); //'^' 자바문자가 아니다 
		assertTrue(Character.isJavaIdentifierPart('$')); //'$'자바문자  
		assertTrue(Character.isJavaIdentifierPart('k')); //'k'자바문자
		assertTrue(Character.isJavaIdentifierStart('b')); // 'b'자바 시작문자 
		assertFalse(Character.isJavaIdentifierStart('9'));// '9'자바 시작문자가 아니다  
	}
	
	
	//소문자 식
	public void testIsLowerCase() throws Exception {
		assertTrue(Character.isLowerCase('b')); // 'b'는 소문자 
		assertTrue(Character.isLowerCase('d')); // 'd'는 소문자 
		assertFalse(Character.isLowerCase('D')); //'D'는 소문자가 아니다 
	}
	
	//숫자인지 판별 
	public void testISDigit() throws Exception {
		assertTrue(Character.isDigit('6')); //6은 숫자이다. 
		assertFalse(Character.isDigit('D')); //D는 숫자가 아니다 
	}
}