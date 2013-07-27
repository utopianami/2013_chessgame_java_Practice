package chessgame;

import static util.StringUtil.NEWLINE;
import pieces.*;
import pieces.Piece.Color;
import pieces.Piece.Type;
import static pieces.Piece.Color.*;
import static pieces.Piece.Type.*;

import java.util.ArrayList;
import java.util.HashMap;


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
	public Piece getMapInfo(String xAndY) {
		Position position = new Position();
		position.transfer(xAndY);
		
		return chessBoard.get(position.x).getColumn(position.y);
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
		return Piece.blackCount + Piece.whiteCount;
	}
	
	/**
	 * 보드판 위에 점수 확인 
	 * @param 확인하고 하는 색 
	 * @return 점수
	 * piece 예외처리를 위해서 row 클래스 checkPawn 메소드 활용 : pawn 위치 정보 저장
	 * position의 countSamePosition메소드를 활용해서 같은 열에 있는 pawn 수를 구한다.  
	 */
	public void checkPoint(Color color){
		int exceptionPawn = 0;
		
		if(color == BLACK){
			exceptionPawn = this.checkPawn(BLACK);
			Piece.blackPoint -= exceptionPawn*0.5;
		}

		else;
			exceptionPawn = this.checkPawn(WHITE);
			Piece.whitePoint -= exceptionPawn*0.5;
	}
	
	/**
	 *checkPoint메소드에서 pawn에 대한 예외 처리 
	 *row class의 findPawnPositiona메소드를 통해서 hashmap 저장   
	 * @return 
	 */
	public int checkPawn(Color color){
		HashMap<Integer, Integer> pawnPosition = new HashMap<Integer, Integer>();
		int exceptionPawn = 0; //예외 처리해야 될 pawn의 
		
		//hashmap 완성 
		for (Row row : chessBoard) {
			pawnPosition = row.findPawnPosition(color, pawnPosition);
		}
		
		//0.5로 변환 해줘야 할 pawn 갯수 확인 
		for (Integer pawn : pawnPosition.keySet() ) {
			if (pawnPosition.get(pawn) > 1){
				exceptionPawn += pawnPosition.get(pawn);
			}
		}
		
		return exceptionPawn;
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

	/**
	 * 원하는 위치에 원하는 말 삽입 
	 * @param string : 좌표 
	 * @param type : 삽입하고자 하는 말
	 * getMapInfo메소드 활용   
	 * Row 클래스에서 setColmun 메소드 활용 
	 */

	public void changePiece(String xAndY, Type type, Color color) {
		Position position = new Position();
		position.transfer(xAndY);
		
		Piece beforePiece = this.getMapInfo(xAndY);
		chessBoard.get(position.x).setColumn(position.y, type, color);
		
		
		//변경하기전 위치의 piece가 빈공간이 아니라면 카운트에서 제외
		if (beforePiece.getType() != Empty){
			if (color == WHITE) {
				Piece.whiteCount --;
				//이전 Piece의 point는 삭제 
				this.changePoint(beforePiece.getColor(), beforePiece.getType());
			}
			else{
				Piece.blackCount--;
				//이전 Piece의 point는 삭제 
				this.changePoint(color, type);
			}
		}
		
		//추가되는 Piece의 point추가 중복방지 
		this.changePoint(color, type);
	}


	/**
	 * 원하는 위치로 말을 옮김 
	 * @param fromXAndY 옮기고자 하는 말의 현재 위치 
	 * @param toXAndY 옮기고자 하는 위치
	 * changePiece메소드 활용  
	 */
	public void movePiece(String fromXAndY, String toXAndY) {
		//옮기기전 위치에서 정보 추출(color, type)
		Color color = this.getMapInfo(fromXAndY).getColor();
		Type type = this.getMapInfo(fromXAndY).getType();
		
		changePiece(toXAndY, type, color); //옮기고자 하는 곳에 정보 입력 
		changePiece(fromXAndY, Empty, NONE);// 이전 위치는 empty로 변환 
	}
	
	
	
	/**
	 * 삭제나 이동했을때 중복을 발생시키지 않기 위해서 
	 */
	public void changePoint(Color color,Type type){
		if (color ==WHITE){
			Piece.whitePoint -= type.getPoint();
		}
		else{
			Piece.blackPoint -= type.getPoint();			
		}
	}
		
}

