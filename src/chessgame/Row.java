package chessgame;

import pieces.*;
import pieces.Piece.Color;
import pieces.Piece.Type;
import static pieces.Piece.Color.*;

import java.util.ArrayList;


public class Row {
	
 
	private ArrayList<Piece> rowList = new ArrayList<Piece>(); //행의 리스트 : 열값을 저장 

	
	/**
	 * 체스보드 빈공간 초기화 
	 * @return 빈공간 초기화를 마친 row(행)
	 */
	public void initEmpty() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.createEmpty());
		}
	}
	
	/**
	 * 체스보드 검은말 폰 초기화 
	 * @return 검은말 초기화를 마친 row(행)
	 */
	public void initBlackPawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.createBlackPawn());
		}
	}
	
	/**
	 * 체스보드 흰색말 폰 초기화 
	 * @return 흰색말 초기화를 마친 row(행) 위치
	 */
	public void initWhitePawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.createWhitePawn());
		}
	}
	
	/**
	 * 체스보드 검은색 말 초기화 (폰을 제외한 나머지)
	 * @return 검은색 말 초기화를 마친 row(행) 위치
	 */
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
	
	/**
	 * 체스보드 흰색말 초기화 (폰을 제외한 나머지)
	 * @return 흰색색 말 초기화를 마친 row(행) 위치
	 */
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
	 * 외부에서 rowList에 접근 하는 메소드 
	 * @return rowList
	 */
	public ArrayList<Piece> getList() {
		return rowList;
	}

	
	/**
	 * board 클래스에서 색과 말의 종류로 갯수 확인하는 메소드를 돕는 메소드 
	 * @param color 찾고자 하는 색 
	 * @param type 찾고자 하는 말의 종류 
	 * @return row에서 같은 수 
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
	 * countByTypeColor 메소드를 돕는 메소드 
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

	public Piece getColumn(int col) {
		return rowList.get(col);
	}
}
