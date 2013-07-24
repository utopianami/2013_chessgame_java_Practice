package chessgame;

import pieces.*;

import java.util.ArrayList;

import static util.StringUtil.NEWLINE;

public class Row {
	
 
	private ArrayList<Piece> rowList = new ArrayList<Piece>(); //행의 리스트 : 열값을 저장 

	
	/**
	 * 체스보드 빈공간 초기화 
	 * @return 빈공간 초기화를 마친 row(행)
	 */
	public void initEmpty() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.create(Piece.EMPTY, Piece.EMPTY_PLAYER));
		}
	}
	
	/**
	 * 체스보드 검은말 폰 초기화 
	 * @return 검은말 초기화를 마친 row(행)
	 */
	public void initBlackPawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.create(Piece.PAWN, Piece.BLACK_PLAYER));
		}
	}
	
	/**
	 * 체스보드 흰색말 폰 초기화 
	 * @return 흰색말 초기화를 마친 row(행) 위치
	 */
	public void initWhitePawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.create(Piece.PAWN, Piece.WHITE_PLAYER));
		}
	}
	
	/**
	 * 체스보드 검은색 말 초기화 (폰을 제외한 나머지)
	 * @return 검은색 말 초기화를 마친 row(행) 위치
	 */
	public void initBlackLine() {
		rowList.add(Piece.create(Piece.ROOK, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.KNIGHT, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.BISHOP, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.QUEEN, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.KING, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.BISHOP, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.KNIGHT, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.ROOK, Piece.BLACK_PLAYER));
	}
	
	/**
	 * 체스보드 흰색말 초기화 (폰을 제외한 나머지)
	 * @return 흰색색 말 초기화를 마친 row(행) 위치
	 */
	public void initWhiteLine() {
		rowList.add(Piece.create(Piece.ROOK, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.KNIGHT, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.BISHOP, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.QUEEN, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.KING, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.BISHOP, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.KNIGHT, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.ROOK, Piece.WHITE_PLAYER));
	}

	/**
	 * 외부에서 rowList에 접근 하는 메소드 
	 * @return rowList
	 */
	public ArrayList<Piece> getList() {
		return rowList;
	}
}
