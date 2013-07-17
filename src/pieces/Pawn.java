package pieces;

/**
 * Pawn 체스말 클래스 
 * @author YoungNamLee
 */

public class Pawn {
	
	public static String PLAYER_WHITE = "white";
	public static String PLAYER_BLACK = "black";
	public static String EMPTY = "empty";
	
	public String color; // player 말 
	public String pawnPrint; //보드판 출력 

	
	/**
	 * 체스말 생성자 
	 * @param 흑과 백 설정 
	 */
	public Pawn(String player) {
		this.color = player;
		
		//보드판 출력 상수인 pawnPrint 값 결정  
		if (this.color == "white"){ //white는 소문자 
			this.pawnPrint = "p";
		}
		
		else if (this.color =="black"){ //black는 대문자 
			this.pawnPrint = "P";
		}
		else{
			this.pawnPrint = "."; //empty인 경우 .
		}
	}

	/**
	 * 생성자에 인자값이 없을 경우 기본 값을 PLAYET_WHITE = "white"로 설정 
	 */
	public Pawn() {
		this.color = PLAYER_WHITE;
		this.pawnPrint = "p";
	}
}
