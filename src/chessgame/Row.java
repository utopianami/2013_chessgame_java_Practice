package chessgame;

import pieces.*;
import pieces.Piece.Color;
import pieces.Piece.Type;
import static pieces.Piece.Color.*;
import static pieces.Piece.Type.*;

import java.util.ArrayList;
import java.util.HashMap;


public class Row {
	
 
	private ArrayList<Piece> rowList = new ArrayList<Piece>(); //행의 리스트 : 열값을 저장 

	
	/**
	 * 체스보드 빈공간 초기화 
	 * @return 빈공간 초기화를 마친 row(행)
	 */
	public void initEmpty() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.createEmpty());
		}
	}
	
	/**
	 * 체스보드 검은말 폰 초기화 
	 * @return 검은말 초기화를 마친 row(행)
	 */
	public void initBlackPawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.createBlackPawn());
		}
	}
	
	/**
	 * 체스보드 흰색말 폰 초기화 
	 * @return 흰색말 초기화를 마친 row(행) 위치
	 */
	public void initWhitePawn() {
		for (int column = 0; column < Board.COLUM_LENGTH; column++) {
			rowList.add(Piece.createWhitePawn());
		}
	}
	
	/**
	 * 체스보드 검은색 말 초기화 (폰을 제외한 나머지)
	 * @return 검은색 말 초기화를 마친 row(행) 위치
	 */
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
	
	/**
	 * 체스보드 흰색말 초기화 (폰을 제외한 나머지)
	 * @return 흰색색 말 초기화를 마친 row(행) 위치
	 */
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

	/**
	 * 외부에서 rowList에 접근 하는 메소드 
	 * @return rowList
	 */
	public ArrayList<Piece> getList() {
		return rowList;
	}

	
	/**
	 * board 클래스에서 색과 말의 종류로 갯수 확인하는 메소드를 돕는 메소드 
	 * @param color 찾고자 하는 색 
	 * @param type 찾고자 하는 말의 종류 
	 * @return row에서 같은 수 
	 */
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

	/**
	 * countByTypeColor 메소드를 돕는 메소드 
	 * @param color
	 * @param type
	 * @return True or False 
	 */
	private boolean isColorTypeSame(Piece piece, Color color, Type type) {
		if (piece.getType() == type && piece.getColor() == color){
			return true;
		}
		else{
			return false;			
		}
	}


	/**
	 * 정해진 위치의 Piece를 바꾸는 것
	 * @param col 정해진 위치 
	 * @param type 바꾸고자 하는 말의 종류 
	 * @param color 말의 색 
	 */

	public void setColumn(int col, Type type, Color color) {
		if (color == BLACK){
			rowList.set(col, Piece.createBlack(type));			
		}
		
		else if (color == WHITE){
			rowList.set(col, Piece.createWhite(type));			
		}
		
		else{
			rowList.set(col, Piece.createEmpty());						
		}
		
	}

	public Piece getColumn(int col) {
		return rowList.get(col);
	}

	/**
	 * board 클래스의 checkPawn메소드에서 pawn의 열 위치와 갯수 확인을 돕는 메소드 
	 * @param color 
	 * @param pawnPosition 
	 * @return pawn의 열의 위치와 숫자 리턴 
	 */
	public HashMap<Integer, Integer> findPawnPosition(Color color, HashMap<Integer, Integer> pawnPosition) {
		int column = 0;//열의 위치를 파악하기 위해서 
		
		//System.out.println(rowList.get(0).getSymbol());
		//System.out.println(pawnPosition);
		for (Piece piece : rowList) {
			if (ispawn(color, piece)){
				if(isContain(pawnPosition, column)){
			//		System.out.println("--시--");
			//		System.out.println("열 "+ column);
					int newVal = pawnPosition.get(column)+1; // value에 +1
			//		System.out.println("변경된 키값 " +newVal);
			//		System.out.println("---끝--");
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

	
	/**
	 * row클래스 checkPawn 메소드에서 if 조건에 대한 메소드 
	 * pawn 클래스인지, 같은 색인지를 물어보는 메소드 
	 * @param color, piece
	 * @return true, false
	 */
	private boolean ispawn(Color color, Piece piece) {
		return piece.getType().equals(PAWN) && piece.getColor().equals(color);
	}


	
	/**
	 * row클래스 checkPawn 메소드에서 if 조건에 대한 메소드 
	 * 열의 위치가 같은지를 물어보는 메소드 
	 * @param pawnPosition
	 * @param column
	 * @return true, false
	 */
	private boolean isContain(HashMap<Integer, Integer> pawnPosition, int column) {
		return pawnPosition.containsKey(column);
	}

}
