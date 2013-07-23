package chessgame;

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
	ArrayList<ArrayList<Piece>> chessBoard = new ArrayList<ArrayList<Piece>>();
	
	//생성자 
	public Board(){
		
		for (int row = 0; row < ROW_LENGTH; row++){
			
			//Black_Line 초기화 
			if (row ==0){
				chessBoard.add(new Row().initBlackLine());				
				continue;
			}
			
			//Black_Pawn 초기화 
			if (row == 1){
				chessBoard.add(new Row().initBlackPawn());
				continue;
			}
			
			//White_Pawn 초기화 
			if (row == 6){
				chessBoard.add(new Row().initWhitePawn());
				continue;
			}
			
			//White_Line 초기화 
			if (row == 7){
				chessBoard.add(new Row().initWhiteLine());
				continue;
			}
			
			//빈공간 초기화 
			chessBoard.add(new Row().initEmpty());			
		}		
	}
	
	

	/**
	 * 체스판의 좌표에 있는 SYMBOL(체스말) 확
	 * @param row 찾고자 하는 곳의 행 
	 * @param col 찾고자 하는 곳의 열 
	 * @return 찾은 좌표값(행, 열)의 SYMBOL
	 */
	public char getMapInfo(int row, int col) {
		return chessBoard.get(row).get(col).getName();
	}


	/**
	 * 보드판 위에 있는 숫자 확인
	 * @return
	 */
	public int piecesCount() {
		int count = 0;
		for (int row = 0; row < ROW_LENGTH; row++) {
			for (int column = 0; column < COLUM_LENGTH; column++) {
				if (chessBoard.get(row).get(column).getColor() != Piece.EMPTY_PLAYER ){
					count += 1;
				}
			}
		}
		return count;
	}



	public int checkPiece(String color) {
		int count = 0;
		for (int row = 0; row < ROW_LENGTH; row++) {
			for (int column = 0; column < COLUM_LENGTH; column++) {
				if (chessBoard.get(row).get(column).getColor() == color ){
					count += 1;
				}
			}
		}
		return count;				
	}
	
}

