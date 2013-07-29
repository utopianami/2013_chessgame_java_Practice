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
 * Board Class
 * @author YoungNamLee
 */

public class Board {
	
	public static final int ROW_LENGTH = 8;//행의 길이는 8
	public static final int COLUM_LENGTH = 8;//열의 길이는 8
	
	//현재 board 존재하는 말의 리스트 저장 
	ArrayList<Piece> nowPieceList = new ArrayList<Piece>();
	
	//체스판에 쓰일 2차원 배열 chessBoard 선언
	//Row Class가 Piece의 리스트를 가지고 있음 
	ArrayList<Row> chessBoard = new ArrayList<Row>();
	
	//생성자 
	public Board(){
		
		Piece.resetCount(); //초기화 할 때 말의 숫자 및 포인트 초기화 
		
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
	 * getMapInfo
	 * 목적 : 좌표에 있는 SYMBOL(체스말) 확인 
	 * 활용하는 메소드 : Position Class_transfer() 인풋값을 좌표로 변환  
	 * @param 찾고하는 위치  
	 * @return 찾은 좌표값(행, 열)의 SYMBOL
	 */
	public Piece getMapInfo(String xAndY) {
		Position position = new Position();
		position.transfer(xAndY);
		
		return chessBoard.get(position.x).getColumn(position.y);
	}


	/**
	 * boardPrint
	 * 목적 : 체스판 전체 출력 
	 * 활용하는 메소드 : Row Class_rowPrint()
	 * @param 프린트 하고 싶은 보드 
	 * @return 보드 전체 
	 */
	public String boardPrint() {
		StringBuilder boardPrint = new StringBuilder();
		
		for (Row row : chessBoard) {
			boardPrint.append(row.rowPrint()); //rowPrint()메소드를 활용
			boardPrint.append(NEWLINE);
		}
		return boardPrint.toString();
	}
	
	
	/**
	 * pieceCount
	 * 목적 : 보드판 위의 숫자 확인 
	 * @return 검은 말의 수 + 흰색 말 수  
	 */
	public int pieceCount(){
		return Piece.blackCount + Piece.whiteCount;
	}
	
	/**
	 * checkPoint
	 * 목적 : 체스판의 포인트 확인
	 * 활용하는 메소드 : Board Class_checkPawn() 예외처리 해야될 pawn의 숫자를 알려줌 
	 * @param 확인하고 하는 색 
	 * @return 점수
	 */
	public void checkPoint(Color color){
		int exceptionPawn = 0; //예외 처리해야될 pawn의 숫자 
		
		if(color == BLACK){
			exceptionPawn = this.checkPawn(BLACK); //예외처리 
			Piece.blackPoint -= exceptionPawn*0.5;
		}

		else;
			exceptionPawn = this.checkPawn(WHITE); //예외처리 
			Piece.whitePoint -= exceptionPawn*0.5;
	}
	
	/**
	 * checkPawn
	 * 목적 : checkPoint 예외처리를 위해서 숫자확인
	 * 활용하는 메소드 : Row Class_finsPawnPosition() 
	 * @return 예외처리 해야될 pawn의 수 
	 */
	private int checkPawn(Color color){
		//hash map 사용 
		//사용 : (0:2, 1:3)은 0열에는 2개의 pawn이 존재, 1열에는 3개의 pawn의 존재 
		HashMap<Integer, Integer> pawnPosition = new HashMap<Integer, Integer>();
		int exceptionPawn = 0; //예외 처리해야 될 pawn의 
		
		//hash map 완성 
		for (Row row : chessBoard) {
			pawnPosition = row.findPawnPosition(color, pawnPosition);//Row Class_findPawnPosition() 활용 
		}
		
		//0.5로 변환 해줘야 할 pawn 갯수 확인 
		for (Integer colmun : pawnPosition.keySet() ) {
			if (pawnPosition.get(colmun) > 1){ //열의 갯수가 1초과만 예외처리 
				exceptionPawn += pawnPosition.get(colmun);
			}
		}
		return exceptionPawn;
	}

	
	/**
	 * countByTyoeColor
	 * 목적 : 색과 말의 종류를 받아서 보드판 위에 숫자 확인
	 * 활용하는 메소드 : Row Class의 countByTypeColor() 각 열에서 색과 말의 종류가 일치하는 수를 알려줌 
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
	 * changePiece 
	 * 목적 : 원하는 위치에 원하는 말 삽입
	 * 활용하는 메소드 : Board Class_getMapInfo() 좌표의 말 확인 
	 * 활용하는 메소드 : Board Class_isNotEmpty() 삽입하는 곳이 비어있는지 확인  
	 * 활용하는 메소드 : Row Class_setColmun() row에 접근해서 해당하는 열의 값을 변경   
	 * 활용하는 메소드 : Position Class_transfer() 매개변수의 String을 좌표값으로 변경   
	 * 활용하는 메소드 : Piece Class_changeInfo() 추가/삭제에 따른 숫자/포인트 내용 변경 
	 * @param string : 삽입하고자 하는 좌표 
	 * @param type : 삽입하고자 하는 말
	 * @param Color : 삽입하고자 하는 말의 색 
	 */
	public void changePiece(String xAndY, Type type, Color color) {
		Position position = new Position();
		position.transfer(xAndY); //매개변수 xAndY를 좌표값으로 변경 
				 
		Piece beforePiece = this.getMapInfo(xAndY);//바꾸고자 하는 위치에 존재하는 이전 말을 저장
		
		chessBoard.get(position.x).setColumn(position.y, type, color); //위치에 삽입 
		
		
		//변경하기전 위치의 piece가 빈공간이 아니라면 카운트와 포인트 변경
		if (isNotEmpty(beforePiece)){
			beforePiece.changeInfo("minus");
			}
	}

	/**
	 * isNoyEmpty
	 * 목적 : 말이 비어있는지 아닌지 확인
	 * 활용 : changePiece()메소드에서 활용 
	 * @param beforePiece
	 * @return true, false
	 */
	private boolean isNotEmpty(Piece beforePiece) {
		return beforePiece.getType() != Empty;
	}


	/**
	 * movePiece
	 * 원하는 말을 다른 곳으로 옮김 
	 * 활용하는 메소드 : Board Class_getMapInfo() 좌표값을 받아서 말의 정보를 알려줌
	 * 활용하는 메소드 : Board Class_changeInfo()
	 * @param fromXAndY 옮기고자 하는 말의 현재 위치 
	 * @param toXAndY 옮기고자 하는 위치
`	 */
	public void movePiece(String fromXAndY, String toXAndY) {
		
		Piece piece = this.getMapInfo(fromXAndY); //옮기고자 하는 말의 정보 받기 
		Color color = piece.getColor();
		Type type = piece.getType();  
		
		changePiece(toXAndY, type, color); // 말을 옮김 
		changePiece(fromXAndY, Empty, NONE);// 옮기고 난 후 그 위치는 empty초기화
		piece.changeInfo("plus"); 
		/* 옮기고 난 후 empty로 초기화 할때 이전 말이 empty가 아니므로 
		point와 count를 마이너스가 됨. 그러므로 다시 플러스 해야줘야 함 */
	}
	


	/**
	 * sortByPoint
	 * 목적 : 현재 존재하는 말의 리스트를 세기(point)를 기준으로 정렬 
	 * 활용하는 메소드 : Board Class_getNowPiece() 현재 보드판위에 있는 말의 리스트 
	 * 활용하는 메소드 : Board Class_continueCompare() 정렬할때 계속 비교하기 위해서  
	 * 활용하는 메소드 : Board Class_isSort() 정렬이 되어 있는지 확인   
	 * 활용하는 메소드 : Piece Class_compare() 두 말의 point비교  
	 * @param color 정렬하고자 하는 색 
	 * @return 정렬된 리스트 
	 * getNowPiece메소드 활용 
	 */
	public void sortByPoint(Color color) {
		this.getNowPiece(color);//체스판 위에 있는 말의 리스트 만들기
		
		for (int index = 0; index < nowPieceList.size()-1 ; index++) {
			Piece origin = nowPieceList.get(index);
			Piece target = nowPieceList.get(index+1);
			double result = origin.compare(target);
			
			if (isSort(result)==false){
				nowPieceList.set(index+1, origin);
				nowPieceList.set(index, target);
				this.continueCompare(index); // 앞에 있는 index보다 작을 때까지 비교 
			}		
		}
	}
	
	/**
	 * getNowPiece
	 * 목적 : 현재 존재하는 말을 리스트로 만들기 
	 * 활용 : Board Class_sortByPoint() 현재 존재하는 말의 리스트를 알려줌 
	 * @param color리스트로 만들고자 하는 색 
	 */
	private void getNowPiece(Color color) {
		for (Row row : chessBoard) {
			nowPieceList = row.addPiece(color, nowPieceList);
		}
	}
	
	/**
	 * isNotSort
	 * 목적 : 정렬이 되어 있는지 확인 
	 * 활용 : Board Class_sortByPoint() 두 대상간 정렬여부 확인 
	 * 활용 : Board Class_continueCompare() 두 대상간 정렬여부 확인 
	 */
	private boolean isSort(double result) {
		return result >= 0;
	}


	/**
	 * continueCompare
	 * 목적 : index값이 앞의 index보다 작을 때까지 비교 
	 * 활용 : Board Class_sortByPoint()
	 * 활용하는 메소드 : Board Class_isFirstIndex() 첫번째 index인지 확인 
	 * 활용하는 메소드 : Board Class_isSort() 정렬되어 있는지 확인 
	 */
	private void continueCompare(int index) {
		//while loop에서 +1 씩 해주어서 앞의 값까지 비교 
		int nextOrigin = 1; //비교하는 값1 index-nextOrigin 
		int nextTarget = 0; //비교하는 값2 index-nextTaregt 
		
		while(true){
			if (isFirstIndex(index, nextOrigin)){ // 가장 앞의 index까지 왔다면 
				break;
			}
	
			Piece origin = nowPieceList.get(index-nextOrigin); 
			Piece target = nowPieceList.get(index-nextTarget); 
			double result = origin.compare(target);
			
			if (isSort(result)){ //정렬을 비교한 후 앞의 index와 비교 하기 위해서
				break;
			}

			nowPieceList.set(index-nextTarget, origin);
			nowPieceList.set(index-nextOrigin, target);
			
			nextOrigin++; 
			nextTarget++; 
		}

		
	}


	/**
	 * isFirstIndex
	 * 목적 : 첫번째 index인지 확
	 * 활용 : Board Class_continueCompare()  
	 */
	private boolean isFirstIndex(int index, int nextOrigin) {
		return (index-nextOrigin) < 0;
	}
}

