package pieces;


/**
 * 체스말 Pawn Class
 * @author YoungNamLee
 * 생성자 + getColor() + getSymbol()로 구성
 */


public class Piece {

	//static 
	public static final String BLACK_PLAYER = "black";//상수 값 black
	public static final String WHITE_PLAYER = "white";//상수 값 white
	public static final String EMPTY_PLAYER = "EMPTY";//상수 값 white
	
	public static final char EMPTY = '.';
	public static final char PAWN = 'p';
	public static final char KNIGHT= 'n';
	public static final char ROOK = 'r';
	public static final char BISHOP = 'b';
	public static final char QUEEN = 'q';
	public static final char KING = 'k';
	
	//local variable
	private String color;
	private char name;
	
	/**
	 * private
	 * 생성자 
	 * @param 색상여부, 화면출력 대소문자 
	 */
	private Piece(char name, String color) {
		this.name = name;
		this.color = color;

		if (color == BLACK_PLAYER) {
			this.name = Character.toUpperCase(name);
		}
		else if (color == WHITE_PLAYER) {
			this.name = name;
		} 
	}
	
	/**
	 * 접근 가능 생성자 
	 * @param name : 이름(말의 종류)
	 * @param color : 말의 색깔 (흑백 여)
	 * @return 
	 * @return 생성자 전달 
	 */
	public static Piece create(char name, String color){
		return new Piece(name, color);
		
	}


	/**
	 * 클래스의 색상확인 메소드 
	 * @return 블랙, 화이트 
	 */
	public String getColor() {
		return this.color;
	}

	
	/**
	 * 말에 따라서 출력되는 name을 확인하는 메소드 
	 * @return this.name(대문자 혹은 소문자)
	 */
	public char getName() {
		return this.name;
	}

	/**
	 * 흰색말인 확인 
	 * @return true or false
	 */
	public boolean isWhite() {
		if (color == WHITE_PLAYER){
			return true;
		}
		return false;
	}

	
	/**
	 * 검은말인 확인 
	 * @return true or false
	 */
	public boolean isBlack() {
		if (color == WHITE_PLAYER){
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + name;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (name != other.name)
			return false;
		return true;
	}

	
}
