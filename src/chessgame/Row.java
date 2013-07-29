package chessgame;

import pieces.*;
import pieces.Piece.Color;
import pieces.Piece.Type;
import static pieces.Piece.Color.*;
import static pieces.Piece.Type.*;

import java.util.ArrayList;
import java.util.HashMap;


public class Row {
	//Board Class의 chessBoard 배열의 행 : 열 값을 저장
	private ArrayList<Piece> rowList = new ArrayList<Piece>();  

	
	//빈공간 초기화 
	public void initEmpty() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.createEmpty());
		}
	}
	
	//검은색 Pawn 초기화 
	public void initBlackPawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.createBlackPawn());
		}
	}

	//흰색 pawn초기화 
	public void initWhitePawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.createWhitePawn());
		}
	}
	
	//검은색 말 초기화 (pawn제외)
	public void initBlackLine() {
		rowList.add(Piece.createBlackRook());
		rowList.add(Piece.createBlackKnight());
		rowList.add(Piece.createBlackBishop());
		rowList.add(Piece.createBlackQueen());
		rowList.add(Piece.createBlackKing());
		rowList.add(Piece.createBlackBishop());
		rowList.add(Piece.createBlackKnight());
		rowList.add(Piece.createBlackRook());
	}
	
	//흰색 말 초기화 (pawn제외)
	public void initWhiteLine() {
		rowList.add(Piece.createWhiteRook());
		rowList.add(Piece.createWhiteKnight());
		rowList.add(Piece.createWhiteBishop());
		rowList.add(Piece.createWhiteQueen());
		rowList.add(Piece.createWhiteKing());
		rowList.add(Piece.createWhiteBishop());
		rowList.add(Piece.createWhiteKnight());
		rowList.add(Piece.createWhiteRook());
	}

	/**
	 * getColmun
	 * 목적 : 원하는 행의 말을 확인 
	 * @param col
	 * @return Piece 
	 */
	public Piece getColumn(int col) {
		return rowList.get(col);
	}
	
	/**
	 * countByTyoeColor
	 * 목적 : 원하는 색과 종류에 해당하는 말의 갯수 확인
	 * 활용 : Board Class_countByTypeColor()에서 각 행마다 갯수를 확인 
	 * @param color 찾고자 하는 색 
	 * @param type 찾고자 하는 말의 종류 
	 * @return 숫자 
	 */
	public int countByTypeColor(Color color, Type type) {
		int count =0;
		for (Piece piece : rowList) {
			if (this.isColorTypeSame(piece, color, type)){
				count++;
			}
			else;
		}
		return count;
	}

	/**
	 * isColorTypeSame
	 * 목적 : 원하는 색과 종류의 말이 맞는지 확인
	 * 활용 : Row Class_countByTypeColor() 
	 * @param color
	 * @param type
	 * @return True or False 
	 */
	private boolean isColorTypeSame(Piece piece, Color color, Type type) {
		if (piece.getType() == type && piece.getColor() == color){
			return true;
		}
		else{
			return false;			
		}
	}


	/**
	 * setColumn
	 * 목적 : 정해진 위치의 Piece를 바꾸는 것
	 * 활용 : Board Class_changePiece()
	 * @param col 정해진 위치 
	 * @param type 바꾸고자 하는 말의 종류 
	 * @param color 말의 색 
	 */

	public void setColumn(int col, Type type, Color color) {
		if (color == BLACK){
			rowList.set(col, Piece.createBlack(type));			
		}
		
		else if (color == WHITE){
			rowList.set(col, Piece.createWhite(type));			
		}
		
		else{
			rowList.set(col, Piece.createEmpty());						
		}
		
	}
	


	/**
	 * findPawnPosition
	 * 목적 : 열에서 체스판 위에 있는 pawn을 hashmap으로 표현  
	 * 활용 : Board Class_checkPawn() 
	 * @param color 
	 * @param pawnPosition 
	 * @return hashmap : pawn의 열의 위치와 숫자
	 */
	public HashMap<Integer, Integer> findPawnPosition(Color color, HashMap<Integer, Integer> pawnPosition) {
		int column = 0;//열의 위치를 파악하기 위해서 
		

		for (Piece piece : rowList) {
			if (ispawn(color, piece)){
				if(isContain(pawnPosition, column)){

					int newVal = pawnPosition.get(column)+1; // value에 +1

					pawnPosition.remove(column); //기존 value값을 삭제 
					pawnPosition.put(column, newVal); //새로운 value 값을 저장  
				}
				else{
					pawnPosition.put(column, 1); //열이 없을 경우 key 생성 후 1 추가 
			}
			
			}
			column++; //다음 열 
		}
		return pawnPosition;
	}

	
	/**
	 * row클래스 checkPawn 메소드에서 if 조건에 대한 메소드 
	 * pawn 클래스인지, 같은 색인지를 물어보는 메소드 
	 * @param color, piece
	 * @return true, false
	 */
	private boolean ispawn(Color color, Piece piece) {
		return piece.getType().equals(PAWN) && piece.getColor().equals(color);
	}


	
	/**
	 * row클래스 checkPawn 메소드에서 if 조건에 대한 메소드 
	 * 열의 위치가 같은지를 물어보는 메소드 
	 * @param pawnPosition
	 * @param column
	 * @return true, false
	 */
	private boolean isContain(HashMap<Integer, Integer> pawnPosition, int column) {
		return pawnPosition.containsKey(column);
	}
	
	
	/**
	 * 보드판에서 색깔에 맞는 말들은 모두 취합 
	 * @param color 찾고자 하는 색 
	 * @param nowPieceList 추가하는 리스트 
	 * @return 추가한 후 리스트 반환 
	 */
	public ArrayList<Piece> addPiece(Color color, ArrayList<Piece> nowPieceList) {
		for (Piece piece : rowList) {
			if (piece.isColor(color)) {
				nowPieceList.add(piece);
			}
		}
		return nowPieceList;
		
	}
	
	/**
	 * rowPrint
	 * 목적 : 해당하는 행을 출력
	 * 활용 : Board Class_BoardPrint() 
	 * @return 행에 존재하는 열들의 모음 
	 */
	
	public String rowPrint() {
		StringBuilder row = new StringBuilder();
		
		for (Piece piece : rowList) {
			row.append(piece.getSymbol());			
		}
		return row.toString();
	}
	
	

}
