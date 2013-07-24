package chessgame;

import static util.StringUtil.NEWLINE;
import pieces.*;

import java.util.ArrayList;


/**
 * 체스판 
 * @author YoungNamLee
 * 체스판 초기화 + getMapInfo()
 * 특이사항 : 2차원 배열을 만들때 Row Class를 통해서 행 처리 
 */

public class Board {
	
	public static final int ROW_LENGTH = 8;//행의 길이는 8
	public static final int COLUM_LENGTH = 8;//열의 길이는 8
	
	//체스판에 쓰일 2차원 배열 chessBoard 선언
	//<Row> Row class의 배열, Row 클래스는 또 다른 배열(체스판의 행)
	ArrayList<Row> chessBoard = new ArrayList<Row>();
	
	//생성자 
	public Board(){
		
		for (int row = 0; row < ROW_LENGTH; row++){
			
			//Black_Line 초기화 
			if (row ==0){
				Row RowLine0 = new Row();
				chessBoard.add(RowLine0);
				RowLine0.initBlackLine();				
				continue;
			}
			
			//Black_Pawn 초기화 
			if (row == 1){
				Row RowLine1 = new Row();
				chessBoard.add(RowLine1);
				RowLine1.initBlackPawn();				
				continue;
			}
			
			//White_Pawn 초기화 
			if (row == 6){
				Row RowLine6 = new Row();
				chessBoard.add(RowLine6);
				RowLine6.initWhitePawn();				
				continue;
			}
			
			//White_Line 초기화 
			if (row == 7){
				Row RowLine7 = new Row();
				chessBoard.add(RowLine7);
				RowLine7.initWhiteLine();				
				continue;
			}
			
			//빈공간 초기화 
			Row RowLineEmpty = new Row();
			chessBoard.add(RowLineEmpty);
			RowLineEmpty.initEmpty();
			
		}		
	}
	
	

	/**
	 * 체스판의 좌표에 있는 SYMBOL(체스말) 확
	 * @param row 찾고자 하는 곳의 행 
	 * @param col 찾고자 하는 곳의 열 
	 * @return 찾은 좌표값(행, 열)의 SYMBOL
	 */
	public char getMapInfo(int row, int col) {
		return chessBoard.get(row).getList().get(col).getName();
	}


	/**
	 * 보드판 위에 있는 숫자 확인
	 * @return count
	 */
	public int piecesCount() {
		int totalCount = 0;
		for (Row row : chessBoard) {
			totalCount = totalCount +piecesCountRow(row);
			}
		return totalCount;
	}
	
	
	/**
	 * 라인위에 있는 숫자 확인 
	 * @param 확인 하고자 하는 row
	 * @return count
	 */
	private int piecesCountRow(Row row){
		int rowCount = 0;
		for (Piece piece : row.getList()) {
			if (isNotEmpty(piece)){
				rowCount++;
			}
		}
		return rowCount;
	}
	
	/**
	 * piecesCountRow에서 if문 확인 메소드 
	 * @param piece
	 * @return true or false
	 */
	private boolean isNotEmpty(Piece piece){
		if(piece.getName() != Piece.EMPTY){
			return true;
		}
		else;
			return false;
	}
	



	
	/**
	 * 체스보드 프린트 
	 * @param 프린트 하고 싶은 라인(row)
	 * @return 열 전체(라인에 있는 열들의 집합)
	 */
	public String linePrint(Row row) {
		StringBuilder Line = new StringBuilder();
		
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			Line.append(row.getList().get(column).getName());			
		}
		return Line.toString();
	}
	
	/**
	 * 체스보드전 프린트 
	 * @param 프린트 하고 싶은 보드 
	 * @return 보드 전체 
	 */
	public String boardPrint(ArrayList<Row> board) {
		StringBuilder boardPrint = new StringBuilder();
		
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			String line = linePrint(board.get(column));  //linePrint함수 호출
			boardPrint.append(line); // 추가
			boardPrint.append(NEWLINE);
		}
		return boardPrint.toString();
	}


	
}

