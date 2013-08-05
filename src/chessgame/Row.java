package chessgame;

import pieces.*;
import pieces.Piece.Color;
import pieces.Piece.Type;
import static pieces.Piece.Color.*;
import static pieces.Piece.Type.*;

import java.util.ArrayList;
import java.util.HashMap;


public class Row {
	//Board Class의 chessBoard 배열의 행 : 열 값을 저장
	private ArrayList<Piece> rowList = new ArrayList<Piece>();  

	
	//빈공간 초기화 
	public void initEmpty() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.createEmpty());
		}
	}
	
	//검은색 Pawn 초기화 
	public void initBlackPawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.createBlackPawn());
		}
	}

	//흰색 pawn초기화 
	public void initWhitePawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.createWhitePawn());
		}
	}
	
	//검은색 말 초기화 (pawn제외)
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
	
	//흰색 말 초기화 (pawn제외)
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

	public Piece getColumn(int col) {
		return rowList.get(col);
	}
	
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

	private boolean isColorTypeSame(Piece piece, Color color, Type type) {
		if (piece.getType() == type && piece.getColor() == color){
			return true;
		}
		else{
			return false;			
		}
	}

	public void setColumn(int col, Type type, Color color) {
		if (color.equals(BLACK)){
			rowList.set(col, Piece.createBlack(type));			
		}
		
		else if (color.equals(WHITE)){
			rowList.set(col, Piece.createWhite(type));			
		}
		
		else{
			rowList.set(col, Piece.createEmpty());						
		}
	}

	public HashMap<Integer, Integer> findPawnPosition(Color color, HashMap<Integer, Integer> pawnPosition) {
		int column = 0;//열의 위치를 파악하기 위해서 
		for (Piece piece : rowList) {
			if (isPawn(color, piece)){ //원하는 색의 pawn이라면 
				if(isContain(pawnPosition, column)){ //열(key)이 존재할 경우 숫자(value) +1 
					int newVal = pawnPosition.get(column)+1; // value에 +1

					pawnPosition.remove(column); //기존 value값을 삭제 
					pawnPosition.put(column, newVal); //새로운 value 값을 저장  
				}
				else{
					pawnPosition.put(column, 1); //열이 없을 경우 key 생성 후 1 추가 
				}
			}
			column++; //다음 열 
		}
		return pawnPosition;
	}

	private boolean isPawn(Color color, Piece piece) {
		return piece.getType().equals(PAWN) && piece.getColor().equals(color);
	}

	private boolean isContain(HashMap<Integer, Integer> pawnPosition, int column) {
		return pawnPosition.containsKey(column);
	}
	
	
	public ArrayList<Piece> addNowPiece(Color color, ArrayList<Piece> nowPieceList) {
		for (Piece piece : rowList) {
			if (piece.isColor(color)) {
				nowPieceList.add(piece);
			}
		}
		return nowPieceList;
	}
	
	public String rowPrint() {
		StringBuilder row = new StringBuilder();
		
		for (Piece piece : rowList) {
			row.append(piece.getSymbol());			
		}
		return row.toString();
	}
	
}
