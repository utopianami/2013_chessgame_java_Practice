package pieces;

/**
 * Pawn 체스말 클래스 
 * @author YoungNamLee
 */

public class Pawn {
	String color;
	String player1 = "white";
	String player2 = "black";

	
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
		this.color = player1;
	}

}
