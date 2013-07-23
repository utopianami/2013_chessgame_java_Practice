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
	public ArrayList<Piece> initEmpty() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.create(Piece.EMPTY, Piece.EMPTY_PLAYER));
		}
		return rowList;
	}
	
	/**
	 * 체스보드 검은말 폰 초기화 
	 * @return 검은말 초기화를 마친 row(행)
	 */
	public ArrayList<Piece> initBlackPawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.create(Piece.PAWN, Piece.BLACK_PLAYER));
		}
		return rowList;
	}
	
	/**
	 * 체스보드 흰색말 폰 초기화 
	 * @return 흰색말 초기화를 마친 row(행) 위치
	 */
	public ArrayList<Piece> initWhitePawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.create(Piece.PAWN, Piece.WHITE_PLAYER));
		}
		return rowList;
	}
	
	/**
	 * 체스보드 검은색 말 초기화 (폰을 제외한 나머지)
	 * @return 검은색 말 초기화를 마친 row(행) 위치
	 */
	public ArrayList<Piece> initBlackLine() {
		rowList.add(Piece.create(Piece.ROOK, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.KNIGHT, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.BISHOP, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.QUEEN, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.KING, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.BISHOP, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.KNIGHT, Piece.BLACK_PLAYER));
		rowList.add(Piece.create(Piece.ROOK, Piece.BLACK_PLAYER));
		return rowList;		
	}
	
	/**
	 * 체스보드 흰색말 초기화 (폰을 제외한 나머지)
	 * @return 흰색색 말 초기화를 마친 row(행) 위치
	 */
	public ArrayList<Piece> initWhiteLine() {
		rowList.add(Piece.create(Piece.ROOK, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.KNIGHT, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.BISHOP, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.QUEEN, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.KING, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.BISHOP, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.KNIGHT, Piece.WHITE_PLAYER));
		rowList.add(Piece.create(Piece.ROOK, Piece.WHITE_PLAYER));
		return rowList;		
	}
	
	
	/**
	 * 체스보드 프린트 
	 * @param 프린트 하고 싶은 라인(row)
	 * @return 열 전체(라인에 있는 열들의 집합)
	 */
	public String linePrint(ArrayList<Piece> row) {
		StringBuilder Line = new StringBuilder();
		
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			Line.append(row.get(column).getName());			
		}
		return Line.toString();
	}
	
	/**
	 * 체스보드전 프린트 
	 * @param 프린트 하고 싶은 보드 
	 * @return 보드 전체 
	 */
	public String boardPrint(ArrayList<ArrayList<Piece>> board) {
		StringBuilder boardPrint = new StringBuilder();
		
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			String line = linePrint(board.get(column));  //linePrint함수 호출
			boardPrint.append(line); // 추가
			boardPrint.append(NEWLINE);
		}
		return boardPrint.toString();
	}


	

}
