package pieces;

/**
 * Pawn 체스말 클래스 
 * @author YoungNamLee
 */

public class Pawn {
	String color;
	public static String PLAYER_WHITE = "white";
	public static String PLAYER_BLACK = "black";

	
	/**
	 * 체스말 생성자 
	 * @param 흑과 백 설정 
	 */
	public Pawn(String player) {
		this.color = player;
	}

	/**
	 * 생성자에 인자값이 없을 경우 기본 값을 player1 = "white"로 설정 
	 */
	public Pawn() {
		this.color = PLAYER_WHITE;
	}

}
