package pieces;



/**
 * 체스말 Pawn Class
 * @author YoungNamLee
 * 생성자 + getColor() + getSymbol()로 구성
 */


public class Piece {
	
	private static int whiteCount;
	private static int blackCount;
	
	

	public enum Color {
		BLACK, WHITE, NONE
	}
	
	public enum Type{
		PAWN('p'), KNIGHT('n'), ROOK('r'), BISHOP('b'), QUEEN('q'), KING('k'), Empty('.');
		
		private char symbol;
		private Type(char symbol){
			this.symbol = symbol;
		}
		
		public char getSymbol(){
			return this.symbol;
		}
	}

	private Color color;
	private Type type;
	private char symbol;
	
	/**
	 * private
	 * 생성자 
	 * @param 색상여부, Type 
	 */
	private Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
		this.symbol = type.getSymbol();

		
		if (isBlack()) {
			this.symbol = (Character.toUpperCase(this.symbol));
			}
	}
	
	
	
	private static Piece createWhite(Type type) {
		whiteCount++;
		return new Piece(Color.WHITE, type);
	}
	

	private static Piece createBlack(Type type) {
		blackCount++;
		return new Piece(Color.BLACK, type);
	}

	public static Piece createEmpty(){
		return new Piece(Color.NONE, Type.Empty);
	}

		
	public static Piece createWhitePawn(){
		return createWhite(Type.PAWN);
	}

	public static Piece createBlackPawn(){
		return createBlack(Type.PAWN);
	}
	
	public static Piece createWhiteRook(){
		return createWhite(Type.ROOK);
	}
	
	public static Piece createBlackRook(){
		return createBlack(Type.ROOK);
	}
	
	public static Piece createWhiteKnight(){
		return createWhite(Type.KNIGHT);
	}
	
	public static Piece createBlackKnight(){
		return createBlack(Type.KNIGHT);
	}
	
	public static Piece createWhiteBishop(){
		return createWhite(Type.BISHOP);
	}
	
	public static Piece createBlackBishop(){
		return createBlack(Type.BISHOP);
	}

	public static Piece createWhiteQueen(){
		return createWhite(Type.QUEEN);
	}
	
	public static Piece createBlackQueen(){
		return createBlack(Type.QUEEN);
	}
	
	public static Piece createWhiteKing(){
		return createWhite(Type.KING);
	}
	public static Piece createBlackKing(){
		return createBlack(Type.KING);
	}
	



	/**
	 * 클래스의 색상확인 메소드 
	 * @return 블랙, 화이트 
	 */
	public Color getColor() {
		return this.color;
	}

	
	/**
	 * type 확인 
	 * @return type
	 */
	public Type getType() {
		return this.type;
	}


	/**
	 * 심볼 확인 
	 * @return symbol
	 */
	public char getSymbol() {
		return this.symbol;
	}

	
	/**
	 * 흰색말인 확인 
	 * @return true or false
	 */
	public boolean isWhite() {
		if (this.color == Color.WHITE){
			return true;
		}
		return false;
	}

	
	/**
	 * 검은말인 확인 
	 * @return true or false
	 */
	public boolean isBlack() {
		if (this.color == Color.BLACK){
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (type != other.type)
			return false;
		return true;
	}



	public static int getCount() {
		return Piece.blackCount + whiteCount;
	}
	
	public static void resetCount() {
		Piece.blackCount = 0 ; 
		Piece.whiteCount = 0 ;
	}




	
}
