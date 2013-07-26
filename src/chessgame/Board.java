package chessgame;

import static util.StringUtil.NEWLINE;
import pieces.*;
import pieces.Piece.Color;
import pieces.Piece.Type;

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
		
		Piece.resetCount(); //숫자 초기화 
		
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
	 * Position 클래스의 transfer()메소드를 통해서 x,y좌표를 받
	 * @param 찾고하는 위치  
	 * @return 찾은 좌표값(행, 열)의 SYMBOL
	 */
	public char getMapInfo(String xAndY) {
		Position position = new Position();
		position.transfer(xAndY);
		
		return chessBoard.get(position.x).getColumn(position.y).getSymbol();
	}


	
	/**
	 * 체스보드 프린트 
	 * @param 프린트 하고 싶은 라인(row)
	 * @return 열 전체(라인에 있는 열들의 집합)
	 */
	public String linePrint(Row row) {
		StringBuilder Line = new StringBuilder();
		
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			Line.append(row.getList().get(column).getSymbol());			
		}
		return Line.toString();
	}
	
	/**
	 * 체스보드전 프린트 
	 * @param 프린트 하고 싶은 보드 
	 * @return 보드 전체 
	 */
	public String boardPrint() {
		StringBuilder boardPrint = new StringBuilder();
		
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			String line = linePrint(chessBoard.get(column));  //linePrint함수 호출
			boardPrint.append(line); // 추가
			boardPrint.append(NEWLINE);
		}
		return boardPrint.toString();
	}
	
	
	/**
	 * 보드판 위의 숫자 확인 
	 * @return 검은 말 + 흰색 말 
	 */
	public int pieceCount(){
		return Piece.getCount();
	}


	/**
	 * 색과 말의 종류를 받아서 보드판 위에 숫자 확인 
	 * @return count
	 */
	public int countByTypeColor(Color color, Type type) {
		int count = 0;
		for (Row boardRow : chessBoard){
			count += boardRow.countByTypeColor(color, type);
		}

		return count;
	}
		
}

