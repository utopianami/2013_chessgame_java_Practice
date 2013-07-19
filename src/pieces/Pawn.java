package pieces;


/**
 * 체스말 Pawn Class
 * @author YoungNamLee
 * 생성자 + getColor() + getSymbol()로 구성
 */


public class Pawn {

	//static 
	public static final String BLACK_PLAYER = "black";//상수 값 black
	public static final String WHITE_PLAYER = "white";//상수 값 white
	public static final String EMPTY = "empty";//상수 값 white
	
	public static final char EMPTY_SYMBOL = '.';
	public static final char PAWN_SYMBOL = 'p';
	
	//local variable
	private String color;
	private char symbol;
	
	/**
	 * 생성자 
	 * @param 색상여부, 화면출력 대소문자 
	 */
	public Pawn(String color, char symbol) {
		this.color = color;

		if (color == BLACK_PLAYER) {
			this.symbol = Character.toUpperCase(symbol);
		}
		else if (color != BLACK_PLAYER) {
			this.symbol = symbol;
		} 	
	}


	/**
	 * 클래스의 색상확인 메소드 
	 * @return 블랙, 화이트 
	 */
	public String getColor() {
		return this.color;
	}

	
	/**
	 * 클래스 심볼 확인(체스판에 출력) 메소드 
	 * @return this.symbol(대문자 혹은 소문자)
	 */

	public char getSymbol() {
		return this.symbol;
	}

}
