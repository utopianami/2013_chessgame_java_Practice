package chessgame;

import pieces.*;
import java.util.ArrayList;


public class Row {
	
	static final String NEWLINE = System.getProperty("line.separator");//라인 넘기기(\n) 
	ArrayList<Pawn> rowList = new ArrayList<Pawn>(); //행의 리스트 : 열값을 저장 

	
	/**
	 * 체스보드 빈공간 초기화 
	 * @return 빈공간 초기화를 마친 row(행)
	 */
	public ArrayList<Pawn> initEmpty() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(new Pawn(Pawn.EMPTY, Pawn.EMPTY_SYMBOL));
		}
		return rowList;
	}
	
	/**
	 * 체스보드 검은말 초기화 
	 * @return 검은말 초기화를 마친 row(행)
	 */
	public ArrayList<Pawn> initBlackPawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(new Pawn(Pawn.BLACK_PLAYER, Pawn.PAWN_SYMBOL));
		}
		return rowList;
	}
	
	/**
	 * 체스보드 흰색말 초기화 
	 * @return 흰색말 초기화를 마친 row(행) 위치
	 */
	public ArrayList<Pawn> initWhitePawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(new Pawn(Pawn.WHITE_PLAYER, Pawn.PAWN_SYMBOL));
		}
		return rowList;
	}
	
	/**
	 * 체스보드 프린트 
	 * @param 프린트 하고 싶은 라인(row)
	 * @return 열 전체(라인에 있는 열들의 집합)
	 */
	public String linePrint(ArrayList<Pawn> row) {
		StringBuilder Line = new StringBuilder();
		
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			Line.append(row.get(column).getSymbol());			
		}
		return Line.toString();
	}
	
	/**
	 * 체스보드전 프린트 
	 * @param 프린트 하고 싶은 보드 
	 * @return 보드 전체 
	 */
	public String boardPrint(ArrayList<ArrayList<Pawn>> board) {
		StringBuilder boardPrint = new StringBuilder();
		
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			String line = linePrint(board.get(column));  //linePrint함수 호출
			boardPrint.append(line); // 추가
			boardPrint.append(NEWLINE);
		}
		return boardPrint.toString();
	}
	

}
