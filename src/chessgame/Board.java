package chessgame;

import pieces.Pawn;

import java.util.ArrayList;

/**
 * 체스판 클래스 
 * @author YoungNamLee
 */


public class Board {
	
	static final String NEWLINE = System.getProperty("line.separator");
	public ArrayList<ArrayList<Pawn>> chessBoard = new ArrayList<ArrayList<Pawn>>();
	
	
	/**
	 * 생성자
	 * 체스판 생성 
	 */ 
	public Board(){			
		this.setLow(); //보드판 틀 생성 생성 
		this.setEmptyLine(); //빈공간 생성  
		this.setPawnLine(); //Pawn 정렬 
		}
	
	//보드판 틀 생성 
	public void setLow(){
		for(int row = 0; row < 8 ; row++){ //8행만큼 루프실행 
			chessBoard.add(row, new ArrayList<Pawn>()); //각 행에 열 삽입 
		}	
	}
	
	//빈공간 생성 
	public void setEmptyLine(){
		for(int row = 0 ; row < 8 ; row++){ //8행 만큼 루프 실행 
			for(int colmn = 0; colmn<8 ; colmn++){ //각 열만큼 루프실행   
				chessBoard.get(row).add(colmn, new Pawn(Pawn.EMPTY)); //pawn생성시 EMPTY를 인자로 받는 클래스 생성)  
			}
		}
	}
	
	//Pawn정렬 
	public void setPawnLine(){
		for(int column = 0; column < 8 ; column++){
			chessBoard.get(1).set(column, new Pawn(Pawn.PLAYER_BLACK));//2행 삽입 
			chessBoard.get(6).set(column, new Pawn(Pawn.PLAYER_WHITE));//7행 삽입 
		}
	}

	
	/**
	 * 보드판 출력 
	 * @return 보드판 출력값을 저장하고 있는 boardPrint 
	 */
	public String boardPrint() {
		StringBuilder boardPrint = new StringBuilder();
		
		for(int i = 0 ; i < 8 ; i++){
			for(int j = 0; j<8 ; j++){
				boardPrint.append(chessBoard.get(i).get(j).pawnPrint);
			}
			boardPrint.append(NEWLINE);
		}
		
		return boardPrint.toString();
	}
}
