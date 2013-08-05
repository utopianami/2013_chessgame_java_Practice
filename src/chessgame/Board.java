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
	
	ArrayList<Piece> nowPieceList = new ArrayList<Piece>();
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
	

	public Piece getMapInfo(String xAndY) {
		Position position = new Position();
		position.transfer(xAndY);
		
		return chessBoard.get(position.x).getColumn(position.y);
	}

	public String boardPrint() {
		StringBuilder boardPrint = new StringBuilder();
		
		for (Row row : chessBoard) {
			boardPrint.append(row.rowPrint()); //rowPrint()메소드를 활용
			boardPrint.append(NEWLINE);
		}
		return boardPrint.toString();
	}
	
	
	public int pieceCount(){
		return Piece.blackCount + Piece.whiteCount;
	}
	
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

	public int countByTypeColor(Color color, Type type) {
		int count = 0;
		for (Row boardRow : chessBoard){
			count += boardRow.countByTypeColor(color, type);
		}
		return count;
	}

	public void changePiece(String xAndY, Type type, Color color) {
		Position position = new Position();
		position.transfer(xAndY); //매개변수 xAndY를 좌표값으로 변경 
				 
		Piece beforePiece = this.getMapInfo(xAndY);//바꾸고자 하는 위치에 존재하는 이전 말을 저장
		chessBoard.get(position.x).setColumn(position.y, type, color); //위치에 삽입 
		
		//변경하기전 위치의 piece가 빈공간이 아니라면 카운트와 포인트 변경
		if (!beforePiece.isEmpty()){
			beforePiece.changeInfo();
			}
	}

	public void movePiece(String fromXAndY, String toXAndY) {
		
		Piece piece = this.getMapInfo(fromXAndY); //옮기고자 하는 말의 정보 받기 
		Color color = piece.getColor();
		Type type = piece.getType();  
		
		changePiece(toXAndY, type, color); // 말을 옮김 
		changePiece(fromXAndY, Empty, NONE);// 옮기고 난 후 그 위치는 empty초기화
	}
	


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
	
	private void getNowPiece(Color color) {
		for (Row row : chessBoard) {
			nowPieceList = row.addNowPiece(color, nowPieceList);
		}
	}
	
	private boolean isSort(double result) {
		return result >= 0;
	}

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

	private boolean isFirstIndex(int index, int nextOrigin) {
		return (index-nextOrigin) < 0;
	}
}

