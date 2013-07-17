package pieces;

/**
 * Pawn 체스말 클래스 
 * @author YoungNamLee
 */

public class Pawn {
	
	public static String PLAYER_WHITE = "white";
	public static String PLAYER_BLACK = "black";
	
	String color;
	char PawnPrint;

	
	/**
	 * 체스말 생성자 
	 * @param 흑과 백 설정 
	 */
	public Pawn(String player) {
		this.color = player;
		
		//화면출력 백은 소문자, 흑은 대문자 
		if (this.color == "white"){
			this.PawnPrint = 'p';
		}
		
		else{
			this.PawnPrint = 'P';
		}
	}

	/**
	 * 생성자에 인자값이 없을 경우 기본 값을 player1 = "white"로 설정 
	 */
	public Pawn() {
		this.color = PLAYER_WHITE;
	}


}
